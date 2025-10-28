package thigk.nguyenhuutrong.ontap_thigiuaky;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Item3Activity extends AppCompatActivity {

    private TextView tvTenMon, tvMoTa, tvTinChi, tvGiangVien;
    private MaterialButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item3);

        tvTenMon = findViewById(R.id.tvTenMon);
        tvMoTa = findViewById(R.id.tvMoTa);
        tvTinChi = findViewById(R.id.tvTinChi);
        tvGiangVien = findViewById(R.id.tvGiangVien);
        btnBack = findViewById(R.id.btnBack3);

        // Lấy dữ liệu tên môn từ intent
        String tenMon = getIntent().getStringExtra("tenMon");
        tvTenMon.setText(tenMon);

        // --- XÓA SWITCH CASE VÀ THAY BẰNG CODE ĐỌC JSON ---

        // Tìm chi tiết môn học từ file list.json
        findMonHocDetails(tenMon);

        // ----------------------------------------------------

        btnBack.setOnClickListener(v -> finish());
    }

    /**
     * Tải file list.json, tìm môn học và cập nhật UI
     * @param tenMonCanTim Tên môn học được gửi từ ActivityChucNang3
     */
    private void findMonHocDetails(String tenMonCanTim) {
        String jsonString;
        try {
            // 1. Đọc file list.json (giống hệt ActivityChucNang3)
            InputStream is = getAssets().open("list.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            jsonString = new String(buffer, StandardCharsets.UTF_8);

        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Lỗi đọc file JSON", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            // 2. Duyệt mảng JSON
            JSONArray jsonArray = new JSONArray(jsonString);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject monHocObject = jsonArray.getJSONObject(i);

                // 3. So sánh tên môn học
                if (monHocObject.getString("tenMon").equals(tenMonCanTim)) {

                    // 4. Tìm thấy! Lấy dữ liệu và gán vào TextView
                    tvMoTa.setText(monHocObject.getString("moTa"));
                    tvTinChi.setText(monHocObject.getString("tinChi"));
                    tvGiangVien.setText(monHocObject.getString("giangVien"));

                    // Dừng vòng lặp vì đã tìm thấy
                    return;
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "Lỗi phân tích JSON", Toast.LENGTH_SHORT).show();
        }
    }
}
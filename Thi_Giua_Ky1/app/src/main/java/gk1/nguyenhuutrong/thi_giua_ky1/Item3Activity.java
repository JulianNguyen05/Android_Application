package gk1.nguyenhuutrong.thi_giua_ky1;

import android.os.Bundle;
import android.widget.ImageView;
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

// Sửa tên class để khớp với XML và Intent
public class Item3Activity extends AppCompatActivity {

    // Sửa lại toàn bộ biến và ID
    private TextView tvTenMonAn, tvMoTa, tvGiaTien, tvNhaHang;
    private ImageView imgMonAn;
    private MaterialButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item3);

        // Sửa ánh xạ ID
        tvTenMonAn = findViewById(R.id.tvTenMonAn);
        tvMoTa = findViewById(R.id.tvMoTa);
        tvGiaTien = findViewById(R.id.tvGiaTien);
        tvNhaHang = findViewById(R.id.tvNhaHang);
        imgMonAn = findViewById(R.id.imgMonAn); // Thêm
        btnBack = findViewById(R.id.btnBack3);

        // Lấy dữ liệu tên món từ intent (sửa key)
        String tenMonAn = getIntent().getStringExtra("tenMonAn");
        tvTenMonAn.setText(tenMonAn);

        // Tìm chi tiết món ăn
        findMonAnDetails(tenMonAn); // Sửa tên hàm

        btnBack.setOnClickListener(v -> finish());
    }

    /**
     * Tải file list.json, tìm món ăn và cập nhật UI
     */
    private void findMonAnDetails(String tenMonAnCanTim) { // Sửa tên hàm
        String jsonString;
        try {
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
            JSONArray jsonArray = new JSONArray(jsonString);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject monAnObject = jsonArray.getJSONObject(i); // Sửa tên

                // So sánh bằng key "tenMonAn"
                if (monAnObject.getString("tenMonAn").equals(tenMonAnCanTim)) {

                    // Gán dữ liệu bằng các key mới
                    tvMoTa.setText(monAnObject.getString("moTa"));
                    tvGiaTien.setText(monAnObject.getString("giaTien"));
                    tvNhaHang.setText(monAnObject.getString("nhaHang"));

                    // (Bạn có thể thêm code load ảnh cho imgMonAn ở đây)

                    return;
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "Lỗi phân tích JSON", Toast.LENGTH_SHORT).show();
        }
    }
}
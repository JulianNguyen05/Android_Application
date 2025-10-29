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

public class Item3Activity extends AppCompatActivity {

    private TextView tvTenMonAn, tvMoTa, tvGiaTien, tvNhaHang;
    private ImageView imgMonAn;
    private MaterialButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item3);

        tvTenMonAn = findViewById(R.id.tvTenMonAn);
        tvMoTa = findViewById(R.id.tvMoTa);
        tvGiaTien = findViewById(R.id.tvGiaTien);
        tvNhaHang = findViewById(R.id.tvNhaHang);
        imgMonAn = findViewById(R.id.imgMonAn);
        btnBack = findViewById(R.id.btnBack3);

        String tenMonAn = getIntent().getStringExtra("tenMonAn");
        tvTenMonAn.setText(tenMonAn);

        findMonAnDetails(tenMonAn);

        btnBack.setOnClickListener(v -> finish());
    }

    private void findMonAnDetails(String tenMonAnCanTim) {
        String jsonString;
        try {
            InputStream is = getAssets().open("list.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            jsonString = new String(buffer, StandardCharsets.UTF_8);

        } catch (IOException e) {
            e.printStackTrace;
            Toast.makeText(this, "Lỗi đọc file JSON", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            JSONArray jsonArray = new JSONArray(jsonString);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject monAnObject = jsonArray.getJSONObject(i);

                if (monAnObject.getString("tenMonAn").equals(tenMonAnCanTim)) {

                    // Gán dữ liệu text
                    tvMoTa.setText(monAnObject.getString("moTa"));
                    tvGiaTien.setText(monAnObject.getString("giaTien"));
                    tvNhaHang.setText(monAnObject.getString("nhaHang"));

                    // === PHẦN CODE TẢI ẢNH TỪ DRAWABLE ===
                    try {
                        String hinhAnhName = monAnObject.getString("hinhAnh");

                        // Lấy ID của ảnh từ tên tệp (đã lưu trong JSON)
                        int imageResId = getResources().getIdentifier(
                                hinhAnhName,
                                "drawable",
                                getPackageName()
                        );

                        // Nếu tìm thấy ảnh (ID != 0)
                        if (imageResId != 0) {
                            imgMonAn.setImageResource(imageResId);
                        } else {
                            // Nếu không tìm thấy, đặt ảnh mặc định
                            // (Bạn cần thêm 1 ảnh tên là 'placeholder_image' vào drawable)
                            // imgMonAn.setImageResource(R.drawable.placeholder_image);
                        }

                    } catch (JSONException e) {
                        // Trường hợp JSON không có key "hinhAnh"
                        // imgMonAn.setImageResource(R.drawable.placeholder_image);
                    }
                    // ======================================

                    return; // Dừng tìm kiếm
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "Lỗi phân tích JSON", Toast.LENGTH_SHORT).show();
        }
    }
}
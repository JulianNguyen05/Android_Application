package gk1.nguyenhuutrong.thi_giua_ky1;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class ChiTietBaiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Bạn cũng nên đổi tên file layout này
        setContentView(R.layout.activity_chi_tiet_bai);

        ImageView img = findViewById(R.id.imgDetail);
        TextView tvTitle = findViewById(R.id.tvTitleDetail);
        TextView tvDesc = findViewById(R.id.tvDescDetail);
        MaterialButton btnBack = findViewById(R.id.btnBack);

        // Nhận dữ liệu (logic giữ nguyên)
        int imageRes = getIntent().getIntExtra("image", 0);
        String title = getIntent().getStringExtra("title");
        String desc = getIntent().getStringExtra("desc");

        img.setImageResource(imageRes);
        tvTitle.setText(title);
        tvDesc.setText(desc);

        btnBack.setOnClickListener(v -> finish());
    }
}
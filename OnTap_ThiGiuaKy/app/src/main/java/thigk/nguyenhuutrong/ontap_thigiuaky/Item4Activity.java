package thigk.nguyenhuutrong.ontap_thigiuaky;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class Item4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item4);

        ImageView img = findViewById(R.id.imgDetail);
        TextView tvTitle = findViewById(R.id.tvTitleDetail);
        TextView tvDesc = findViewById(R.id.tvDescDetail);
        MaterialButton btnBack = findViewById(R.id.btnBack);

        // Nhận dữ liệu từ Intent
        int imageRes = getIntent().getIntExtra("image", 0);
        String title = getIntent().getStringExtra("title");
        String desc = getIntent().getStringExtra("desc");

        img.setImageResource(imageRes);
        tvTitle.setText(title);
        tvDesc.setText(desc);

        btnBack.setOnClickListener(v -> finish());
    }
}
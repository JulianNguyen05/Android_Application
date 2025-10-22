package thigk2.nguyenhuutrong.vidu_intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView; // Thêm thư viện TextView

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    TextView txtHienThi; // Khai báo TextView
    Button btnQuayLai;   // Khai báo Button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        // Ánh xạ các View từ layout
        txtHienThi = findViewById(R.id.txtHienThi);
        btnQuayLai = findViewById(R.id.btnQuayLai); // Sửa từ btnBack

        //1. Nhận về Intent
        Intent iNhanDuoc = getIntent();
        //2. Bóc ra
        String noiDung = iNhanDuoc.getStringExtra("dulieu");
        String banQuyen = iNhanDuoc.getStringExtra("copyright"); // Sửa key "banQuyen" thành "copyright" cho khớp

        //3. Xử lý
        // Set lên textView (Phần code này bị thiếu trong file gốc của bạn)
        if (noiDung != null) {
            txtHienThi.setText(noiDung);
        }

        // Nút back
        btnQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iQuayVe = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(iQuayVe);
            }
        });

    }
}
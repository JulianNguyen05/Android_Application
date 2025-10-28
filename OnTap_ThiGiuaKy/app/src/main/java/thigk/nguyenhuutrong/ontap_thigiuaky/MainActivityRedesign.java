package thigk.nguyenhuutrong.ontap_thigiuaky;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityRedesign extends AppCompatActivity {

    // Khai báo các nút
    private Button btnCN2, btnCN3, btnCN4, btnAbout, btnThem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_redesign);

        // Ánh xạ view
        btnCN2 = findViewById(R.id.btnCN2);
        btnCN3 = findViewById(R.id.btnCN3);
        btnCN4 = findViewById(R.id.btnCN4);
        btnAbout = findViewById(R.id.btnAbout);
        btnThem = findViewById(R.id.btnThem);

        // Xử lý sự kiện nhấn nút
        btnCN2.setOnClickListener(v ->
                startActivity(new Intent(MainActivityRedesign.this, ActivityChucNang2.class))
        );

        btnCN3.setOnClickListener(v ->
                startActivity(new Intent(MainActivityRedesign.this, ActivityChucNang3.class))
        );

        btnCN4.setOnClickListener(v ->
                startActivity(new Intent(MainActivityRedesign.this, ActivityChucNang4.class))
        );

        btnAbout.setOnClickListener(v ->
                startActivity(new Intent(MainActivityRedesign.this, ActivityAboutMe.class))
        );

        btnThem.setOnClickListener(v ->
                startActivity(new Intent(MainActivityRedesign.this, ActivityLamThem.class))
        );
    }
}

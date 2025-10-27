package thigk.nguyenhuutrong.ontap_thigiuaky;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnCN2, btnCN3, btnCN4, btnAbout, btnThem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCN2 = findViewById(R.id.btnCN2);
        btnCN3 = findViewById(R.id.btnCN3);
        btnCN4 = findViewById(R.id.btnCN4);
        btnAbout = findViewById(R.id.btnAbout);
        btnThem = findViewById(R.id.btnThem);

        btnCN2.setOnClickListener(v -> startActivity(new Intent(this, ActivityChucNang2.class)));
//        btnCN3.setOnClickListener(v -> startActivity(new Intent(this, ActivityChucNang3.class)));
//        btnCN4.setOnClickListener(v -> startActivity(new Intent(this, ActivityChucNang4.class)));
//        btnAbout.setOnClickListener(v -> startActivity(new Intent(this, ActivityAboutMe.class)));
//        btnThem.setOnClickListener(v -> startActivity(new Intent(this, ActivityLamThem.class)));

    }
}
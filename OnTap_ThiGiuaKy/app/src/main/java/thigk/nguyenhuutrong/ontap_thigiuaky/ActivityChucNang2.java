package thigk.nguyenhuutrong.ontap_thigiuaky;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityChucNang2 extends AppCompatActivity {
    EditText edtGiuaKy, edtCuoiKy;
    Button btnTinhTB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chucnang2);

        edtGiuaKy = findViewById(R.id.edtGiuaKy);
        edtCuoiKy = findViewById(R.id.edtCuoiKy);
        btnTinhTB = findViewById(R.id.btnTinhTB);

        btnTinhTB.setOnClickListener(v -> {
            try {
                double gk = Double.parseDouble(edtGiuaKy.getText().toString());
                double ck = Double.parseDouble(edtCuoiKy.getText().toString());
                double tb = gk * 0.5 + ck * 0.5;
                Toast.makeText(this, "Điểm TB: " + tb, Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                Toast.makeText(this, "Vui lòng nhập số hợp lệ!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
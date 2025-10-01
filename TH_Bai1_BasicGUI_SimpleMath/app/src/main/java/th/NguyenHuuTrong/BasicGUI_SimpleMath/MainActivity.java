package th.NguyenHuuTrong.BasicGUI_SimpleMath;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edtA, edtB;
    Button btnCong, btnTru, btnNhan, btnChia, btnTinh, btnReset;
    TextView txtKetQua;
    String phepToan = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtA = findViewById(R.id.edt_a);
        edtB = findViewById(R.id.edt_b);
        btnCong = findViewById(R.id.btn_cong);
        btnTru = findViewById(R.id.btn_tru);
        btnNhan = findViewById(R.id.btn_nhan);
        btnChia = findViewById(R.id.btn_chia);
        btnTinh = findViewById(R.id.btn_tinh);
        btnReset = findViewById(R.id.btn_reset);
        txtKetQua = findViewById(R.id.txt_ketQua);

        btnCong.setOnClickListener(v -> phepToan = "+");
        btnTru.setOnClickListener(v -> phepToan = "-");
        btnNhan.setOnClickListener(v -> phepToan = "*");
        btnChia.setOnClickListener(v -> phepToan = "/");

        btnTinh.setOnClickListener(v -> {
            try {
                double a = Double.parseDouble(edtA.getText().toString());
                double b = Double.parseDouble(edtB.getText().toString());
                double kq = 0;

                switch (phepToan) {
                    case "+":
                        kq = a + b;
                        txtKetQua.setText(String.valueOf(kq));
                        break;
                    case "-":
                        kq = a - b;
                        txtKetQua.setText(String.valueOf(kq));
                        break;
                    case "*":
                        kq = a * b;
                        txtKetQua.setText(String.valueOf(kq));
                        break;
                    case "/":
                        if (b == 0) {
                            Toast.makeText(this, "Không chia được cho 0", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        kq = a / b;
                        txtKetQua.setText(String.valueOf(kq));
                        break;
                    default:
                        Toast.makeText(this, "Vui lòng chọn phép toán!", Toast.LENGTH_SHORT).show();
                }

            } catch (Exception e) {
                Toast.makeText(this, "Vui lòng nhập số hợp lệ!", Toast.LENGTH_SHORT).show();
            }
        });

        btnReset.setOnClickListener(v -> {


            edtA.setText("");
            edtB.setText("");
            txtKetQua.setText("");
            phepToan = "";
            resetButtons();
        });
    }

    private void resetButtons(){
        int defaultColor = Color.parseColor("2196F3");

        btnCong.setAlpha(0.5f);
        btnCong.setBackgroundTintList(ColorStateList.valueOf(defaultColor));

        btnTru.setAlpha(0.5f);
        btnTru.setBackgroundTintList(ColorStateList.valueOf(defaultColor));

        btnNhan.setAlpha(0.5f);
        btnNhan.setBackgroundTintList(ColorStateList.valueOf(defaultColor));

        btnChia.setAlpha(0.5f);
        btnChia.setBackgroundTintList(ColorStateList.valueOf(defaultColor));
    }

}
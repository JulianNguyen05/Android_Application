package thigk2.nguyenhuutrong.vidu_intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button nutChuyen2 = findViewById(R.id.btnChuyen2);
        nutChuyen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code chuyển màn hình sẽ được thêm vào đây
                // 1. Tạo Intent
                Intent iChuyen2 = new Intent(MainActivity.this, SecondActivity.class);
                // 2. Gọi dữ liệu vào iChuyen2
                    // 2.1 Lấy dữ liệu
                    EditText edtNoiDung = findViewById(R.id.edtNoiDung);
                    String noiDung = edtNoiDung.getText().toString();
                    // 2.2 Gắn dữ liệu vào Intent, dùng put??Extra(key, value)
                    iChuyen2.putExtra("dulieu", noiDung);
                    iChuyen2.putExtra("copyright", "Nguyen Huu Trong");
                // 3. Thực hiện chuyển màn hình
                startActivity(iChuyen2);
            }
        });

    }
}
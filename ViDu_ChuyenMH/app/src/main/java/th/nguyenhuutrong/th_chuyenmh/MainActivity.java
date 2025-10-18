package th.nguyenhuutrong.th_chuyenmh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void ChuyenSangMH2(View v){
        // 1. Tạo đối tượng Intent
        Intent thuKichHoatMH2;

            // Hàm tạo có 2 tham số, tham số 2 là màn hình chuyển tới (.class)
        thuKichHoatMH2 = new Intent(MainActivity.this,  // Màn hình hiện tại
                                        MainActivity2.class);         // Màn hình chuyển tới

        // 2. Gửi thư, mà không đợi phản hồi
        startActivity(thuKichHoatMH2);
    }
}
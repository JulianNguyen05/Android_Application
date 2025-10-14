package th.nguyenhuutrong.th_chuyenmh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Xây dựng bộ lắng nghe và xử lý theo cách khác
        // Chú ý: ta có thể làm theo cách giống màn hình 1

        // Cách khác ở đây
        // 1. Tìm đối tượng cần gắn bộ lắng nghe

        Button btnManHinh2 = findViewById(R.id.btnMH2);

        // 2. Gắn bộ lắng nghe

        btnManHinh2.setOnClickListener(BoLangNgheChuyenMH); // Ta sẽ code ngay dưới
    }

    // Đây nhé, ngoài hàm onCreate

    View.OnClickListener BoLangNgheChuyenMH = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Xử lý
            // 1. Tạo thư
            Intent thuKichHoatMH1 = new Intent(MainActivity2.this, MainActivity.class);
            // 2. Gửi đi
            startActivity(thuKichHoatMH1);
        }
    };
}
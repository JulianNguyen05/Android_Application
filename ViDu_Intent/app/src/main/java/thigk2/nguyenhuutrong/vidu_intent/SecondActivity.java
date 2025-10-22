package thigk2.nguyenhuutrong.vidu_intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        //1. Nhận về Inrent
        Intent iNhanDuoc = getIntent();
        //2. Bóc ra
        String noiDung = iNhanDuoc.getStringExtra("dulieu");
        String banQuyen = iNhanDuoc.getStringExtra("copyright");
        //3. Xử lý
            // Set lên textView

        // Nút back
        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iQuayVe = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(iQuayVe);
            }
        });

    }
}
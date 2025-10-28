package thigk.nguyenhuutrong.ontap_thigiuaky;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.button.MaterialButton;

public class ActivityAboutMe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me); // Sử dụng layout mới ở trên

        // Cài đặt Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Thêm nút back
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        // Ánh xạ các nút liên hệ
        MaterialButton btnGithub = findViewById(R.id.btn_github);
        MaterialButton btnEmail = findViewById(R.id.btn_email);
        MaterialButton btnPhone = findViewById(R.id.btn_phone);

        // Xử lý sự kiện click
        btnGithub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy từ prompt của bạn
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/JulianNguyen05"));
                startActivity(browserIntent);
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Dữ liệu từ CV [cite: 6]
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:huutrong.160705@gmail.com"));
                startActivity(Intent.createChooser(emailIntent, "Send email"));
            }
        });

        btnPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Dữ liệu từ CV [cite: 4]
                Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:0935918965"));
                startActivity(dialIntent);
            }
        });
    }

    // Xử lý khi người dùng nhấn nút back trên toolbar
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}

package thigk.nguyenhuutrong.ontap_thigiuaky;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

// 1. Import lớp Binding được tạo tự động từ file activity_main_redesign.xml
import thigk.nguyenhuutrong.ontap_thigiuaky.databinding.ActivityMainRedesignBinding;

// 2. Tên lớp khớp với tools:context trong file XML
public class MainActivityRedesign extends AppCompatActivity {

    // 3. Khai báo biến binding
    private ActivityMainRedesignBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 4. Khởi tạo binding
        binding = ActivityMainRedesignBinding.inflate(getLayoutInflater());

        // 5. Set layout bằng view gốc của binding
        setContentView(binding.getRoot());

        // 6. Gọi hàm gán sự kiện click
        setupButtonListeners();
    }

    private void setupButtonListeners() {

        // Gán sự kiện cho Nút Chức năng 2
        binding.btnCN2.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivityRedesign.this, ActivityChucNang2.class);
            startActivity(intent);
        });

        // Gán sự kiện cho Nút Chức năng 3
        binding.btnCN3.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivityRedesign.this, ActivityChucNang3.class);
            startActivity(intent);
        });

        // Gán sự kiện cho Nút Chức năng 4
        binding.btnCN4.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivityRedesign.this, ActivityChucNang4.class);
            startActivity(intent);
        });

        // Gán sự kiện cho Nút About Me
        binding.btnAbout.setOnClickListener(v -> {
            // Giả sử Activity của bạn tên là AboutMeActivity
            // Intent intent = new Intent(MainActivity_Redesign.this, AboutMeActivity.class);
            // startActivity(intent);
        });

        // Gán sự kiện cho Nút Làm thêm
        binding.btnThem.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivityRedesign.this, ActivityLamThem.class);
            startActivity(intent);
        });
    }
}
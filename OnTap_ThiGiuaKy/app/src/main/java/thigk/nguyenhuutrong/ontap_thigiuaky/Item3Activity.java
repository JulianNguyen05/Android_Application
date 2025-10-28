package thigk.nguyenhuutrong.ontap_thigiuaky;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class Item3Activity extends AppCompatActivity {

    private TextView tvTenMon, tvMoTa, tvTinChi, tvGiangVien;
    private MaterialButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item3);

        tvTenMon = findViewById(R.id.tvTenMon);
        tvMoTa = findViewById(R.id.tvMoTa);
        tvTinChi = findViewById(R.id.tvTinChi);
        tvGiangVien = findViewById(R.id.tvGiangVien);
        btnBack = findViewById(R.id.btnBack3);

        // Lấy dữ liệu từ intent
        String tenMon = getIntent().getStringExtra("tenMon");
        tvTenMon.setText(tenMon);

        // Gán mô tả mẫu theo môn học
        switch (tenMon) {
            case "Lập trình Android":
                tvMoTa.setText("Học cách phát triển ứng dụng di động trên Android với Java/Kotlin.");
                tvTinChi.setText("3 tín chỉ");
                tvGiangVien.setText("GV: Nguyễn Văn A");
                break;

            case "Cơ sở dữ liệu":
                tvMoTa.setText("Học về thiết kế và quản trị hệ thống cơ sở dữ liệu, SQL và truy vấn nâng cao.");
                tvTinChi.setText("3 tín chỉ");
                tvGiangVien.setText("GV: Trần Thị B");
                break;

            case "Trí tuệ nhân tạo":
                tvMoTa.setText("Khám phá nền tảng AI, Machine Learning và các thuật toán học máy cơ bản.");
                tvTinChi.setText("4 tín chỉ");
                tvGiangVien.setText("GV: Lê Minh C");
                break;

            case "Mạng máy tính":
                tvMoTa.setText("Học về cấu trúc mạng, mô hình OSI và giao thức TCP/IP.");
                tvTinChi.setText("3 tín chỉ");
                tvGiangVien.setText("GV: Phạm Thị D");
                break;

            case "Phân tích thiết kế hệ thống":
                tvMoTa.setText("Rèn luyện kỹ năng mô hình hóa hệ thống thông tin, sử dụng UML.");
                tvTinChi.setText("3 tín chỉ");
                tvGiangVien.setText("GV: Vũ Văn E");
                break;

            default:
                tvMoTa.setText("Môn học khác trong chương trình đào tạo CNTT.");
                tvTinChi.setText("2 tín chỉ");
                tvGiangVien.setText("GV: Nguyễn Thị F");
        }

        btnBack.setOnClickListener(v -> finish());
    }
}

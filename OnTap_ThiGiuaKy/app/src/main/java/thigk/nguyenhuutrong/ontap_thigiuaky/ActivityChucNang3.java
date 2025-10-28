package thigk.nguyenhuutrong.ontap_thigiuaky;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ActivityChucNang3 extends AppCompatActivity {

    private ListView lvMonHoc;
    private ArrayList<String> dsMonHoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chucnang3);

        lvMonHoc = findViewById(R.id.lvMonHoc);

        // 1️⃣ Danh sách dữ liệu mẫu
        dsMonHoc = new ArrayList<>();
        dsMonHoc.add("Lập trình Android");
        dsMonHoc.add("Cơ sở dữ liệu");
        dsMonHoc.add("Trí tuệ nhân tạo");
        dsMonHoc.add("Mạng máy tính");
        dsMonHoc.add("Phân tích thiết kế hệ thống");
        dsMonHoc.add("An toàn thông tin");

        // 2️⃣ Adapter đơn giản
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dsMonHoc
        );
        lvMonHoc.setAdapter(adapter);

        // 3️⃣ Sự kiện click vào 1 môn học
        lvMonHoc.setOnItemClickListener((AdapterView<?> parent, android.view.View view, int position, long id) -> {
            String monHoc = dsMonHoc.get(position);

            // Mở sang Item3Activity
            Intent intent = new Intent(ActivityChucNang3.this, Item3Activity.class);
            intent.putExtra("tenMon", monHoc);
            startActivity(intent);
        });
    }
}

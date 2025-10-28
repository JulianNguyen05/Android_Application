package thigk.nguyenhuutrong.ontap_thigiuaky;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ActivityChucNang4 extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Activity4Adapter adapter;
    private List<Activity4Model> activityList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chucnang4);

        recyclerView = findViewById(R.id.recyclerView);

        // 1️⃣ Tạo dữ liệu mẫu
        activityList = new ArrayList<>();
        activityList.add(new Activity4Model(R.drawable.img_event1, "Tiêu đề hoạt động 1", "Ngày 30/4 - Kỷ niệm chiến thắng"));
        activityList.add(new Activity4Model(R.drawable.img_event2, "Tiêu đề hoạt động 2", "Ngày 1/5 - Quốc tế Lao động"));
        activityList.add(new Activity4Model(R.drawable.img_event3, "Tiêu đề hoạt động 3", "Ngày 19/5 - Sinh nhật Bác Hồ"));
        activityList.add(new Activity4Model(R.drawable.img_event4, "Tiêu đề hoạt động 4", "Ngày 2/9 - Quốc khánh Việt Nam"));

        // 2️⃣ Gắn layout cho RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // 3️⃣ Gắn adapter
        adapter = new Activity4Adapter(activityList, new Activity4Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull Activity4Model item) {
                // 4️⃣ Khi click vào 1 mục, chuyển sang Item4Activity
                Intent intent = new Intent(ActivityChucNang4.this, Item4Activity.class);
                intent.putExtra("title", item.getTitle());
                intent.putExtra("desc", item.getDescription());
                intent.putExtra("image", item.getImageResId());
                startActivity(intent);

                // Có thể hiện thêm thông báo nhỏ
                Toast.makeText(ActivityChucNang4.this, "Đang mở: " + item.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(adapter);
    }
}
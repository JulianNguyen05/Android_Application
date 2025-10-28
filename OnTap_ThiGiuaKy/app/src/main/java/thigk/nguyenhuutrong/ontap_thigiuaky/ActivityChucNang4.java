package thigk.nguyenhuutrong.ontap_thigiuaky;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
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

        // 1️⃣ Tải dữ liệu từ file assets/activities.json
        activityList = loadActivitiesFromAssets();

        // Kiểm tra nếu tải lỗi
        if (activityList.isEmpty()) {
            Toast.makeText(this, "Không thể tải dữ liệu hoạt động", Toast.LENGTH_SHORT).show();
            // Thêm item lỗi để người dùng biết
            activityList.add(new Activity4Model(R.drawable.ic_event_placeholder, "Lỗi tải JSON", "Không thể đọc file activities.json"));
        }

        // 2️⃣ Gắn layout cho RecyclerView (Giữ nguyên)
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // 3️⃣ Gắn adapter (Giữ nguyên)
        adapter = new Activity4Adapter(activityList, new Activity4Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull Activity4Model item) {
                // 4️⃣ Khi click (Giữ nguyên)
                Intent intent = new Intent(ActivityChucNang4.this, Item4Activity.class);
                intent.putExtra("title", item.getTitle());
                intent.putExtra("desc", item.getDescription());
                intent.putExtra("image", item.getImageResId());
                startActivity(intent);

                Toast.makeText(ActivityChucNang4.this, "Đang mở: " + item.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(adapter);
    }

    /**
     * Hàm đọc file JSON từ thư mục assets và phân tích thành List<Activity4Model>
     * @return Danh sách các hoạt động
     */
    private List<Activity4Model> loadActivitiesFromAssets() {
        List<Activity4Model> models = new ArrayList<>();
        String jsonString;

        try {
            // 1. Mở file "activities.json" từ thư mục assets
            InputStream is = getAssets().open("recycle.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            jsonString = new String(buffer, StandardCharsets.UTF_8);

        } catch (IOException e) {
            e.printStackTrace();
            return models; // Trả về danh sách rỗng nếu lỗi
        }

        try {
            // 2. Phân tích chuỗi JSON thành Mảng
            JSONArray jsonArray = new JSONArray(jsonString);

            // 3. Duyệt mảng và tạo đối tượng
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);

                String imageName = obj.getString("imageName");
                String title = obj.getString("title");
                String description = obj.getString("description");

                // 4. Chuyển đổi tên ảnh (String) thành ID (int)
                int imageResId = getDrawableIdByName(imageName);

                // 5. Thêm vào danh sách
                models.add(new Activity4Model(imageResId, title, description));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return models;
    }

    /**
     * Hàm tiện ích: Chuyển đổi tên drawable (String) thành ID (int)
     * @param name Tên của file drawable (ví dụ: "img_event1")
     * @return ID của drawable (ví dụ: R.drawable.img_event1)
     */
    private int getDrawableIdByName(String name) {
        // getIdentifier (tên, loại, package)
        int resId = getResources().getIdentifier(name, "drawable", getPackageName());

        // Nếu không tìm thấy, trả về ảnh mặc định
        if (resId == 0) {
            return R.drawable.ic_event_placeholder;
        }
        return resId;
    }
}
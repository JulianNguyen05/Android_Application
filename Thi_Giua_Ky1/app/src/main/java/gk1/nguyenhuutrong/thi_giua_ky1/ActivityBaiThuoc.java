package gk1.nguyenhuutrong.thi_giua_ky1;

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

// Đã đổi tên class từ ActivityChucNang4 sang ActivityBaiThuoc
public class ActivityBaiThuoc extends AppCompatActivity {

    private RecyclerView recyclerView;
    // Đã đổi tên Adapter và Model
    private BaiThuocAdapter adapter;
    private List<BaiThuocModel> baiThuocList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai_thuoc);

        recyclerView = findViewById(R.id.recyclerView);

        baiThuocList = loadBaiThuocFromAssets();

        if (baiThuocList.isEmpty()) {
            Toast.makeText(this, "Không thể tải dữ liệu bài thuốc", Toast.LENGTH_SHORT).show();
            baiThuocList.add(new BaiThuocModel(R.drawable.ic_launcher_foreground, "Lỗi tải JSON", "Không thể đọc file JSON"));
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Đã đổi sang BaiThuocAdapter và BaiThuocModel
        adapter = new BaiThuocAdapter(baiThuocList, new BaiThuocAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaiThuocModel item) {
                // Đã đổi tên Activity đích sang BaiThuocDetailActivity
                Intent intent = new Intent(ActivityBaiThuoc.this, ChiTietBaiActivity.class);
                intent.putExtra("title", item.getTitle());
                intent.putExtra("desc", item.getDescription());
                intent.putExtra("image", item.getImageResId());
                startActivity(intent);

                // Đã đổi context
                Toast.makeText(ActivityBaiThuoc.this, "Đang mở: " + item.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(adapter);
    }

    /**
     * Hàm đọc file JSON và phân tích thành List<BaiThuocModel>
     */
    // Đã đổi tên hàm và kiểu trả về
    private List<BaiThuocModel> loadBaiThuocFromAssets() {
        // Đã đổi kiểu List
        List<BaiThuocModel> models = new ArrayList<>();
        String jsonString;

        try {
            // !!! LƯU Ý: Bạn nên đổi tên file JSON này cho phù hợp
            // (ví dụ: "bai_thuoc.json")
            InputStream is = getAssets().open("recycle.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            jsonString = new String(buffer, StandardCharsets.UTF_8);

        } catch (IOException e) {
            e.printStackTrace();
            return models;
        }

        try {
            JSONArray jsonArray = new JSONArray(jsonString);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);

                String imageName = obj.getString("imageName");
                String title = obj.getString("title");
                String description = obj.getString("description");

                int imageResId = getDrawableIdByName(imageName);

                // Đã đổi sang BaiThuocModel
                models.add(new BaiThuocModel(imageResId, title, description));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return models;
    }

    /**
     * Hàm tiện ích: Chuyển đổi tên drawable (String) thành ID (int)
     */
    private int getDrawableIdByName(String name) {
        int resId = getResources().getIdentifier(name, "drawable", getPackageName());
        if (resId == 0) {
            return R.drawable.ic_launcher_foreground;
        }
        return resId;
    }
}
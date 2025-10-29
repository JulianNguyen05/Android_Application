package gk1.nguyenhuutrong.thi_giua_ky1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class ActivityMonAn extends AppCompatActivity {

    private ListView lvMonAn;
    private ArrayList<String> dsMonAn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_an);

        lvMonAn = findViewById(R.id.lvMonAn);

        dsMonAn = loadMonAnFromAssets();

        if (dsMonAn.isEmpty()) {
            Toast.makeText(this, "Không thể tải dữ liệu món ăn", Toast.LENGTH_SHORT).show();
            dsMonAn.add("Lỗi tải file JSON");
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.item_sub_list_view,
                R.id.tv_item_name,
                dsMonAn
        );
        lvMonAn.setAdapter(adapter);

        lvMonAn.setOnItemClickListener((AdapterView<?> parent, android.view.View view, int position, long id) -> {
            String monAn = dsMonAn.get(position);

            Toast.makeText(ActivityMonAn.this, "Bạn đã chọn: " + monAn, Toast.LENGTH_LONG).show();

            Intent intent = new Intent(ActivityMonAn.this, ChiTietMonActivity.class);
            intent.putExtra("tenMonAn", monAn);
            startActivity(intent);
        });
    }

    /**
     * Hàm đọc file JSON từ assets
     */
    private ArrayList<String> loadMonAnFromAssets() {
        ArrayList<String> monAnList = new ArrayList<>();
        String jsonString;

        try {
            InputStream is = getAssets().open("list.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            jsonString = new String(buffer, StandardCharsets.UTF_8);

        } catch (IOException e) {
            e.printStackTrace();
            return monAnList;
        }

        try {
            JSONArray jsonArray = new JSONArray(jsonString);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject monAnObject = jsonArray.getJSONObject(i);


                String tenMonAn = monAnObject.getString("tenMonAn");
                monAnList.add(tenMonAn);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return monAnList;
    }
}
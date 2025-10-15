package th.nguyenhuutrong.th_lv_danhsachtinhthanh;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Hiển thị dữ liệu lên ListView
        // B1+: Cần có dữ liệu
        //  ?? từ đâu có: từ cơ sở dữ liệu (SQL, noSQL, XML,..)
        // ở bài này, chúng ta hard-code dữ liệu trực tiếp
        // Cần biến phù hợp để chứa dữ liệu
        ArrayList<String> dsTenTT;      // Khai báo
        dsTenTT = new ArrayList<String>();    // Khởi tạo

            // Thêm dữ liệu ở đây (đúng ra, ta phải đọc từ 1 nguồn)
            // Nhưng ta hard-code (cho sẵn để demo)
        dsTenTT.add("Hà Nội");
        dsTenTT.add("Thành phố Hồ Chí Minh");
        dsTenTT.add("Đồng Nai");
        dsTenTT.add("Bình THuận");
        dsTenTT.add("Ninh Thuận");
        dsTenTT.add("Nha Trang");

        // B2. Tạo adapter
        ArrayAdapter<String> adapterTT = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dsTenTT);

        // B3. Gắn vào điều khiển hiển thị ListView
        // 3.1 Tìm
        ListView lvTenTT = findViewById(R.id.lvDanhSachTT);
        // 3.2 Gắn
        lvTenTT.setAdapter(adapterTT);
        // 3.3 Lắng nghe và xử lý sự kiện user tương tác
        // để sau


    }
}
package th.nguyenhuutrong.th_lv_danhsachtinhthanh;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> dsTenTT;      // Khai báo

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
        // gắn bộ lắng nghe vào
        lvTenTT.setOnItemClickListener(BoLangNghevaXL);
    }

    // Tạo bộ lắng nghe và xử lý sự kiện OnItemClick, đặt vào 1 biến
    // Vd: BoLangNghevaXL
    AdapterView.OnItemClickListener BoLangNghevaXL = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // Code xử lý ở đây
            // position là vị trí phần tử vừa được click
            // ví dụ xử lý ở đây, là hiện lên màn hình một thông báo nhanh về vị trí của phần tử vừa chọn
            Toast.makeText(MainActivity.this, "Bạn vừa chọn: " + String.valueOf(position), Toast.LENGTH_SHORT).show();

            // ViDu khác: lấy giá trị của phần tử thứ i
            String strTT = dsTenTT.get(position);
            Toast.makeText(MainActivity.this, "Bạn vừa chọn: " + strTT, Toast.LENGTH_SHORT).show();
        }
    };
}
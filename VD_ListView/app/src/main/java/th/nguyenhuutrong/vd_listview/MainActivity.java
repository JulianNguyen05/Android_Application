package th.nguyenhuutrong.vd_listview;

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

    ListView lvNYC;
    ArrayList<String> lstNYC;
    ArrayAdapter<String> nycAdapter;

    void TimDK(){
        lvNYC = findViewById(R.id.lvNYC);
    }

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
        TimDK();

        // Chuẩn bị nguồn dữ liệu hiện thị
        // --Khai báo
        lstNYC = new ArrayList<String>();
        // Lấy dữ liệu đưa vào lstNYC
        // ---- LẤY Ở ĐÂU = file, database, internet(cloud), ...
        lstNYC = getData();
        //--- Tạo adapter
        nycAdapter = new ArrayAdapter<String>(this,
                                                android.R.layout.simple_list_item_1,
                                                lstNYC);

        // Gắn adapter
        lvNYC.setAdapter(nycAdapter);
        lvNYC.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Xử lý việc chọn Item ở đây
                // biến position chứa vị trí của Item được chọn
                // Lấy giá trị của cái phần tử được chọn
                    // Cách 1: Lấy gián tiếp từ adapter
                    String nycDuocChon = nycAdapter.getItem(position).toString();
                    // Cách 2: Lấy trực tiếp từ biến chứa danh sách
                    String nycDuocChon1 = lstNYC.get(position);
                // Làm gì với nó thì tùy bài toán
                String thongBao = "Bạn đã chọn gặp lại NYC: " + nycDuocChon;
                Toast.makeText(MainActivity.this, thongBao, Toast.LENGTH_SHORT).show();
            }
        });
    }

    ArrayList<String> getData(){
        // Code đọc dữ liệu và cất vào biến tạm, trước khi return
        ArrayList<String> dsTam = new ArrayList<String>();
        // Code ở đây
        // Bài này, ta hard-code, ta fake dữ liệu tại đây cho nhanh
        dsTam.add("Tiểu Vy");
        dsTam.add("Lâm Tâm Như");
        dsTam.add("Yassuo");
        return dsTam;
    }


}
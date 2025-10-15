package th.nguyenhuutrong.vd_listview;

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

    ListView lvNYC;

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
        ArrayList<String> lstNYC = new ArrayList<String>();
        // Lấy dữ liệu đưa vào lstNYC
        // ---- LẤY Ở ĐÂU = file, database, internet(cloud), ...
        lstNYC = getData();
        //--- Tạo adapter
        ArrayAdapter<String> nycAdapter;

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
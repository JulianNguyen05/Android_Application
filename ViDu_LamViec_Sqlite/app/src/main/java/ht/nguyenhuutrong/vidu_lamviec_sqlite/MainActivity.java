package ht.nguyenhuutrong.vidu_lamviec_sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.sql.SQLData;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Tạo CSDL
        db = openOrCreateDatabase("books.db", MODE_PRIVATE, null);
        // Tạo bảng book
//        String sqlXoaBang = "DROP TABLE IF EXISTS BOOKS";
//        String sqlTaoBang = "CREATE TABLE BOOKS(BookID integer PRIMARY KEY, BookName text, Page integer, Price Float, Description text)";
//
//        db.execSQL(sqlXoaBang);
//        db.execSQL(sqlTaoBang);
//
//        // Thêm
//        String sqlThem1 = "INSERT INTO BOOKS VALUES(1, 'Java', 100, 9.99, 'sách về java')";
//        String sqlThem2 = "INSERT INTO BOOKS VALUES(2, 'Android', 320, 19.00, 'Android cơ bản')";
//        String sqlThem3 = "INSERT INTO BOOKS VALUES(3, 'Học làm giàu', 120, 0.99, 'sách đọc cho vui')";
//
//        db.execSQL(sqlThem1);
//        db.execSQL(sqlThem2);
//        db.execSQL(sqlThem3);

        // Truy vấn
        String sqlSelectAll = "SELECT * FROM BOOKS";
        Cursor resultSet = db.rawQuery(sqlSelectAll, null);
        ArrayList<String> dsTenSach = new ArrayList<>();
        resultSet.moveToFirst();
        while(true){
            // Lấy dữ liệu
            int maSach = resultSet.getInt(0);
            String tenSach =  resultSet.getString(1);
            int soTrang = resultSet.getInt(2);
            float giaBan = resultSet.getFloat(3);
            String moTa =   resultSet.getString(4);

            // Dùng 1 danh sách
            // Dùng 1 arrayList<String> để chứa tên sách
            dsTenSach.add(tenSach);
            // Di chuyen den ban ghi tiep
            if(resultSet.moveToNext() == false) break;
        }




        // Test
        db.close();

        // Hiện len lv
        ListView listView = findViewById(R.id.lvDanhSachTenSach);
        ArrayAdapter<String> adapterTenSach = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, dsTenSach);

        listView.setAdapter(adapterTenSach);


    }
}
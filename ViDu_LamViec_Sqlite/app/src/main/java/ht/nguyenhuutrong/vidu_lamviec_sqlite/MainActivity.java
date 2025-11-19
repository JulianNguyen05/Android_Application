package ht.nguyenhuutrong.vidu_lamviec_sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Gọi hàm lấy danh sách (Kiểu dữ liệu phải là BOOKS)
        ArrayList<BOOKS> dsSach = getListBooks();

        // 2. Hiện lên ListView
        ListView listView = findViewById(R.id.lvDanhSachTenSach);

        // Adapter phải nhận kiểu BOOKS
        ArrayAdapter<BOOKS> adapterTenSach = new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                dsSach
        );

        listView.setAdapter(adapterTenSach);
    }

    // Đổi tên hàm thành getListBooks cho đúng ý nghĩa trả về đối tượng
    ArrayList<BOOKS> getListBooks() {
        ArrayList<BOOKS> dsKetQua = new ArrayList<>();

        try {
            db = openOrCreateDatabase("books.db", MODE_PRIVATE, null);

            // Tạo bảng và thêm dữ liệu mẫu nếu chưa có (để tránh crash khi chạy lần đầu)
            String sqlTaoBang = "CREATE TABLE IF NOT EXISTS BOOKS(BookID integer PRIMARY KEY, BookName text, Page integer, Price Float, Description text)";
            db.execSQL(sqlTaoBang);

            // Query dữ liệu
            String sqlSelectAll = "SELECT * FROM BOOKS";
            Cursor resultSet = db.rawQuery(sqlSelectAll, null);

            // --- SỬA LỖI VÒNG LẶP ---
            // Sử dụng moveToNext() là cách chuẩn nhất.
            // Nó tự động xử lý trường hợp bảng rỗng (không crash app)
            while (resultSet.moveToNext()) {
                int maSach = resultSet.getInt(0);
                String tenSach = resultSet.getString(1);
                int soTrang = resultSet.getInt(2);
                float giaBan = resultSet.getFloat(3);
                String moTa = resultSet.getString(4);

                BOOKS b = new BOOKS(maSach, soTrang, tenSach, moTa, giaBan);

                // Chỉ add đối tượng b, KHÔNG add chuỗi tenSach vào đây
                dsKetQua.add(b);
            }

            // Nhớ đóng cursor và db
            resultSet.close();
            db.close();

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Lỗi CSDL: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        return dsKetQua;
    }
}
package ht.nguyenhuutrong.vidu_lamviec_sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    ArrayList<BOOKS> dsSach;
    ArrayAdapter<BOOKS> adapterTenSach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Mở CSDL ngay khi App chạy và giữ kết nối
        initDatabase();

        // 2. Lấy dữ liệu lên List
        dsSach = getListBooks();

        // 3. Cấu hình Adapter
        ListView listView = findViewById(R.id.lvDanhSachTenSach);
        adapterTenSach = new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                dsSach
        );
        listView.setAdapter(adapterTenSach);

        // 4. Xử lý sự kiện nút Thêm
        Button bThem = findViewById(R.id.btnThemSach);
        bThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edTenSach = findViewById(R.id.edtTenSach);
                EditText edGiaBan = findViewById(R.id.edtGiaBan);

                String tenSach = edTenSach.getText().toString();
                String strGiaBan = edGiaBan.getText().toString();

                // Kiểm tra dữ liệu rỗng để tránh crash
                if (tenSach.isEmpty() || strGiaBan.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }

                float giaBan = Float.parseFloat(strGiaBan);

                // BƯỚC 1: Thêm vào Database (SQLite)
                ContentValues row = new ContentValues();
                row.put("BookName", tenSach);
                row.put("Price", giaBan);
                row.put("Page", 0);
                row.put("Description", "");

                // db.insert trả về ID của dòng vừa thêm (rất quan trọng)
                long newID = db.insert("BOOKS", null, row);

                if (newID == -1) {
                    Toast.makeText(MainActivity.this, "Thêm thất bại", Toast.LENGTH_SHORT).show();
                } else {
                    // BƯỚC 2: Cập nhật vào ArrayList trên RAM (để List hiển thị ngay)
                    // Tạo đối tượng sách mới với ID vừa lấy được từ Database
                    BOOKS bookMoi = new BOOKS((int)newID, 0, tenSach, "", giaBan);
                    dsSach.add(bookMoi);

                    // BƯỚC 3: Báo Adapter cập nhật lại giao diện
                    adapterTenSach.notifyDataSetChanged();

                    // Xóa trắng ô nhập
                    edTenSach.setText("");
                    edGiaBan.setText("");
                    Toast.makeText(MainActivity.this, "Thêm thành công!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Hàm khởi tạo database riêng để code gọn hơn
    void initDatabase() {
        db = openOrCreateDatabase("books.db", MODE_PRIVATE, null);
        String sqlTaoBang = "CREATE TABLE IF NOT EXISTS BOOKS(BookID integer PRIMARY KEY AUTOINCREMENT, BookName text, Page integer, Price Float, Description text)";
        db.execSQL(sqlTaoBang);
    }

    ArrayList<BOOKS> getListBooks() {
        ArrayList<BOOKS> dsKetQua = new ArrayList<>();

        Cursor resultSet = db.rawQuery("SELECT * FROM BOOKS", null);

        while (resultSet.moveToNext()) {
            int maSach = resultSet.getInt(0);
            String tenSach = resultSet.getString(1);
            int soTrang = resultSet.getInt(2);
            float giaBan = resultSet.getFloat(3);
            String moTa = resultSet.getString(4);

            BOOKS b = new BOOKS(maSach, soTrang, tenSach, moTa, giaBan);
            dsKetQua.add(b);
        }
        resultSet.close();
        return dsKetQua;
    }

    @Override
    protected void onDestroy() {
        // Chỉ đóng database khi tắt App hoàn toàn
        if (db != null && db.isOpen()) {
            db.close();
        }
        super.onDestroy();
    }
}
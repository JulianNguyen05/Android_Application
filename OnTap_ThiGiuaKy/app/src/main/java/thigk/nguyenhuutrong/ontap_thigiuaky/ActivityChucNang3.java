package thigk.nguyenhuutrong.ontap_thigiuaky;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ActivityChucNang3 extends Activity {

    // 1. Khai báo
    ListView lvMonHoc;
    String[] dsMonHoc;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chucnang3);

        // 2. Ánh xạ
        lvMonHoc = findViewById(R.id.lvMonHoc);

        // 3. Chuẩn bị dữ liệu
        dsMonHoc = new String[] {
                "Tin học đại cương",
                "Lập trình Java",
                "Phát triển Ứng dụng web",
                "Khai phá dữ liệu lớn",
                "Kinh tế chính trị Mác -Lê nin",
                "Triết học Mác - Lê nin",
                "Triết học Mác - Lê nin",
                "Triết học Mác - Lê nin",
                "Triết học Mác - Lê nin",
                "Triết học Mác - Lê nin",
                "Triết học Mác - Lê nin",
                "Triết học Mác - Lê nin",
                "Triết học Mác - Lê nin",
                "Tư tưởng Hồ Chí Minh"
        };

        // 4. Tạo Adapter
        // - this: context (Activity hiện tại)
        // - R.layout.list_item_monhoc: Layout của 1 hàng (file ta tạo ở bước 2)
        // - R.id.tv_item_name: ID của TextView bên trong file layout 1 hàng
        // - dsMonHoc: Mảng dữ liệu
        adapter = new ArrayAdapter<>(
                this,
                R.layout.item_sub_list_view,
                R.id.tv_item_name,
                dsMonHoc
        );

        // 5. Gán Adapter cho ListView
        lvMonHoc.setAdapter(adapter);

        // 6. (Tùy chọn) Thêm sự kiện khi nhấn vào 1 item
        lvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Lấy tên môn học được nhấn
                String monHocDuocChon = dsMonHoc[position];

                // Hiển thị thông báo
                Toast.makeText(ActivityChucNang3.this,
                        "Bạn đã chọn: " + monHocDuocChon,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}

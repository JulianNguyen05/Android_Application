package thigk.nguyenhuutrong.ontap_thigiuaky;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ActivityChucNang3 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chucnang3);

        String[] monhoc = {"Tin học đại cương", "Lập trình Java", "Phát triển di động", "Kinh tế chính trị Mác - Lênin"};
        ListView lv = findViewById(R.id.lvMonHoc);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, monhoc);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener((parent, view, position, id) ->
                Toast.makeText(this, "Bạn chọn: " + monhoc[position], Toast.LENGTH_SHORT).show());
    }
}

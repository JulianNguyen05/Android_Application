package thigk.nguyenhuutrong.ontap_thigiuaky;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ActivityChucNang4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chucnang4);

        RecyclerView rv = findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<String> ds = new ArrayList<>();
        ds.add("Tiêu đề hoạt động 1");
        ds.add("Tiêu đề hoạt động 2");
        ds.add("Tiêu đề hoạt động 3");

        Adapter_RecycleView adapter = new Adapter_RecycleView(ds, s ->
                Toast.makeText(this, "Bạn chọn: " + s, Toast.LENGTH_SHORT).show());
        rv.setAdapter(adapter);
    }
}
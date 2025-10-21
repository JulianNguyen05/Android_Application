package th.nguyenhuutrong.vidu_viewpager2_tablayout_fragment;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<QuocGia> dsQuocGia;
    ViewPager2 viewPager2;
    QuocGiaPagerAdaper quocGiaPagerAdaper;
    TabLayout tabLayout;


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

        dsQuocGia = new ArrayList<>();
        QuocGia qg1 = new QuocGia("Viet Nam", "vn", 80);
        QuocGia qg2 = new QuocGia("United States", "us", 330);
        QuocGia qg3 = new QuocGia("United Kingdom", "uk", 120);
        dsQuocGia.add(qg1);
        dsQuocGia.add(qg2);
        dsQuocGia.add(qg3);

        viewPager2 = findViewById(R.id.viewPagerQG);
        quocGiaPagerAdaper = new QuocGiaPagerAdaper(this, dsQuocGia);

        viewPager2.setAdapter(quocGiaPagerAdaper);

        tabLayout = findViewById(R.id.tabLayoutQG);

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            tab.setText("Quốc gia" + (position + 1));
        });
        tabLayoutMediator.attach();



    }
}
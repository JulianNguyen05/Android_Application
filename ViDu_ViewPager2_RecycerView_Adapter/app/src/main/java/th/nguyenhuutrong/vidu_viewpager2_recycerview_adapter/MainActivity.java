package th.nguyenhuutrong.vidu_viewpager2_recycerview_adapter;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    LandScapeAdapter landScapeAdapter;
    ArrayList<LandScape> viewPagerDatas;
    ViewPager2 viewPager2Land;

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

        viewPagerDatas = getDataForViewPaper();
        viewPager2Land = findViewById(R.id.vp2Land);
        landScapeAdapter = new LandScapeAdapter(this, viewPagerDatas);
        viewPager2Land.setAdapter(landScapeAdapter);
        viewPager2Land.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });



    }

    ArrayList<LandScape> getDataForViewPaper () {
        ArrayList<LandScape> dsDuLieu = new ArrayList<>();
        dsDuLieu.add(new LandScape("effel", "Tháp Effel"));
        dsDuLieu.add(new LandScape("effel", "Cung điện Buckingham"));
        dsDuLieu.add(new LandScape("effel", "Vịnh Hạ Long"));
        dsDuLieu.add(new LandScape("buckingham", "Nhà thờ Đức Bà"));
        return dsDuLieu;
    }
}
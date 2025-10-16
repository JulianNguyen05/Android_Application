package th.nguyenhuutrong.lamthem_toeic_600_vocabulary_learning_app;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager2 viewPager;
    WordCardAdapter adapter;
    List<Word> wordList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.word_viewpager);

        loadDataFromJson();
        adapter = new WordCardAdapter(this, wordList);
        viewPager.setAdapter(adapter);
    }

    // Phương thức loadDataFromJson() giữ nguyên như cũ
    private void loadDataFromJson() {
        try {
            InputStream inputStream = getAssets().open("vocab_data.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();

            String json = new String(buffer, "UTF-8");
            JSONArray jsonArray = new JSONArray(json);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                String word = obj.getString("word");
                String meaning = obj.getString("meaning");
                String example = obj.getString("example");
                String type = obj.getString("type");
                wordList.add(new Word(word, meaning, example, type));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
package th.nguyenhuutrong.lamthem_toeic_600_vocabulary_learning_app;


import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import android.os.Bundle;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    private ViewPager2 viewPager;
    private ArrayList<Topic> topics = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        viewPager = findViewById(R.id.viewPager);
        loadDataFromJSON();


        TopicPagerAdapter adapter = new TopicPagerAdapter(this, topics);
        viewPager.setAdapter(adapter);
    }


    private void loadDataFromJSON() {
        try {
            InputStream inputStream = getAssets().open("vocab_data.json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }


            JSONArray jsonArray = new JSONArray(builder.toString());


            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject topicObj = jsonArray.getJSONObject(i);
                String topicName = topicObj.getString("topic");
                JSONArray wordsArray = topicObj.getJSONArray("words");


                ArrayList<Word> wordList = new ArrayList<>();
                for (int j = 0; j < wordsArray.length(); j++) {
                    JSONObject w = wordsArray.getJSONObject(j);
                    String word = w.getString("word");
                    String meaning = w.getString("meaning");
                    String example = w.getString("example");
                    String type = w.getString("type");
                    wordList.add(new Word(word, meaning, example, type));
                }
                topics.add(new Topic(topicName, wordList));
            }


        } catch (IOException | JSONException e) {
            Log.e("MainActivity", "Error reading JSON", e);
        }
    }
}
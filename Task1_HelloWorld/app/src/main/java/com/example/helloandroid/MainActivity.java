package com.example.helloandroid;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView Hello;
    private Button btnChange;
    private boolean isHello = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Hello = findViewById(R.id.Hello);
        btnChange = findViewById(R.id.btnChange);

        Hello.setText(R.string.hello);
        btnChange.setText(R.string.change_greeting_en);

        btnChange.setOnClickListener(v -> {
            if (isHello) {
                Hello.setText(R.string.xin_chao);
                btnChange.setText(R.string.change_greeting_vi);
            } else {
                Hello.setText(R.string.hello);
                btnChange.setText(R.string.change_greeting_en);
            }
            isHello = !isHello;
        });
    }
}

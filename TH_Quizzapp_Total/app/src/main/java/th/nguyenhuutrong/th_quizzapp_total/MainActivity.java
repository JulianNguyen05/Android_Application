package th.nguyenhuutrong.th_quizzapp_total;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView txtCauHoi, txtScore;
    Button[] buttons = new Button[4];
    CauHoi cauHoiHienTai;
    int score = 0;

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

        txtCauHoi = findViewById(R.id.txtCauHoi);
        txtScore = findViewById(R.id.txtScore);

        buttons[0] = findViewById(R.id.btn1);
        buttons[1] = findViewById(R.id.btn2);
        buttons[2] = findViewById(R.id.btn3);
        buttons[3] = findViewById(R.id.btn4);

        capNhatScore();
        loadCauHoiMoi();
    }

    private void loadCauHoiMoi() {
        cauHoiHienTai = new CauHoi();
        txtCauHoi.setText(cauHoiHienTai.getCauHoiText());

        for (int i = 0; i < 4; i++) {
            buttons[i].setEnabled(true);
            buttons[i].setText(String.valueOf(cauHoiHienTai.dapAnList.get(i)));
            buttons[i].setBackgroundResource(R.drawable.btn_bg);
            int finalI = i;
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int dapAnChon = cauHoiHienTai.dapAnList.get(finalI);
                    if (dapAnChon == cauHoiHienTai.dapAnDung) {
                        score++;
                        capNhatScore();
                        buttons[finalI].setBackgroundColor(Color.parseColor("#4CAF50"));

                        for (Button b : buttons) {
                            b.setEnabled(false);
                        }

                        AlphaAnimation fadeOut = new AlphaAnimation(1.0f, 0.0f);
                        fadeOut.setDuration(500);
                        fadeOut.setFillAfter(true);

                        txtCauHoi.startAnimation(fadeOut);
                        for (Button b : buttons) {
                            b.startAnimation(fadeOut);
                        }

                        buttons[finalI].postDelayed(() -> {
                            loadCauHoiMoi();

                            AlphaAnimation fadeIn = new AlphaAnimation(0.0f, 1.0f);
                            fadeIn.setDuration(500);
                            fadeIn.setFillAfter(true);

                            txtCauHoi.startAnimation(fadeIn);
                            for (Button b : buttons) {
                                b.startAnimation(fadeIn);
                            }

                        }, 1000);
                    } else {
                        score = 0;
                        capNhatScore();
                        buttons[finalI].setBackgroundColor(Color.parseColor("#F44336"));
                        Toast.makeText(MainActivity.this, "Sai rồi! Điểm reset về 0", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void capNhatScore() {
        txtScore.setText("Điểm: " + score);
    }
}
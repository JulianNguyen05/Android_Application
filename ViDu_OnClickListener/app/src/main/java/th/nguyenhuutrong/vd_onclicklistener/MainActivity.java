package th.nguyenhuutrong.vd_onclicklistener;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity{

    Button btnC1, btnC2;
    TextView txtToast;

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

        btnC1 = (Button)findViewById(R.id.btnC1);
        btnC1.setOnClickListener(buttonClickListener);

        btnC2 = (Button)findViewById(R.id.btnC2);
        btnC2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtToast = (TextView)findViewById(R.id.txtToast);
                txtToast.setText("Say Hello");
            }
        });
    }

    View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            txtToast = (TextView)findViewById(R.id.txtToast);
            txtToast.setText("Say Hi");
        }
    };
}
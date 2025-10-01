package th.nguyenhuutrong.vidutong2so;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ///(1) Khai báo các biến đối tượng nhằm liên kết đến các xml views(id)
    EditText edtA, edtB;
    TextView result;
    Button btn_calculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        /// (2) Link biến Java với id tương ứng
        edtA= findViewById(R.id.edt_numa);
        edtB = findViewById(R.id.edt_numb);
        btn_calculate = findViewById(R.id.btn_calculate);
        result = findViewById(R.id.result);
        /// Trong VD này chưa dùng tới nút tính toan, vi đã dùng OnClick


    }
    public void HamTinhTong(View v){
        /// Code tinh tong
        /// Form: Lấy dữ liệu --> Xử lý --> Xuất kq
        String str_so1 = edtA.getText().toString();
        String str_so2 = edtB.getText().toString();
        int soA= Integer.parseInt(str_so1);
        int soB= Integer.parseInt(str_so2);

        int Tong = soA + soB;
        String strResult = String.valueOf(Tong);


    }
}
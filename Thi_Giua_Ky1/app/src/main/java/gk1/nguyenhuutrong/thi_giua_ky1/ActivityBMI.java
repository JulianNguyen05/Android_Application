package gk1.nguyenhuutrong.thi_giua_ky1;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

// Import các component mới của Material Design
import com.google.android.material.button.MaterialButton;
import com.google.android.material.switchmaterial.SwitchMaterial;

public class ActivityBMI extends AppCompatActivity { // Đổi tên class

    // Sử dụng TextInputEditText và SwitchMaterial sẽ tường minh hơn,
    // nhưng dùng EditText và Switch (lớp cha) vẫn hoạt động
    EditText edtWeight, edtHeight;
    SwitchMaterial switchAsia; // Đổi từ Switch sang SwitchMaterial
    MaterialButton btnCaculate; // Đổi từ Button sang MaterialButton
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        // THAY ĐỔI QUAN TRỌNG: Load layout mới
        setContentView(R.layout.activity_bmi);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Ánh xạ ID (các ID này đã được giữ lại trong file XML mới)
        edtHeight = findViewById(R.id.edtHeight);
        edtWeight = findViewById(R.id.edtWeight);
        switchAsia = findViewById(R.id.switchAsian);
        btnCaculate = findViewById(R.id.btnCalculate);
        tvResult = findViewById(R.id.tvResult);

        // Logic sự kiện không thay đổi
        btnCaculate.setOnClickListener(v -> CaculateBMI());
    }

    // Toàn bộ logic bên dưới được giữ nguyên
    // vì nó chỉ phụ thuộc vào các biến đã được ánh xạ ở trên.

    public void CaculateBMI(){
        try{
            String heighStr = edtHeight.getText().toString().trim();
            String weightSTr = edtWeight.getText().toString().trim();

            if(heighStr.isEmpty() || weightSTr.isEmpty()){
                Toast.makeText(this,"Vui lòng nhập đầy đủ chiều cao và cân nặng!", Toast.LENGTH_SHORT).show();
                return;
            }

            double height = Double.parseDouble(heighStr);
            double weight = Double.parseDouble(weightSTr);

            if(height <= 0 || weight <= 0){
                Toast.makeText(this, "Chiều cao và cân nặng phải lớn hơn 0!", Toast.LENGTH_SHORT).show();
                return;
            }

            double bmi = weight / (height * height);
            boolean isAsian = switchAsia.isChecked();

            String resultCategory = classifyBMI(bmi, isAsian);
            int color = getBMIColor(bmi, isAsian);

            String resultText = String.format("BMI: %.1f\n%s", bmi, resultCategory);
            tvResult.setText(resultText);

            // Thay vì setTextColor cho TextView, ta có thể set cho
            // LinearLayout chứa nó nếu muốn, nhưng set cho text vẫn ổn
            tvResult.setTextColor(color);

        } catch (NumberFormatException e){
            Toast.makeText(this, "Dữ liệu nhập không hợp lệ!", Toast.LENGTH_SHORT).show();
        }
    }

    public String classifyBMI(double bmi, boolean isAsian){
        if(isAsian){
            if(bmi < 17.5) return "Thiếu cân (Chuẩn Châu Á)";
            else if(bmi < 23) return "Bình thường (Chuẩn Châu Á)";
            else if(bmi < 28) return "Thừa cân (Chuẩn Châu Á)";
            else return "Béo phì (Chuẩn Châu Á)";
        }else{
            if(bmi < 18.5) return "Thiếu cân";
            else if(bmi < 25) return "Bình thường";
            else if(bmi < 30) return "Thừa cân";
            else return "Béo phì";
        }
    }

    private int getBMIColor(double bmi, boolean isAsian){
        double underWeight = isAsian ? 17.5 : 18.5;
        double normalWeight = isAsian ? 23 : 25;
        double overWeight = isAsian ? 28 : 30;

        if(bmi < underWeight){
            // Bạn cần đảm bảo đã định nghĩa các màu này trong res/values/colors.xml
            return ContextCompat.getColor(this, R.color.under_weight);
        }else if(bmi < normalWeight){
            return ContextCompat.getColor(this, R.color.normal_weight);
        }else if(bmi < overWeight){
            return ContextCompat.getColor(this, R.color.over_weight);
        }else{
            return ContextCompat.getColor(this, R.color.obese);
        }
    }
}
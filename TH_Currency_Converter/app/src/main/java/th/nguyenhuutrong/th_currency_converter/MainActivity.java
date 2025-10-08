package th.nguyenhuutrong.th_currency_converter;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerFrom, spinnerTo;
    private EditText inputAmount;
    private TextView outputAmount;
    private Button btnConvert;

    // Bảng tỷ giá cố định
    private final Map<String, Double> rateToUSD = new HashMap<>();

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

        // Ánh xạ view
        spinnerFrom = findViewById(R.id.spinnerFrom);
        spinnerTo = findViewById(R.id.spinnerTo);
        inputAmount = findViewById(R.id.inputAmount);
        outputAmount = findViewById(R.id.outputAmount);
        btnConvert = findViewById(R.id.btnConvert);

        // Danh sách quốc gia
        ArrayList<CurrencyItem> list = new ArrayList<>();
        list.add(new CurrencyItem("USD", R.drawable.flag_us));
        list.add(new CurrencyItem("VND", R.drawable.flag_vn));
        list.add(new CurrencyItem("JPY", R.drawable.flag_jp));
        list.add(new CurrencyItem("EUR", R.drawable.flag_eu));
        list.add(new CurrencyItem("INR", R.drawable.flag_in));

        // Adapter tùy chỉnh
        CustomSpinnerAdapter adapter = new CustomSpinnerAdapter(this, list);
        spinnerFrom.setAdapter(adapter);
        spinnerTo.setAdapter(adapter);

        // --- Khởi tạo tỷ giá giả định (so với USD)
        rateToUSD.put("USD", 1.0);
        rateToUSD.put("VND", 1.0 / 25000.0); // 1 VND = 0.00004 USD
        rateToUSD.put("JPY", 1.0 / 150.0);   // 1 JPY = 0.0067 USD
        rateToUSD.put("EUR", 1.0 / 0.93);    // 1 EUR = 1.075 USD
        rateToUSD.put("INR", 1.0 / 83.0);    // 1 INR = 0.012 USD

        // Xử lý khi nhấn nút chuyển đổi
        btnConvert.setOnClickListener(v -> {
            String from = ((CurrencyItem) spinnerFrom.getSelectedItem()).getCode();
            String to = ((CurrencyItem) spinnerTo.getSelectedItem()).getCode();
            String amountStr = inputAmount.getText().toString().trim();

            if (amountStr.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập số tiền", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                double amount = Double.parseDouble(amountStr);
                double result = convertCurrency(from, to, amount);
                outputAmount.setText(String.format("%.2f", result));
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Số tiền không hợp lệ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Hàm chuyển đổi nội bộ (không cần API)
    private double convertCurrency(String from, String to, double amount) {
        if (!rateToUSD.containsKey(from) || !rateToUSD.containsKey(to)) {
            Toast.makeText(this, "Không có dữ liệu tỷ giá", Toast.LENGTH_SHORT).show();
            return 0;
        }
        double usdAmount = amount * rateToUSD.get(from); // Quy đổi từ tiền gốc sang USD
        return usdAmount / rateToUSD.get(to);             // Từ USD sang tiền đích
    }
}

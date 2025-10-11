package th.nguyenhuutrong.th_currency_converter;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputEditText;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    // Khai báo các thành phần UI
    private TextInputEditText inputAmount;
    private Spinner spinnerFrom, spinnerTo;
    private ImageView ivSwap;
    private TextView outputAmount;
    private Button btnConvert;

    private ArrayList<CurrencyItem> currencyList;
    private CurrencyAdapter adapter;

    // TODO: Trong ứng dụng thực tế, tỷ giá này nên được lấy từ API
    private Map<String, Double> exchangeRates = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ UI
        inputAmount = findViewById(R.id.inputAmount);
        spinnerFrom = findViewById(R.id.spinnerFrom);
        spinnerTo = findViewById(R.id.spinnerTo);
        ivSwap = findViewById(R.id.ivSwap);
        outputAmount = findViewById(R.id.outputAmount);
        btnConvert = findViewById(R.id.btnConvert);

        // Khởi tạo danh sách tiền tệ
        initCurrencyList();

        // Khởi tạo tỷ giá hối đoái giả
        initExchangeRates();

        // Thiết lập Adapter cho cả hai Spinner
        adapter = new CurrencyAdapter(this, currencyList);
        spinnerFrom.setAdapter(adapter);
        spinnerTo.setAdapter(adapter);

        // Cài đặt giá trị mặc định cho Spinner
        spinnerFrom.setSelection(3); // Mặc định là VND
        spinnerTo.setSelection(0);   // Mặc định là USD

        // Thiết lập sự kiện click cho nút chuyển đổi
        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertCurrency();
            }
        });

        // Thiết lập sự kiện click cho icon hoán đổi
        ivSwap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapCurrencies();
            }
        });
    }

    private void initCurrencyList() {
        currencyList = new ArrayList<>();
        currencyList.add(new CurrencyItem("USD", R.drawable.flag_us));
        currencyList.add(new CurrencyItem("EUR", R.drawable.flag_eu));
        currencyList.add(new CurrencyItem("JPY", R.drawable.flag_jp));
        currencyList.add(new CurrencyItem("VND", R.drawable.flag_vn));
        currencyList.add(new CurrencyItem("GBP", R.drawable.flag_gb));
    }

    private void initExchangeRates() {
        // Tỷ giá dựa trên 1 USD
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("VND", 25450.0);
        exchangeRates.put("EUR", 0.92);
        exchangeRates.put("JPY", 148.5);
        exchangeRates.put("GBP", 0.81);
    }

    private void convertCurrency() {
        String amountStr = inputAmount.getText().toString();
        if (amountStr.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập số tiền", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double amountToConvert = Double.parseDouble(amountStr);

            CurrencyItem fromCurrency = (CurrencyItem) spinnerFrom.getSelectedItem();
            CurrencyItem toCurrency = (CurrencyItem) spinnerTo.getSelectedItem();

            String fromCurrencyName = fromCurrency.getCurrencyName();
            String toCurrencyName = toCurrency.getCurrencyName();

            // Lấy tỷ giá
            double rateFrom = exchangeRates.get(fromCurrencyName);
            double rateTo = exchangeRates.get(toCurrencyName);

            // Công thức chuyển đổi qua USD làm trung gian
            double amountInUSD = amountToConvert / rateFrom;
            double convertedAmount = amountInUSD * rateTo;

            // Định dạng kết quả
            DecimalFormat formatter = new DecimalFormat("#,##0.00");
            outputAmount.setText(formatter.format(convertedAmount));

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Số tiền nhập không hợp lệ", Toast.LENGTH_SHORT).show();
        }
    }

    private void swapCurrencies() {
        int fromPosition = spinnerFrom.getSelectedItemPosition();
        int toPosition = spinnerTo.getSelectedItemPosition();

        spinnerFrom.setSelection(toPosition);
        spinnerTo.setSelection(fromPosition);
    }
}
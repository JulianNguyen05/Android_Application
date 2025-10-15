package th.nguyenhuutrong.th_currency_converter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    // Khai báo các thành phần UI
    private TextInputEditText inputAmount;
    private Spinner spinnerFrom, spinnerTo;
    private ImageView ivSwap;
    private TextView outputAmount;
    private Button btnConvert;
    private TextView tvExchangeRate;

    private ArrayList<CurrencyItem> currencyList;
    private CurrencyAdapter adapter;
    private Map<String, Double> exchangeRates = new HashMap<>();

    // CẬP NHẬT: Đổi tên và thêm bộ định dạng mới
    private DecimalFormat inputFormatter;       // Dùng cho ô nhập liệu (linh hoạt)
    private DecimalFormat outputFormatter;      // Dùng cho ô kết quả (nghiêm ngặt)
    private DecimalFormat normalRateFormatter;  // Dùng cho tỷ giá thông thường
    private DecimalFormat preciseRateFormatter; // Dùng cho tỷ giá rất nhỏ

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ UI
        TextInputLayout tilAmount = findViewById(R.id.tilAmount);
        inputAmount = (TextInputEditText) tilAmount.getEditText();
        spinnerFrom = findViewById(R.id.spinnerFrom);
        spinnerTo = findViewById(R.id.spinnerTo);
        ivSwap = findViewById(R.id.ivSwap);
        outputAmount = findViewById(R.id.outputAmount);
        btnConvert = findViewById(R.id.btnConvert);
        tvExchangeRate = findViewById(R.id.tvExchangeRate);

        setupFormatters();
        initCurrencyList();
        initExchangeRates();

        adapter = new CurrencyAdapter(this, currencyList);
        spinnerFrom.setAdapter(adapter);
        spinnerTo.setAdapter(adapter);
        spinnerFrom.setSelection(3); // VND
        spinnerTo.setSelection(0);   // USD

        AdapterView. SelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateExchangeRateDisplay();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        };

        spinnerFrom.setOnItemSelectedListener(itemSelectedListener);
        spinnerTo.setOnItemSelectedListener(itemSelectedListener);
        updateExchangeRateDisplay();

        // CẬP NHẬT: Sử dụng inputFormatter cho TextWatcher
        inputAmount.addTextChangedListener(new NumberTextWatcher(inputAmount, inputFormatter));
        btnConvert.setOnClickListener(v -> convertCurrency());
        ivSwap.setOnClickListener(v -> swapCurrencies());
    }

    private void setupFormatters() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setGroupingSeparator(' ');
        // CẬP NHẬT: Sử dụng dấu phẩy cho phần thập phân để nhất quán
        symbols.setDecimalSeparator(',');

        // MỚI: Formatter cho ô nhập liệu (chỉ thêm dấu cách, không ép buộc số lẻ)
        String inputPattern = "#,###.##";
        inputFormatter = new DecimalFormat(inputPattern, symbols);
        inputFormatter.setDecimalSeparatorAlwaysShown(false);

        // CẬP NHẬT: Formatter cho ô kết quả (luôn hiển thị 2 số lẻ)
        String outputPattern = "#,##0.00";
        outputFormatter = new DecimalFormat(outputPattern, symbols);

        String normalRatePattern = "#,##0.####";
        normalRateFormatter = new DecimalFormat(normalRatePattern, symbols);

        String preciseRatePattern = "0.########";
        preciseRateFormatter = new DecimalFormat(preciseRatePattern, symbols);
    }

    private void convertCurrency() {
        String amountStr = inputAmount.getText().toString();
        if (amountStr.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập số tiền", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            // CẬP NHẬT: Dùng inputFormatter để đọc số từ ô nhập liệu
            Number number = inputFormatter.parse(amountStr);
            double amountToConvert = number.doubleValue();

            CurrencyItem fromCurrency = (CurrencyItem) spinnerFrom.getSelectedItem();
            CurrencyItem toCurrency = (CurrencyItem) spinnerTo.getSelectedItem();

            String fromCurrencyName = fromCurrency.getCurrencyName();
            String toCurrencyName = toCurrency.getCurrencyName();

            double rateFrom = exchangeRates.get(fromCurrencyName);
            double rateTo = exchangeRates.get(toCurrencyName);

            double amountInUSD = amountToConvert / rateFrom;
            double convertedAmount = amountInUSD * rateTo;

            // CẬP NHẬT: Dùng outputFormatter để hiển thị kết quả cuối cùng
            outputAmount.setText(outputFormatter.format(convertedAmount));
        } catch (ParseException e) {
            Toast.makeText(this, "Số tiền nhập không hợp lệ", Toast.LENGTH_SHORT).show();
        }
    }

    // --- Các hàm không thay đổi ---
    private void updateExchangeRateDisplay() {
        CurrencyItem fromCurrency = (CurrencyItem) spinnerFrom.getSelectedItem();
        CurrencyItem toCurrency = (CurrencyItem) spinnerTo.getSelectedItem();

        String fromCode = fromCurrency.getCurrencyName();
        String toCode = toCurrency.getCurrencyName();

        double rateFrom = exchangeRates.get(fromCode);
        double rateTo = exchangeRates.get(toCode);
        double directRate = rateTo / rateFrom;

        String formattedRate;

        if (directRate > 0 && directRate < 0.01) {
            formattedRate = preciseRateFormatter.format(directRate);
        } else {
            formattedRate = normalRateFormatter.format(directRate);
        }

        String rateText = "Tỷ giá: 1 " + fromCode + " = " + formattedRate + " " + toCode;
        tvExchangeRate.setText(rateText);
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
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("VND", 25450.0);
        exchangeRates.put("EUR", 0.92);
        exchangeRates.put("JPY", 158.5);
        exchangeRates.put("GBP", 0.81);
    }

    private void swapCurrencies() {
        int fromPosition = spinnerFrom.getSelectedItemPosition();
        int toPosition = spinnerTo.getSelectedItemPosition();
        spinnerFrom.setSelection(toPosition);
        spinnerTo.setSelection(fromPosition);
    }

    // CẬP NHẬT: logic của NumberTextWatcher để xử lý tốt hơn
    private static class NumberTextWatcher implements TextWatcher {
        private final EditText editText;
        private final DecimalFormat df;
        private String current = "";

        public NumberTextWatcher(EditText editText, DecimalFormat df) {
            this.editText = editText;
            this.df = df;
        }
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {}

        @Override
        public void afterTextChanged(Editable s) {
            if (s.toString().equals(current)) {
                return;
            }

            editText.removeTextChangedListener(this);

            try {
                String cleanString = s.toString().replaceAll("[^\\d" + df.getDecimalFormatSymbols().getDecimalSeparator() + "]", "");

                if (cleanString.isEmpty()){
                    current = "";
                    editText.setText("");
                    editText.addTextChangedListener(this);
                    return;
                }

                Number number;
                // Xử lý trường hợp người dùng nhập dấu phẩy ở cuối
                if (cleanString.endsWith(String.valueOf(df.getDecimalFormatSymbols().getDecimalSeparator()))) {
                    number = df.parse(cleanString.substring(0, cleanString.length() - 1));
                } else {
                    number = df.parse(cleanString);
                }

                String formatted = df.format(number);

                // Thêm lại dấu phẩy nếu người dùng đang nhập dở
                if (cleanString.endsWith(String.valueOf(df.getDecimalFormatSymbols().getDecimalSeparator()))) {
                    formatted += df.getDecimalFormatSymbols().getDecimalSeparator();
                }

                current = formatted;
                editText.setText(formatted);
                editText.setSelection(formatted.length());

            } catch (ParseException e) {
                // Ignore
            }

            editText.addTextChangedListener(this);
        }
    }
}
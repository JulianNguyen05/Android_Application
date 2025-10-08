package th.nguyenhuutrong.th_currency_converter;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerFrom, spinnerTo;
    private EditText inputAmount, outputAmount;
    private Button btnConvert;

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

        spinnerFrom = findViewById(R.id.spinnerFrom);
        spinnerTo = findViewById(R.id.spinnerTo);
        inputAmount = findViewById(R.id.inputAmount);
        outputAmount = findViewById(R.id.outputAmount);
        btnConvert = findViewById(R.id.btnConvert);

        ArrayList<CurrencyItem> list = new ArrayList<>();
        list.add(new CurrencyItem("USD", R.drawable.flag_us));
        list.add(new CurrencyItem("VND", R.drawable.flag_vn));
        list.add(new CurrencyItem("JPY", R.drawable.flag_jp));
        list.add(new CurrencyItem("EUR", R.drawable.flag_eu));
        list.add(new CurrencyItem("INR", R.drawable.flag_in));

        CustomSpinnerAdapter adapter = new CustomSpinnerAdapter(this, list);
        spinnerFrom.setAdapter(adapter);
        spinnerTo.setAdapter(adapter);

        btnConvert.setOnClickListener(v -> {
            String from = ((CurrencyItem) spinnerFrom.getSelectedItem()).getCode();
            String to = ((CurrencyItem) spinnerTo.getSelectedItem()).getCode();
            String amountStr = inputAmount.getText().toString();

            if (amountStr.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập số tiền", Toast.LENGTH_SHORT).show();
                return;
            }

            double amount = Double.parseDouble(amountStr);
            new FetchRateTask(from, to, amount).execute();
        });
    }

    private class FetchRateTask extends AsyncTask<Void, Void, Double> {
        private final String from, to;
        private final double amount;

        FetchRateTask(String from, String to, double amount) {
            this.from = from;
            this.to = to;
            this.amount = amount;
        }

        @Override
        protected Double doInBackground(Void... voids){
            try {
                String urlStr = "https://api.exchangerate.host/convert?from=" + from + "&to=" + to + "&amount=" + amount;
                URL url = new URL(urlStr);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");

                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                JSONObject json = new JSONObject(response.toString());
                return json.getDouble("result");
            }catch (Exception e){
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(Double result) {
            if (result != null) {
                outputAmount.setText(String.format("%.2f", result));
            } else {
                Toast.makeText(MainActivity.this, "Lỗi khi lấy tỷ giá", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
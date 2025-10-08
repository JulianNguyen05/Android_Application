package th.nguyenhuutrong.th_currency_converter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomSpinnerAdapter extends ArrayAdapter<CurrencyItem> {

    private final LayoutInflater inflater;

    public CustomSpinnerAdapter(Context context, List<CurrencyItem> items) {
        super(context, 0, items);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return createView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return createView(position, convertView, parent);
    }

    private View createView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.spinner_item, parent, false);
        }

        CurrencyItem item = getItem(position);
        ImageView imgFlag = convertView.findViewById(R.id.imgFlag);
        TextView txtCurrency = convertView.findViewById(R.id.txtCurrency);

        if (item != null) {
            imgFlag.setImageResource(item.getFlagResId());
            txtCurrency.setText(item.getCode());
        }

        return convertView;
    }
}

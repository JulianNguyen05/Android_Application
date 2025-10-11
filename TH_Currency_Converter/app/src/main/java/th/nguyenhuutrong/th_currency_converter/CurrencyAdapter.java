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
import java.util.ArrayList;

public class CurrencyAdapter extends ArrayAdapter<CurrencyItem> {

    public CurrencyAdapter(Context context, ArrayList<CurrencyItem> currencyList) {
        super(context, 0, currencyList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.spinner_item_with_flag, parent, false
            );
        }

        ImageView imageViewFlag = convertView.findViewById(R.id.ivFlag);
        TextView textViewName = convertView.findViewById(R.id.tvCurrencyName);

        CurrencyItem currentItem = getItem(position);

        if (currentItem != null) {
            imageViewFlag.setImageResource(currentItem.getFlagImage());
            textViewName.setText(currentItem.getCurrencyName());
        }

        return convertView;
    }
}
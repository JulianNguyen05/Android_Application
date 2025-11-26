package ht.nguyenhuutrong.lamthem_materialdesign3_fe_moneytrack;

import android.graphics.Color;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair; // Quan trọng: Dùng Pair của AndroidX
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class HomeFragment extends Fragment {
    private LinearLayout layoutWalletContainer;
    private MaterialCardView selectedCard = null;
    private MaterialCardView cardDateRangePicker;
    private TextView tvSelectedDate;
    private PieChart pieChart;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        layoutWalletContainer = view.findViewById(R.id.layoutWalletContainer);

        cardDateRangePicker = view.findViewById(R.id.cardDateRangePicker);
        tvSelectedDate = view.findViewById(R.id.tvSelectedDate);

        setupDateRangePicker();

        addWallet("Ăn uống", "-35.000đ", true);
        addAddWalletButton();

        pieChart = view.findViewById(R.id.pieChart);
        setupPieChart();
        loadPieChartData();

        return view;
    }
    private void setupPieChart() {
        pieChart.setDrawHoleEnabled(true); // Tạo lỗ rỗng ở giữa
        pieChart.setHoleColor(Color.WHITE); // Màu lỗ rỗng trùng màu nền
        pieChart.setHoleRadius(50f); // Độ rộng của lỗ (50% bán kính)
        pieChart.setTransparentCircleRadius(0f); // Bỏ vòng mờ bao quanh lỗ

        pieChart.getDescription().setEnabled(false); // Tắt dòng mô tả góc phải dưới
        pieChart.getLegend().setEnabled(false); // Tắt chú thích màu (Legend)

        // Tắt các label chữ nằm trên biểu đồ để giao diện sạch như hình
        pieChart.setDrawEntryLabels(false);

        // Tắt tương tác xoay (nếu muốn cố định giống hình)
        pieChart.setRotationEnabled(false);
    }

    private void loadPieChartData() {
        ArrayList<PieEntry> entries = new ArrayList<>();
        // Dữ liệu mẫu: 100% là màu xanh
        entries.add(new PieEntry(1.0f, "Thức ăn"));

        PieDataSet dataSet = new PieDataSet(entries, "Danh mục");

        // Set màu cho biểu đồ (Màu Teal)
        dataSet.setColor(Color.parseColor("#00BCD4")); // Màu teal_main

        // Tắt hiển thị text giá trị trên biểu đồ
        dataSet.setDrawValues(false);

        PieData data = new PieData(dataSet);
        pieChart.setData(data);
        pieChart.invalidate(); // Vẽ lại biểu đồ

        // Animation nhẹ khi mở
        pieChart.animateY(1000);
    }

    private void setupDateRangePicker() {
        if (cardDateRangePicker != null) {
            cardDateRangePicker.setOnClickListener(v -> showDateRangePicker());
        }

        if (tvSelectedDate != null) {
        }
    }

    private void showDateRangePicker() {
        MaterialDatePicker.Builder<Pair<Long, Long>> builder =
                MaterialDatePicker.Builder.dateRangePicker();

        builder.setTitleText("Chọn phạm vi thời gian");

        final MaterialDatePicker<Pair<Long, Long>> datePicker = builder.build();

        datePicker.addOnPositiveButtonClickListener(selection -> {
            Long startDate = selection.first;
            Long endDate = selection.second;

            SimpleDateFormat sdf = new SimpleDateFormat("d 'thg' M, yyyy", new Locale("vi", "VN"));

            String startString = sdf.format(new Date(startDate));
            String endString = sdf.format(new Date(endDate));

            if (tvSelectedDate != null) {
                tvSelectedDate.setText(startString + "  -  " + endString);
            }
        });

        datePicker.show(getParentFragmentManager(), "DATE_PICKER");
    }

    private void addWallet(String name, String amount, boolean select) {
        if (getContext() == null) return;

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View itemView = inflater.inflate(R.layout.item_wallet, layoutWalletContainer, false);

        TextView tvName = itemView.findViewById(R.id.tv_wallet_name);
        TextView tvAmount = itemView.findViewById(R.id.tv_wallet_amount);
        MaterialCardView card = itemView.findViewById(R.id.card_wallet);

        tvName.setText(name);
        tvAmount.setText(amount);

        card.setOnClickListener(v -> selectWallet(card));

        int addButtonIndex = layoutWalletContainer.getChildCount() - 1;
        if (addButtonIndex < 0) addButtonIndex = 0;
        layoutWalletContainer.addView(itemView, addButtonIndex);

        if (select) {
            selectWallet(card);
        }
    }

    private void addAddWalletButton() {
        if (getContext() == null) return;

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View itemAdd = inflater.inflate(R.layout.item_add_wallet, layoutWalletContainer, false);

        MaterialCardView cardAdd = itemAdd.findViewById(R.id.card_add_wallet);
        cardAdd.setOnClickListener(v -> addWallet("Ví mới", "0đ", false));

        layoutWalletContainer.addView(itemAdd);
    }

    private void selectWallet(MaterialCardView card) {
        if (selectedCard != null) {
            selectedCard.setStrokeWidth(0);
        }
        card.setStrokeColor(getResources().getColor(android.R.color.holo_blue_light));
        card.setStrokeWidth(6);
        selectedCard = card;
    }
}
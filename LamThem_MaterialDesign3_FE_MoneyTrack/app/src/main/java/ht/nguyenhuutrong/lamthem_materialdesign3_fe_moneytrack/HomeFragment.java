package ht.nguyenhuutrong.lamthem_materialdesign3_fe_moneytrack;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.card.MaterialCardView;

public class HomeFragment extends Fragment {

    private LinearLayout layoutWalletContainer;
    private MaterialCardView selectedCard = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        layoutWalletContainer = view.findViewById(R.id.layoutWalletContainer);

        addWallet("Ăn uống", "-35.000đ", true);
        addAddWalletButton();

        return view;
    }

    private void addWallet(String name, String amount, boolean select) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View itemView = inflater.inflate(R.layout.item_wallet, layoutWalletContainer, false);

        TextView tvName = itemView.findViewById(R.id.tv_wallet_name);
        TextView tvAmount = itemView.findViewById(R.id.tv_wallet_amount);
        MaterialCardView card = itemView.findViewById(R.id.card_wallet);

        tvName.setText(name);
        tvAmount.setText(amount);

        card.setOnClickListener(v -> selectWallet(card));

        // Thêm ví mới **trước nút "+ Ví mới"**
        int addButtonIndex = layoutWalletContainer.getChildCount() - 1; // vị trí nút +Ví mới
        if (addButtonIndex < 0) addButtonIndex = 0; // trường hợp chưa có nút
        layoutWalletContainer.addView(itemView, addButtonIndex);

        if (select) {
            selectWallet(card);
        }
    }

    private void addAddWalletButton() {
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

package ht.nguyenhuutrong.lamthem_materialdesign3_fe_moneytrack;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class TransactionsFragment extends Fragment {
    RecyclerView rcv;
    TransactionsAdapter adapter;
    List<TransactionModel> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_transactions, container, false);

        rcv = view.findViewById(R.id.rcvTransactions);
        rcv.setLayoutManager(new LinearLayoutManager(getContext()));

        // fake data
        list.add(new TransactionModel("Th 2, 6 thg 10, 2025",
                "Thức ăn & Đồ uống", "cà phê", "-15.000₫"));

        list.add(new TransactionModel("CN, 5 thg 10, 2025",
                "Thức ăn & Đồ uống", "bún bò", "-20.000₫"));

        adapter = new TransactionsAdapter(list);

        rcv.setAdapter(adapter);

        return view;
    }
}
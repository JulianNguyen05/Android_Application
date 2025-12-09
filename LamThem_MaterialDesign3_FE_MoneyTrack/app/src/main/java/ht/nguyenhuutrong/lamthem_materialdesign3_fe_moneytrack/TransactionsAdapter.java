package ht.nguyenhuutrong.lamthem_materialdesign3_fe_moneytrack;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TransactionsAdapter extends RecyclerView.Adapter<TransactionsAdapter.TransactionViewHolder> {
    private List<TransactionModel> list;

    public TransactionsAdapter(List<TransactionModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public TransactionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_transaction, parent, false);
        return new TransactionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionViewHolder holder, int position) {
        TransactionModel t = list.get(position);

        holder.tvDate.setText(t.getDate());
        holder.tvCategoryTitle.setText(t.getCategory());
        holder.tvNote.setText(t.getNote());
        holder.tvAmount.setText(t.getAmount());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class TransactionViewHolder extends RecyclerView.ViewHolder {

        TextView tvDate, tvCategoryTitle, tvNote, tvAmount;

        public TransactionViewHolder(@NonNull View itemView) {
            super(itemView);

            tvDate = itemView.findViewById(R.id.tvDate);
            tvCategoryTitle = itemView.findViewById(R.id.tvCategory);
            tvNote = itemView.findViewById(R.id.tvNote);
            tvAmount = itemView.findViewById(R.id.tvAmount);
        }
    }
}

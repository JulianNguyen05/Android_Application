package thigk.nguyenhuutrong.ontap_thigiuaky;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class Adapter_RecycleView extends RecyclerView.Adapter<Adapter_RecycleView.ViewHolder>{
    private ArrayList<String> ds;
    private OnItemClickListener listener;

    public interface OnItemClickListener { void onClick(String s); }

    public Adapter_RecycleView(ArrayList<String> ds, OnItemClickListener listener) {
        this.ds = ds;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String s = ds.get(position);
        holder.txt.setText(s);
        holder.itemView.setOnClickListener(v -> listener.onClick(s));
    }

    @Override
    public int getItemCount() { return ds.size(); }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt;
        ViewHolder(View v) {
            super(v);
            txt = v.findViewById(android.R.id.text1);
        }
    }
}

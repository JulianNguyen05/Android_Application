package gk1.nguyenhuutrong.thi_giua_ky1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// Đã đổi tên class từ Activity4Adapter sang BaiThuocAdapter
public class BaiThuocAdapter extends RecyclerView.Adapter<BaiThuocAdapter.ViewHolder> {

    public interface OnItemClickListener {
        // Đã đổi tham số sang BaiThuocModel
        void onItemClick(@NonNull BaiThuocModel item);
    }

    // Đã đổi List sang BaiThuocModel
    private List<BaiThuocModel> list;
    private OnItemClickListener listener;

    // Đã đổi tên constructor và tham số List
    public BaiThuocAdapter(List<BaiThuocModel> list, OnItemClickListener listener) {
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_sub_recycle_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Đã đổi sang BaiThuocModel
        BaiThuocModel item = list.get(position);
        holder.imageView.setImageResource(item.getImageResId());
        holder.title.setText(item.getTitle());
        holder.desc.setText(item.getDescription());
        holder.itemView.setOnClickListener(v -> listener.onItemClick(item));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title, desc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_image);
            title = itemView.findViewById(R.id.item_title);
            desc = itemView.findViewById(R.id.item_desc);
        }
    }
}
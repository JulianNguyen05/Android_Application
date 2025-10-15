package th.nguyenhuutrong.th_using_recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class landScapeAdapter extends RecyclerView.Adapter<landScapeAdapter.ItemLandHolder> {

    Context context;
    ArrayList<LandScape> lstData;

    public landScapeAdapter(Context context, ArrayList<LandScape> lstData) {
        this.context = context;
        this.lstData = lstData;
    }

    @NonNull
    @Override
    public ItemLandHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater cai_bom = LayoutInflater.from(context);
        View vItem = cai_bom.inflate(R.layout.item_land, parent, false);
        ItemLandHolder holderCreated = new ItemLandHolder(vItem);

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemLandHolder holder, int position) {

        // Lấy đối tượng hiển thị
        LandScape landScapeHienThi = lstData.get(position);
        // Trích thông tin
        String caption = landScapeHienThi.getLandCation();
        String tenFileAnh = landScapeHienThi.getLandImageFileName();
        // Đặt vào các trường thôn tin của holder
        holder.tvCaption.setText(caption);
            // đặt ảnh
        String packageName = holder.itemView.getContext().getPackageName();
        int imgID = holder.itemView.getResources().getIdentifier(tenFileAnh, "mipmap", packageName);
        holder.ivLandScape.setImageResource(imgID);

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ItemLandHolder extends RecyclerView.ViewHolder{
        TextView tvCaption;
        ImageView ivLandScape;

        public ItemLandHolder(@NonNull View itemView) {
            super(itemView);
            tvCaption = itemView.findViewById(R.id.tvCation);
            ivLandScape = itemView.findViewById(R.id.imgLand);
        }
    }

}

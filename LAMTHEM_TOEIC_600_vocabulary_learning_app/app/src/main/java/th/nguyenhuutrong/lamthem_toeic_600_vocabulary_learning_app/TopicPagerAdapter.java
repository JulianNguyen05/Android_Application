package th.nguyenhuutrong.lamthem_toeic_600_vocabulary_learning_app;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;


public class TopicPagerAdapter extends RecyclerView.Adapter<TopicPagerAdapter.TopicViewHolder> {
    private Context context;
    private ArrayList<Topic> topics;


    public TopicPagerAdapter(Context context, ArrayList<Topic> topics) {
        this.context = context;
        this.topics = topics;
    }


    @NonNull
    @Override
    public TopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.page_topic, parent, false);
        return new TopicViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull TopicViewHolder holder, int position) {
        Topic topic = topics.get(position);
        holder.tvTopicTitle.setText(topic.getTopicName());
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        holder.recyclerView.setAdapter(new WordAdapter(topic.getWords()));
    }


    @Override
    public int getItemCount() {
        return topics.size();
    }


    static class TopicViewHolder extends RecyclerView.ViewHolder {
        TextView tvTopicTitle;
        RecyclerView recyclerView;


        public TopicViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTopicTitle = itemView.findViewById(R.id.tvTopicTitle);
            recyclerView = itemView.findViewById(R.id.recyclerView);
        }
    }
}
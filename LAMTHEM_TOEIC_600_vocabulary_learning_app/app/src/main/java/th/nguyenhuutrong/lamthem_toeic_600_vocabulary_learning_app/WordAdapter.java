package th.nguyenhuutrong.lamthem_toeic_600_vocabulary_learning_app;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;


public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordViewHolder> {
    private ArrayList<Word> wordList;


    public WordAdapter(ArrayList<Word> wordList) {
        this.wordList = wordList;
    }


    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_word, parent, false);
        return new WordViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        Word word = wordList.get(position);
        holder.tvWord.setText(word.getWord());
        holder.tvType.setText("(" + word.getType() + ")");
        holder.tvMeaning.setText(word.getMeaning());
        holder.tvExample.setText(word.getExample());
    }


    @Override
    public int getItemCount() {
        return wordList.size();
    }


    static class WordViewHolder extends RecyclerView.ViewHolder {
        TextView tvWord, tvType, tvMeaning, tvExample;


        public WordViewHolder(@NonNull View itemView) {
            super(itemView);
            tvWord = itemView.findViewById(R.id.tvWord);
            tvType = itemView.findViewById(R.id.tvType);
            tvMeaning = itemView.findViewById(R.id.tvMeaning);
            tvExample = itemView.findViewById(R.id.tvExample);
        }
    }
}
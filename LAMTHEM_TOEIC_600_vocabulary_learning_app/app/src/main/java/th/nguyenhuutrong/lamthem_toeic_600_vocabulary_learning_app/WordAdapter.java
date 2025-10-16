package th.nguyenhuutrong.lamthem_toeic_600_vocabulary_learning_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordViewHolder> {

    private List<Word> wordList;

    public WordAdapter(List<Word> wordList) {
        this.wordList = wordList;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_word, parent, false);
        return new WordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        Word w = wordList.get(position);
        holder.tvWord.setText(w.getWord());
        holder.tvMeaning.setText(w.getMeaning());
        holder.tvExample.setText("Ex: " + w.getExample());
        holder.tvType.setText("(" + w.getType() + ")");
        holder.imgWord.setImageResource(w.getImageRes());
    }

    @Override
    public int getItemCount() {
        return wordList.size();
    }

    static class WordViewHolder extends RecyclerView.ViewHolder {
        ImageView imgWord;
        TextView tvWord, tvMeaning, tvExample, tvType;

        public WordViewHolder(@NonNull View itemView) {
            super(itemView);
            imgWord = itemView.findViewById(R.id.imgWord);
            tvWord = itemView.findViewById(R.id.tvWord);
            tvMeaning = itemView.findViewById(R.id.tvMeaning);
            tvExample = itemView.findViewById(R.id.tvExample);
            tvType = itemView.findViewById(R.id.tvType);
        }
    }
}

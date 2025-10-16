package th.nguyenhuutrong.lamthem_toeic_600_vocabulary_learning_app;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import java.util.List;

public class WordCardAdapter extends FragmentStateAdapter {
    private List<Word> wordList;

    public WordCardAdapter(@NonNull FragmentActivity fragmentActivity, List<Word> wordList) {
        super(fragmentActivity);
        this.wordList = wordList;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // Lấy từ vựng ở vị trí hiện tại
        Word word = wordList.get(position);
        // Tạo một Fragment mới với dữ liệu của từ vựng đó
        return WordCardFragment.newInstance(word);
    }

    @Override
    public int getItemCount() {
        return wordList.size(); // Tổng số "flashcard"
    }
}
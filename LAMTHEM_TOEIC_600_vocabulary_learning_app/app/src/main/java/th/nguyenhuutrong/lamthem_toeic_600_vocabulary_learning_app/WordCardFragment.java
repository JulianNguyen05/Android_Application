package th.nguyenhuutrong.lamthem_toeic_600_vocabulary_learning_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class WordCardFragment extends Fragment {

    // Tạo các key để truyền dữ liệu
    private static final String ARG_WORD = "arg_word";
    private static final String ARG_TYPE = "arg_type";
    private static final String ARG_MEANING = "arg_meaning";
    private static final String ARG_EXAMPLE = "arg_example";

    // Phương thức "nhà máy" để tạo Fragment với dữ liệu
    public static WordCardFragment newInstance(Word word) {
        WordCardFragment fragment = new WordCardFragment();
        Bundle args = new Bundle();
        args.putString(ARG_WORD, word.getWord());
        args.putString(ARG_TYPE, word.getType());
        args.putString(ARG_MEANING, word.getMeaning());
        args.putString(ARG_EXAMPLE, word.getExample());
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_word_card, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tvWord = view.findViewById(R.id.tv_word);
        TextView tvType = view.findViewById(R.id.tv_type);
        TextView tvMeaning = view.findViewById(R.id.tv_meaning);
        TextView tvExample = view.findViewById(R.id.tv_example);

        if (getArguments() != null) {
            tvWord.setText(getArguments().getString(ARG_WORD));
            tvType.setText("(" + getArguments().getString(ARG_TYPE) + ")");
            tvMeaning.setText(getArguments().getString(ARG_MEANING));
            tvExample.setText(getArguments().getString(ARG_EXAMPLE));
        }
    }
}
package th.nguyenhuutrong.lamthem_toeic_600_vocabulary_learning_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class WordCardFragment extends Fragment {
    private static final String ARG_WORD = "word";
    private static final String ARG_TYPE = "type";
    private static final String ARG_MEANING = "meaning";
    private static final String ARG_EXAMPLE = "example";

    public static WordCardFragment newInstance(String word, String type, String meaning, String example) {
        WordCardFragment fragment = new WordCardFragment();
        Bundle args = new Bundle();
        args.putString(ARG_WORD, word);
        args.putString(ARG_TYPE, type);
        args.putString(ARG_MEANING, meaning);
        args.putString(ARG_EXAMPLE, example);
        fragment.setArguments(args);
        return fragment;
    }

    public static WordCardFragment newInstance(Word word) {
        return newInstance(
                word.getWord(),
                word.getType(),
                word.getMeaning(),
                word.getExample()
        );
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_word_card, container, false);

        TextView tvWord = view.findViewById(R.id.tv_word);
        TextView tvType = view.findViewById(R.id.tv_type);
        TextView tvMeaning = view.findViewById(R.id.tv_meaning);
        TextView tvExample = view.findViewById(R.id.tv_example);
        LinearLayout cardContainer = view.findViewById(R.id.cardContainer);

        Bundle args = getArguments();
        if (args != null) {
            tvWord.setText(args.getString(ARG_WORD));
            tvType.setText("(" + args.getString(ARG_TYPE) + ")");
            tvMeaning.setText(args.getString(ARG_MEANING));
            tvExample.setText("Example: " + args.getString(ARG_EXAMPLE));
        }

        // Hiệu ứng mở chi tiết từ
        cardContainer.setOnClickListener(v -> {
            boolean visible = tvMeaning.getVisibility() == View.VISIBLE;
            int newVisibility = visible ? View.GONE : View.VISIBLE;

            tvType.setVisibility(newVisibility);
            tvMeaning.setVisibility(newVisibility);
            tvExample.setVisibility(newVisibility);
        });

        return view;
    }
}

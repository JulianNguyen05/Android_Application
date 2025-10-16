package th.nguyenhuutrong.lamthem_toeic_600_vocabulary_learning_app;

import java.util.ArrayList;

public class Topic {
    private String topicName;
    private ArrayList<Word> words;

    public Topic(String topicName, ArrayList<Word> words) {
        this.topicName = topicName;
        this.words = words;
    }

    public String getTopicName() { return topicName; }
    public ArrayList<Word> getWords() { return words; }
}
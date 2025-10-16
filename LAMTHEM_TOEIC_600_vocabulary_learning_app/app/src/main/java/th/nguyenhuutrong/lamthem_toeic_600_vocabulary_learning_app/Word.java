package th.nguyenhuutrong.lamthem_toeic_600_vocabulary_learning_app;

public class Word {
    private String word, meaning, example, type;
    private int imageRes;

    public Word(String word, String meaning, String example, String type, int imageRes) {
        this.word = word;
        this.meaning = meaning;
        this.example = example;
        this.type = type;
        this.imageRes = imageRes;
    }

    public String getWord() {
        return word;
    }

    public String getMeaning() {
        return meaning;
    }

    public String getExample() {
        return example;
    }

    public String getType() {
        return type;
    }

    public int getImageRes() {
        return imageRes;
    }
}

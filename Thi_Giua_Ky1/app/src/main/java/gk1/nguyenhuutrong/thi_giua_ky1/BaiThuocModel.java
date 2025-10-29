package gk1.nguyenhuutrong.thi_giua_ky1;

public class BaiThuocModel {
    private int imageResId;
    private String title;
    private String description;

    public BaiThuocModel(int imageResId, String title, String description) {
        this.imageResId = imageResId;
        this.title = title;
        this.description = description;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}

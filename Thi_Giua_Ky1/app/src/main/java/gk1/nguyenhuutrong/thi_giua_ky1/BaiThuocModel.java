package gk1.nguyenhuutrong.thi_giua_ky1;

public class BaiThuocModel {
    private int imageResId;
    private String title;
    private String description;

    // Đã đổi tên constructor (hàm dựng)
    public BaiThuocModel(int imageResId, String title, String description) {
        this.imageResId = imageResId;
        this.title = title;
        this.description = description;
    }

    // Các hàm get giữ nguyên
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

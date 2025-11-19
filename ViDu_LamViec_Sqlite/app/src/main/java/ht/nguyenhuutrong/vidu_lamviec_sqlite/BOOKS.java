package ht.nguyenhuutrong.vidu_lamviec_sqlite;

public class BOOKS {
    int BookID;
    int Page;
    String BookName;
    String Description;
    float Price;

    public BOOKS(int bookID, int page, String bookName, String description, float price) {
        BookID = bookID;
        Page = page;
        BookName = bookName;
        Description = description;
        Price = price;
    }

    @Override
    public String toString() {
        return "BOOKS{" +
                "BookID=" + BookID +
                ", Page=" + Page +
                ", BookName='" + BookName + '\'' +
                ", Description='" + Description + '\'' +
                ", Price=" + Price +
                '}';
    }

    public int getBookID() {
        return BookID;
    }

    public void setBookID(int bookID) {
        BookID = bookID;
    }

    public int getPage() {
        return Page;
    }

    public void setPage(int page) {
        Page = page;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }
}

Dưới đây là file **README.md** được viết chuyên nghiệp, dành cho **ActivityAboutMe** trong dự án Android — thể hiện rõ mục tiêu, cấu trúc, công nghệ và hướng dẫn triển khai:

---

# 📱 ActivityAboutMe – Android Portfolio Screen

## 🧩 Tổng quan

**ActivityAboutMe** là một **màn hình giới thiệu cá nhân chuyên nghiệp** được thiết kế bằng **Material Design**, sử dụng **CollapsingToolbarLayout**, **CardView**, và **ChipGroup** để hiển thị thông tin như:

* Giới thiệu bản thân
* Mục tiêu nghề nghiệp
* Kỹ năng & kinh nghiệm làm việc
* Dự án cá nhân
* Học vấn
* Liên hệ

Màn hình được thiết kế với **hiệu ứng parallax** và **scroll mượt mà**, phù hợp làm **portfolio cá nhân trong ứng dụng Android** hoặc phần "About Me" trong app chuyên nghiệp.

---

## 🎨 Giao diện tổng thể

<img src="https://developer.android.com/images/ui/material-components.png" width="500"/>

Màn hình bao gồm các phần:

1. **Header (Collapsing Toolbar)** – ảnh nền và ảnh đại diện hình tròn.
2. **Thông tin cá nhân cơ bản** – tên, chức danh, địa điểm.
3. **Các mục chi tiết** – được trình bày bằng MaterialCardView:

   * 🎯 Mục tiêu nghề nghiệp
   * 🛠️ Kỹ năng
   * 💼 Kinh nghiệm làm việc
   * 🚀 Dự án cá nhân
   * 🎓 Học vấn
   * 💬 Liên hệ

---

## ⚙️ Công nghệ sử dụng

| Thành phần                                 | Mô tả                                    |
| ------------------------------------------ | ---------------------------------------- |
| `CoordinatorLayout`                        | Tổ chức bố cục chính với hiệu ứng scroll |
| `AppBarLayout` & `CollapsingToolbarLayout` | Hiệu ứng co giãn Toolbar khi cuộn        |
| `MaterialToolbar`                          | Thanh tiêu đề tùy chỉnh                  |
| `ShapeableImageView`                       | Ảnh đại diện tròn có viền                |
| `NestedScrollView`                         | Cuộn nội dung mượt mà                    |
| `MaterialCardView`                         | Hiển thị từng mục nội dung độc lập       |
| `ChipGroup` & `Chip`                       | Liệt kê kỹ năng chuyên môn               |
| `MaterialButton`                           | Các nút liên kết GitHub, Email, SĐT      |

---

## 🧱 Cấu trúc tệp

```
app/
└── res/
    ├── layout/
    │   └── activity_about_me.xml
    ├── mipmap/
    │   ├── bg_about_me.png
    │   └── avt_about_me.png
    ├── drawable/
    │   ├── ic_github.xml
    │   ├── ic_email.xml
    │   ├── ic_phone.xml
    │   └── ic_location.xml
    ├── font/
    │   ├── inter_regular.ttf
    │   ├── inter_medium.ttf
    │   └── inter_semi_bold.ttf
    └── values/
        ├── colors.xml
        ├── styles.xml
        └── themes.xml
```

---

## 🚀 Cách sử dụng

1. **Thêm Activity vào dự án**

   ```java
   Intent intent = new Intent(this, ActivityAboutMe.class);
   startActivity(intent);
   ```

2. **Tùy chỉnh thông tin cá nhân**
   Mở tệp `activity_about_me.xml` và chỉnh sửa:

   * Tên (`Nguyễn Hữu Trọng`)
   * Chức danh (`Software Developer`)
   * Địa chỉ, email, GitHub, số điện thoại
   * Nội dung trong các CardView (mục tiêu, kỹ năng, học vấn, v.v.)

3. **Thêm hình ảnh cá nhân**

   * `bg_about_me.png` → ảnh nền header
   * `avt_about_me.png` → ảnh đại diện

---

## 🧠 Tính năng nổi bật

✅ Giao diện **Material Design** hiện đại
✅ Hiệu ứng **Collapsing Toolbar** chuyên nghiệp
✅ **Responsive layout** cho mọi kích thước màn hình
✅ Có thể **tùy biến toàn bộ nội dung** dễ dàng
✅ Sử dụng **font Inter** để tăng tính thẩm mỹ và đọc dễ

---

## 🧑‍💻 Tác giả

**Nguyễn Hữu Trọng (Julian)**
📍 Nha Trang, Khánh Hòa
💼 Software Developer
🌐 GitHub: [github.com/JulianNguyen05](https://github.com/JulianNguyen05)
✉️ Email: [huutrong.160705@gmail.com](mailto:huutrong.160705@gmail.com)
📞 SĐT: 0935 918 965

---

## 📄 Giấy phép

Dự án được phát hành dưới **MIT License** – bạn có thể tự do chỉnh sửa, chia sẻ và sử dụng trong dự án cá nhân hoặc học tập.

---

Bạn có muốn tôi **thêm phần preview ảnh chụp màn hình (mockup)** và **hướng dẫn chạy demo trên Android Studio** để README trông như dự án GitHub chuyên nghiệp không?

# ViDu_ViewPager2_TabLayout_Fragment

A simple Android application to demonstrate the implementation of `ViewPager2` with `TabLayout` for creating a swipeable tab interface. Each tab displays a `Fragment` with information about a specific country.

-----

## 🎥 Demo Video

Watch a short demo of the `ViDu_ViewPager2_TabLayout_Fragment` implementation in action:

https://github.com/user-attachments/assets/3c4f976a-9b53-4c59-a9ea-7682568e5f2b

-----

## 🧠 Core Implementation

This project demonstrates a fundamental pattern for creating modern tabbed layouts in Android.

1.  **MainActivity Setup**: The `MainActivity` initializes a list of `QuocGia` (Country) objects. It then finds the `ViewPager2` and `TabLayout` views from the layout.
2.  **Adapter Initialization**: A `QuocGiaPagerAdaper` (which extends `FragmentStateAdapter`) is created, passing the `FragmentActivity` context and the list of countries to its constructor.
3.  **Fragment Creation**: Inside the adapter's `createFragment` method, for each position, it retrieves the corresponding `QuocGia` object and instantiates a `QuocGiaFragment`, passing the country object to it.
4.  **View Binding**: The `QuocGiaFragment` receives the data and, in its `onCreateView` method, inflates its layout and binds the country's data (name, population, flag) to the respective `TextView` and `ImageView` components.
5.  **Tab-Pager Synchronization**: A `TabLayoutMediator` is used to link the `TabLayout` with the `ViewPager2`. It synchronizes the tab selection with the pager swiping and sets the title for each tab.

-----

## ✨ Key Technical Features

  * **Modern Paging**: Utilizes **`ViewPager2`** for creating efficient, swipeable views.
  * **Dynamic Fragments**: Employs a **`FragmentStateAdapter`** to dynamically create and manage fragments as the user swipes through pages.
  * **Data Passing to Fragments**: Demonstrates a clean way to pass data objects to fragments via their constructors.
  * **Seamless Tab Integration**: Integrates **`TabLayout`** with `ViewPager2` using **`TabLayoutMediator`** for a synchronized user experience.
  * **Resource Handling**: Shows how to dynamically load image resources (country flags) from the `mipmap` folder based on a string identifier.

-----

## 🛠️ Tech Stack

  * **Language**: **Java**
  * **Platform**: **Android**
  * **UI Components**:
      * ViewPager2
      * TabLayout (Material Design)
      * Fragment
      * ConstraintLayout & LinearLayout
  * **Architecture**: Basic Activity-Fragment Pattern
  * **Build Tool**: Gradle

-----
Chào bạn, tôi hiểu rồi. Bạn muốn có một đoạn mô tả chi tiết hơn về chức năng được thể hiện trong mỗi ảnh chụp màn hình, tương tự như ví dụ bạn đưa ra.

Dựa trên chức năng của ứng dụng, đây là phần mô tả chi tiết bạn có thể sử dụng.

-----

## 📸 Screenshots

The screenshots below illustrate the core functionality of the application, where the `ViewPager2` displays a unique `Fragment` for each country in the dataset. Swiping left or right navigates between these fragments, and the `TabLayout` indicator updates accordingly.

  * **Left – Vietnam Tab:** This shows the fragment at the first position, populated with data for Vietnam. It displays the country's flag, name ("Viet Nam"), and population.
  * **Center – United Kingdom Tab:** This represents the user having swiped to the second tab. The view is now occupied by a new fragment instance displaying the data for the United Kingdom.
  * **Right – United States Tab:** This shows the third fragment in the pager, displaying the information for the United States after another swipe gesture.

| Vietnam Tab | United Kingdom Tab | United States Tab |
| :-----------: | :-----------: | :-----------: |
|  <img src="./assets/demo_vn.jpg" alt="Demo VN" width="300"/>|<img src="./assets/demo_uk.jpg" alt="Demo UK" width="300"/>  |  <img src="./assets/demo_us.jpg" alt="Demo US" width="300"/>|

-----

## 🚀 Getting Started

Follow these instructions to get a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

  * **Android Studio** (latest stable version recommended)
  * **Java Development Kit (JDK)**

### 🧩 Installation

1.  **Clone the Repository**
    ```bash
    git clone git@github.com:JulianNguyen05/Android_Application.git
    ```
2.  **Open in Android Studio** and allow Gradle to sync.
3.  Click ▶️ **Run 'app'** to launch.

-----

## 🧑‍💻 Author

  * **Nguyễn Hữu Trọng (Julian)**
    *Learning Android Development with Java*
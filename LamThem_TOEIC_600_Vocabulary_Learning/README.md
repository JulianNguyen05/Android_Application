# LamThem_TOEIC_600_Vocabulary_Learning

This project is a practical implementation of a modern Android flashcard application, demonstrating how to effectively use **`ViewPager2`** and **`FragmentStateAdapter`** to create an efficient, swipe-based learning experience. The app is pre-loaded with around 100 essential TOEIC vocabulary words, serving as a real-world dataset.

The core of this application is not just the content, but the architecture that powers the user interface. It showcases how `ViewPager2`, built on the powerful engine of `RecyclerView`, is the ideal choice for paged content.

-----

## 🎥 Demo Video

Watch a short demo of the `ViewPager2` implementation in action:
[https://github.com/user-attachments/assets/25321032-edc7-45f7-89c3-0efb8d9a70ab](https://github.com/user-attachments/assets/25321032-edc7-45f7-89c3-0efb8d9a70ab)

-----

## 🧠 Core Implementation: Building with ViewPager2

This project was built to leverage the modern capabilities of `ViewPager2`, which offers significant advantages over the original `ViewPager` by being built upon `RecyclerView`. This provides superior memory management through view recycling and enhanced flexibility.

### 1️⃣ **Setting Up the `ViewPager2` in the Layout**

The foundation is a `ViewPager2` widget in `activity_main.xml`, which acts as the container for our swipeable fragments.

**`activity_main.xml`**

```xml
<androidx.viewpager2.widget.ViewPager2
    android:id="@+id/word_viewpager"
    android:layout_width="match_parent"
    android:layout_height="0dp"
    android:padding="16dp"
    app:layout_constraintTop_toBottomOf="@id/tvHeader"
    app:layout_constraintBottom_toBottomOf="parent"/>
```

### 2️⃣ **Connecting Data with `FragmentStateAdapter`**

The `WordCardAdapter` is the brain of the operation. It extends `FragmentStateAdapter`, the standard choice for using Fragments with `ViewPager2`. Its job is to efficiently provide a `WordCardFragment` for each `Word` object in our list.

**`WordCardAdapter.java`**

```java
public class WordCardAdapter extends FragmentStateAdapter {
    private List<Word> wordList;

    public WordCardAdapter(@NonNull FragmentActivity fragmentActivity, List<Word> wordList) {
        super(fragmentActivity);
        this.wordList = wordList;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // Create a new Fragment instance for the given position
        Word word = wordList.get(position);
        return WordCardFragment.newInstance(word);
    }

    @Override
    public int getItemCount() {
        // The total number of pages is the size of our word list
        return wordList.size();
    }
}
```

### 3️⃣ **Managing UI State within a Fragment**

Each flashcard is a self-contained `WordCardFragment`. The "tap-to-reveal" feature demonstrates how UI state can be managed within each fragment independently. This logic is simple, efficient, and doesn't require complex communication with the hosting Activity.

**`WordCardFragment.java`**

```java
LinearLayout cardContainer = view.findViewById(R.id.cardContainer);

cardContainer.setOnClickListener(v -> {
    // Check the current visibility of a detail view
    boolean isDetailsVisible = tvMeaning.getVisibility() == View.VISIBLE;
    
    // Toggle between GONE and VISIBLE
    int newVisibility = isDetailsVisible ? View.GONE : View.VISIBLE;

    tvType.setVisibility(newVisibility);
    tvMeaning.setVisibility(newVisibility);
    tvExample.setVisibility(newVisibility);
});
```

-----

## ✨ Key Technical Features

  - **Efficient View Recycling**: By leveraging the `RecyclerView` engine, `ViewPager2` only keeps a few fragments in memory at once, allowing it to handle hundreds or thousands of pages with minimal performance impact.
  - **Fragment Lifecycle Management**: `FragmentStateAdapter` correctly handles the lifecycle of each fragment, saving and restoring its state as you swipe.
  - **Modularity**: Each flashcard is an independent `Fragment`, making the code clean, easy to maintain, and scalable.
  - **Smooth Animations**: Page transformations and data updates (if implemented with `DiffUtil`) are handled smoothly by the underlying `RecyclerView` animator.

-----

## 🛠️ Tech Stack

| Category | Technology |
|-----------|-------------|
| **Language** | Java |
| **Platform** | Native Android |
| **UI Components** | **ViewPager2**, **Fragment**, ConstraintLayout, LinearLayout |
| **Data Storage** | Local JSON file (in `/assets`) |
| **Architecture** | Single-Activity structure (`MainActivity` as entry point) |

-----

## 📸 Screenshots

\<div style="display: flex; gap: 10px;"\>
\<img src="./assets/demo\_word.jpg" alt="Word Demo" width="300"/\>
\<img src="./assets/demo\_wordInfo.jpg" alt="Word Info Demo2" width="300"/\>
\</div\>

  * **Left – Initial Fragment State:** The `WordCardFragment` is first displayed with only the primary data visible.
  * **Right – Toggled Fragment State:** After a click event, the fragment updates its own UI to reveal additional information.

-----

## 🚀 Getting Started

### ✅ Prerequisites

  - **Android Studio:** Giraffe | 2023.1.1 or newer
  - **Android SDK:** API Level 26 (Oreo) or higher
  - **Device:** Android phone or emulator

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
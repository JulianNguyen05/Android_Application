Chắc chắn rồi\! Dưới đây là tệp `README.md` hoàn chỉnh của bạn, đã được cập nhật với phần mô tả và tên tệp cho từng hình ảnh bạn cung cấp.

**Lưu ý quan trọng:** Bạn hãy đổi tên các tệp ảnh của mình thành các tên mới mà tôi đã đề xuất dưới đây (ví dụ: `screenshot-initial-state.jpg`) và đặt chúng vào một thư mục trong dự án của bạn (ví dụ: một thư mục mới tên là `screenshots`). Sau đó, hãy cập nhật đường dẫn trong tệp README cho chính xác.

-----

# Currency Converter Application

A native Android application built with Java that provides a fast, accurate, and user-friendly currency conversion tool. The app features a modern interface focused on a smooth user experience with smart features like automatic number formatting and dynamic exchange rate display.

## 🎬 Demo

*(This is where you can place a video or GIF demonstrating the app. You can record your screen, upload it to YouTube/Imgur, and paste the link here.)*

**[Your Demo Video Link Here]**

## 📸 Screenshots

| Initial State & Currency Selection |
| :---: |
|  |
| **`screenshot-initial-state.jpg`**: The initial state of the application, with default currencies (USD to VND) selected and the result at 0.00. |
|  |
| **`screenshot-currency-selection.jpg`**: The custom currency selection dropdown, which clearly displays each country's flag next to the currency code. |

| Conversion Examples |
| :---: |
|  |
| **`screenshot-usd-to-vnd.jpg`**: Converting 1 USD to VND. The result correctly shows "25 450,00" with appropriate thousands separators. |
|  |
| **`screenshot-swapped-rate.jpg`**: After swapping currencies, the app displays the high-precision exchange rate for 1 VND in USD. |
|  |
| **`screenshot-vnd-to-usd.jpg`**: Converting 25,450 VND back to USD, demonstrating the accurate handling of very small exchange rates to get a result of "1,00". |
|  |
| **`screenshot-eur-to-usd.jpg`**: Another conversion example from EUR to USD, showcasing the automatic number formatting of the input value "25 450". |

## ✨ Key Features

  * **Currency Conversion:** Supports conversion between 5 popular currencies: USD, VND, EUR, JPY, and GBP.
  * **Custom UI:** Spinners display country flags alongside currency names for quick and intuitive recognition.
  * **Dynamic Exchange Rate:** Automatically calculates and displays the direct exchange rate between the two selected currencies.
  * **High-Precision Handling:** Accurately displays very small exchange rates (e.g., 1 VND = 0.000039 USD) instead of rounding to zero.
  * **Automatic Number Formatting:** Automatically adds a thousands separator as the user types, making large numbers easier to read.
  * **Swap Functionality:** Allows users to easily swap the "From" and "To" currencies with a single tap on the swap icon.
  * **Modern Design:** Utilizes components from Google's Material Design library for a professional and consistent feel.

## 🎨 Color Palette

The color palette was carefully chosen to create a harmonious, modern, and visually appealing interface.

| Color | Hex Code | Description |
| :--- | :--- | :--- |
| Main Background | `#F0F4F8` | A light, blue-gray background for the entire application. |
| Primary Blue | `#2962FF` | The main accent color used for buttons, titles, and focused outlines. |
| Accent Pink | `#FF4081` | A vibrant pink used for the exchange rate text to make it stand out. |
| Charcoal Gray | `#36454F` | The primary text color for the conversion result, ensuring readability. |
| Dropdown Background | `#E8EAF6` | The background color for the spinner's dropdown list. |

## 🚀 Setup and Installation

To get this project up and running on your local machine, follow these steps.

#### Prerequisites

  * Android Studio (latest version recommended).
  * JDK 11 or higher.

### Installation

1.  Clone this repository:

    ```bash
    git clone git@github.com:JulianNguyen05/Android_Application.git
    ```

2.  Open the project in **Android Studio**.

3.  Let Gradle sync and build the project.

4.  Run the app on an emulator or physical device.

#### Key Components

This project relies on the Material Design library for advanced UI components. Ensure your `build.gradle` (Module: app) file includes the following dependency:

```groovy
implementation 'com.google.android.material:material:1.12.0' // Or a newer version
```

## 💡 Core Concepts & Code Snippets

These are the most important code segments that solve the core challenges of the application.

### 1\. Automatic Number Formatting (`NumberTextWatcher`)

To improve the user experience, the app automatically formats numbers with a thousands separator as the user types. This is achieved using a custom `TextWatcher` class.

```java
// Inside MainActivity.java
private static class NumberTextWatcher implements TextWatcher {
    private final EditText editText;
    private final DecimalFormat df;

    // ... constructor ...

    @Override
    public void afterTextChanged(Editable s) {
        // Remove the listener to prevent an infinite loop
        editText.removeTextChangedListener(this);
        try {
            String originalString = s.toString();
            if (!originalString.isEmpty()) {
                // Parse the string (with old formatting removed) into a number
                Number number = df.parse(originalString);
                // Reformat the number and update the EditText
                String formattedString = df.format(number);
                editText.setText(formattedString);
                editText.setSelection(formattedString.length());
            }
        } catch (ParseException e) {
            // Ignore parsing errors while the user is typing
        }
        // Re-add the listener
        editText.addTextChangedListener(this);
    }
}
```

### 2\. High-Precision Rate Display (Conditional Formatting)

To solve the issue of very small exchange rates being rounded to 0, the app uses conditional logic to select the appropriate number formatter based on the rate's value.

```java
// Inside MainActivity.java
private void updateExchangeRateDisplay() {
    // ... calculate directRate ...

    String formattedRate;
    // Conditional logic: if the rate is very small, use the high-precision formatter
    if (directRate > 0 && directRate < 0.01) {
        formattedRate = preciseRateFormatter.format(directRate);
    } else {
    // Otherwise, use the normal formatter
        formattedRate = normalRateFormatter.format(directRate);
    }

    String rateText = "Rate: 1 " + fromCode + " = " + formattedRate + " " + toCode;
    tvExchangeRate.setText(rateText);
}
```

### 3\. Custom Spinner with Flags (`CurrencyAdapter`)

A custom `ArrayAdapter` is used to display both a flag and the currency name in the spinner, rather than just plain text.

```java
// In CurrencyAdapter.java
public class CurrencyAdapter extends ArrayAdapter<CurrencyItem> {
    // ... constructor ...

    private View initView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            // Inflate the custom layout
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.spinner_item_with_flag, parent, false
            );
        }

        ImageView imageViewFlag = convertView.findViewById(R.id.ivFlag);
        TextView textViewName = convertView.findViewById(R.id.tvCurrencyName);
        CurrencyItem currentItem = getItem(position);

        if (currentItem != null) {
            // Set the data (flag and name) to the views
            imageViewFlag.setImageResource(currentItem.getFlagImage());
            textViewName.setText(currentItem.getCurrencyName());
        }

        return convertView;
    }
}
```

## 🧑‍💻 Author

  * **Nguyễn Hữu Trọng (Julian)**
    *Learning Android Development with Java*

-----
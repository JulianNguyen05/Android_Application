package th.nguyenhuutrong.th_currency_converter;

public class CurrencyItem {
    private final String code;
    private final int flagResId;

    public CurrencyItem(String code, int flagResId) {
        this.code = code;
        this.flagResId = flagResId;
    }

    public String getCode(){
        return code;
    }

    public int getFlagResId() {
        return flagResId;
    }
}

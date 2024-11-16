package Entity;

import java.util.HashMap;
import java.util.Map;

public class ProductData {
    private int idSanPham;
    private int click;
    private int addToCart;
    private int checkOut;
    private String dateTime;

    public ProductData(int idSanPham, int click, int addToCart, int checkOut, String dateTime) {
        this.idSanPham = idSanPham;
        this.click = click;
        this.addToCart = addToCart;
        this.checkOut = checkOut;
        this.dateTime = dateTime;
    }

    public int getIdSanPham() { return idSanPham; }
    public int getClick() { return click; }
    public int getAddToCart() { return addToCart; }
    public int getCheckOut() { return checkOut; }
    public String getDateTime() { return dateTime; }

    public static Map<String, Double> calculatePercentages(int click, int addToCart, int checkOut) {
        double total = click + addToCart + checkOut;
        Map<String, Double> percentages = new HashMap<>();
        if (total > 0) {
            percentages.put("click", (click / total) * 100);
            percentages.put("addToCart", (addToCart / total) * 100);
            percentages.put("checkOut", (checkOut / total) * 100);
        }
        return percentages;
    }
}
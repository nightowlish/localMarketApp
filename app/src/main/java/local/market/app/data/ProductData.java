package local.market.app.data;

import android.graphics.Bitmap;

public class ProductData {
    public String name;
    public double price;
    public Bitmap image;
    public int category;

    public ProductData(String name, double price, Bitmap image, int category) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.category = category;
    }
}

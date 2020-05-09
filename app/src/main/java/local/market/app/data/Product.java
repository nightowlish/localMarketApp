package local.market.app.data;

import android.graphics.Bitmap;

public class Product {
    public String name;
    private double price;
    private Bitmap image;
    private int category;
    private String ownerEmail;

    public Product(String name, double price, Bitmap image, int category, String ownerEmail) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.category = category;
        this.ownerEmail = ownerEmail;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Bitmap getImage() {
        return image;
    }

    public int getCategory() {
        return category;
    }
}

package local.market.app.data;

import android.graphics.Bitmap;

public class Product {
    public String name;
    private double price;
    private Bitmap image;
    private int category;
    private String ownerEmail;
    private String ownerPhone;
    private int amount = 0;

    public Product(String name, double price, Bitmap image, int category, String ownerEmail, String ownerPhone) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.category = category;
        this.ownerEmail = ownerEmail;
        this.ownerPhone = ownerPhone;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public String getOwnerPhone() { return ownerPhone; }

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

    public void increaseAmount() {
        amount++;
    }
    public void decreaseAmount() {
        if (amount > 0) {
            amount--;
        }
    }
    public int getAmount() {
        return amount;
    }
}

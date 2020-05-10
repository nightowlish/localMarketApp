package local.market.app.data;

import java.util.ArrayList;
import java.util.List;

public class Data {
    private static String email;
    private static String phone;
    private static String address;
    private static ArrayList<Product> products;
    public static Data instance;

    public Data(String email) {
        this.email = email;
        init();
    }

    public static String getEmail() {
        return email;
    }

    public static String getPhone() {
        return phone;
    }

    public static String getAddress() {
        return address;
    }

    public static ArrayList<Product> getOwnedProducts() {
        ArrayList<Product> ownedProducts = new ArrayList<Product>();
        for (Product prod: products) {
            if (prod.getOwnerEmail() == email)
                ownedProducts.add(prod);
        }
        return ownedProducts;
    }

    public static ArrayList<Product> getCategoryProducts(int category) {
        ArrayList<Product> categoryProducts = new ArrayList<Product>();
        for (Product prod: products) {
            if (prod.getCategory() == category)
                categoryProducts.add(prod);
        }
        return categoryProducts;
    }

    public static ArrayList<Product> getCartProducts() {
        ArrayList<Product> cartProducts = new ArrayList<Product>();
        for (Product prod: products) {
            if (prod.getAmount() != 0)
                cartProducts.add(prod);
        }
        return cartProducts;
    }

    public void init() {
        // query server email and init info based on response
    }

    public static void refresh() {
        // query server email for data refresh after adding product
    }
}

package local.market.app.data;

import java.util.ArrayList;
import java.util.List;

public class Data {
    private static String email;
    private static String phone;
    private static String address;
    private static List<Product> products;
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

    public static List<Product> getOwnedProducts() {
        List<Product> ownedProducts = new ArrayList<Product>();
        for (Product prod: products) {
            if (prod.getOwnerEmail() == email)
                ownedProducts.add(prod);
        }
        return ownedProducts;
    }

    public static List<Product> getCategoryProducts(int category) {
        List<Product> categoryProducts = new ArrayList<Product>();
        for (Product prod: products) {
            if (prod.getCategory() == category)
                categoryProducts.add(prod);
        }
        return categoryProducts;
    }

    public static List<Product> getAllProducts() { return products; }

    public void init() {
        // query server email and init info based on response
    }
}

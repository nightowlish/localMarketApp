package local.market.app.data;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Data implements Response {
    private static Server server = new Server();
    private String result = null;
    private static String email;
    private static String phone;
    private static String address;
    private static ArrayList<Product> products = new ArrayList<Product>();
    public static Data instance;

    public Data(String email) {
        this.email = email;
        init();
    }

    public Data() {}

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
        refresh();
    }

    public void refresh() {
        server.delegate = this;
        JSONObject postData = new JSONObject();
        try {
            postData.put("command", "getProducts");
            server.execute(postData.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        while (result == null) {}

        try {
            JSONObject json = new JSONObject(result);
            JSONArray productList = json.getJSONArray("products");
            for (int i = 0; i < productList.length(); i++) {
                String name = productList.getJSONObject(i).getString("name");
                double price = productList.getJSONObject(i).getDouble("price");
                String email = productList.getJSONObject(i).getString("ownerPhone");
                String phone = productList.getJSONObject(i).getString("ownerPhone");
                int category = productList.getJSONObject(i).getInt("category");
                String sImage = productList.getJSONObject(i).getString("image");
                byte[] decodedString = Base64.decode(sImage, Base64.NO_WRAP);
                InputStream inputStream  = new ByteArrayInputStream(decodedString);
                Bitmap image  = BitmapFactory.decodeStream(inputStream);
                products.add(new Product(name, price, image, category, email, phone));
            }
        } catch (JSONException e) {
            e.printStackTrace();
            result = null;
            return;
        }
        result = null;
    }

    @Override
    public void processFinish(String result){
        this.result = result;
    }
}

package local.market.app.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import local.market.app.R;

public class OwnProductAdapter extends ArrayAdapter<Product> implements Response {
    Product currentProduct;
    Server server = new Server();
    String result = null;
    Button delete;
    TextView name, price;
    ImageView image;
    public OwnProductAdapter(Context context, ArrayList<Product> products) {
        super(context, 0, products);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Product product = getItem(position);
        currentProduct = product;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_layout, parent, false);
        }

        name = (TextView) convertView.findViewById(R.id.textView14);
        price = (TextView) convertView.findViewById(R.id.textView12);
        image = (ImageView) convertView.findViewById(R.id.imageView);
        delete = (Button) convertView.findViewById(R.id.button12);

        name.setText(product.getName());
        price.setText(String.valueOf(product.getPrice()));
        image.setImageBitmap(product.getImage());
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteProduct();
            }
        });
        return convertView;
    }
    public void deleteProduct() {
        server.delegate = this;
        JSONObject postData = new JSONObject();
        try {
            postData.put("command", "deleteProduct");
            postData.put("email", Data.getEmail());
            postData.put("productName", currentProduct.getName());
            if (Data.DEBUG == false)
                new Server().execute(postData.toString());
            else
                return;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        while (result == null) {}
        if (result != "SUCCESS") {
            result = null;
            return;
        }
        result = null;
        new Data().refresh();
        this.notifyDataSetChanged();
    }

    @Override
    public void processFinish(String result){
        this.result = result;
    }

}

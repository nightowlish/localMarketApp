package local.market.app.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import local.market.app.R;

public class ProductAdapter extends ArrayAdapter<Product> {
    Product currentProduct;
    Button minus, plus;
    TextView amount, name, price;
    ImageView image;
    public ProductAdapter(Context context, ArrayList<Product> products) {
        super(context, 0, products);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Product product = getItem(position);
        currentProduct = product;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_layout, parent, false);
        }

        name = (TextView) convertView.findViewById(R.id.textView18);
        price = (TextView) convertView.findViewById(R.id.textView17);
        amount = (TextView) convertView.findViewById(R.id.textView13);
        image = (ImageView) convertView.findViewById(R.id.imageView2);
        plus = (Button) convertView.findViewById(R.id.button15);
        minus = (Button) convertView.findViewById(R.id.button16);

        name.setText(product.getName());
        price.setText(String.valueOf(product.getPrice()));
        image.setImageBitmap(product.getImage());
        amount.setText(String.valueOf(product.getAmount()));
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentProduct.getAmount() == 0)
                    minus.setEnabled(true);
                currentProduct.increaseAmount();
                amount.setText(String.valueOf(currentProduct.getAmount()));
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentProduct.decreaseAmount();
                if (currentProduct.getAmount() == 0)
                    minus.setEnabled(false);
                amount.setText(String.valueOf(currentProduct.getAmount()));
            }
        });
        return convertView;
    }
}

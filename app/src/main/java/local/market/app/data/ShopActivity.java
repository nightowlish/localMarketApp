package local.market.app.data;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import local.market.app.R;

public class ShopActivity extends AppCompatActivity {
    private ArrayList<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        Button shopCart = (Button) findViewById(R.id.button14);
        shopCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(ShopActivity.this, ShoppingCartActivity.class);
                ShopActivity.this.startActivity(myIntent);
            }
        });

        ListView listview = (ListView) findViewById(R.id.listView);
        int category = Integer.parseInt(getIntent().getStringExtra("category"));
        products = Data.getCategoryProducts(category);
        ProductAdapter adapter = new ProductAdapter(getBaseContext(), products);
        listview.setAdapter(adapter);

    }
}

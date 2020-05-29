package local.market.app.data;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import local.market.app.R;

public class SellActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);

        Button addProduct = (Button) findViewById(R.id.button13);
        addProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(SellActivity.this, AddProductActivity.class);
                SellActivity.this.startActivity(myIntent);
            }
        });

        ListView listview = (ListView) findViewById(R.id.listView7);
        ArrayList<Product> products = Data.getOwnedProducts();
        OwnProductAdapter adapter = new OwnProductAdapter(getBaseContext(), products);
        listview.setAdapter(adapter);

    }
}

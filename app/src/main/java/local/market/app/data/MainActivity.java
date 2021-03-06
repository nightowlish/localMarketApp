package local.market.app.data;

import androidx.appcompat.app.AppCompatActivity;
import local.market.app.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bShop = (Button) findViewById(R.id.button);
        bShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, CategoryActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });
        Button bSell = (Button) findViewById(R.id.button2);
        bSell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, SellActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });
    }
}

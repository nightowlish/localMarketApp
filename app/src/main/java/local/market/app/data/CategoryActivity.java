package local.market.app.data;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import local.market.app.R;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        Button b1 = (Button) findViewById(R.id.button5);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startCategory(1);
            }
        });
        Button b2 = (Button) findViewById(R.id.button6);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startCategory(2);
            }
        });
        Button b3 = (Button) findViewById(R.id.button7);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startCategory(3);
            }
        });
        Button b4 = (Button) findViewById(R.id.button8);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startCategory(4);
            }
        });
        Button b5 = (Button) findViewById(R.id.button9);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startCategory(5);
            }
        });
    }

    private void startCategory(int i) {
        Intent myIntent = new Intent(CategoryActivity.this, ShopActivity.class);
        myIntent.putExtra("category", Integer.toString(i));
        CategoryActivity.this.startActivity(myIntent);
    }

}

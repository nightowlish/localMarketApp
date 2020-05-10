package local.market.app.data;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import local.market.app.R;

public class ShoppingCartActivity extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS =0 ;
    ListView listview;
    Button order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        listview = (ListView) findViewById(R.id.listView2);
        ArrayList<Product> products = Data.getCartProducts();
        ProductAdapter adapter = new ProductAdapter(getBaseContext(), products);
        listview.setAdapter(adapter);

        order = (Button) findViewById(R.id.button17);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                order();
            }
        });
    }
    public void order() {
        sendOrderTexts();
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setMessage("Your order was placed! The producers were informed of your order and address.");
        dialog.setTitle("Order placed successfully");
        dialog.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent myIntent = new Intent(ShoppingCartActivity.this, MainActivity.class);
                        ShoppingCartActivity.this.startActivity(myIntent);
                    }
                });
        AlertDialog alertDialog=dialog.create();
        alertDialog.show();
    }

    public void sendOrderTexts() {

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            if (!ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.SEND_SMS)) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, MY_PERMISSIONS_REQUEST_SEND_SMS);
            }
        }
        SmsManager smsManager = SmsManager.getDefault();
        for (Product prod: Data.getCartProducts()) {
            String message = "User with phone number " + Data.getPhone() + " ordered " + String.valueOf(prod.getAmount()) + " of your product named " + prod.getName() + ". ";
            message += "Please send order to address " + Data.getAddress();
            smsManager.sendTextMessage(prod.getOwnerPhone(), null, message, null, null);
        }
    }
}

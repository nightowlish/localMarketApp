package local.market.app.data;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.InputStream;

import local.market.app.R;

public class AddProductActivity extends AppCompatActivity {
    public static final int IMAGE_RESULT = 1;
    EditText etName, etPrice;
    Button bChooseImage, bAdd;
    RadioButton c1, c2, c3, c4, c5;
    Bitmap image = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        bChooseImage = (Button) findViewById(R.id.button10);
        bChooseImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                chooseImage();
            }
        });
        bAdd = (Button) findViewById(R.id.button11);
        bAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                add();
            }
        });
    }
    private void chooseImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), IMAGE_RESULT);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == IMAGE_RESULT && resultCode == Activity.RESULT_OK) {
            if (data == null) {
                Toast.makeText(getBaseContext(), "Image not selected!", Toast.LENGTH_SHORT).show();
                return;
            }
            try {
                InputStream inputStream = this.getContentResolver().openInputStream(data.getData());
                image = BitmapFactory.decodeStream(inputStream);
            } catch (FileNotFoundException e) {
                Toast.makeText(getBaseContext(), "Invalid image!", Toast.LENGTH_SHORT).show();
                return;
            }
        }
    }
    private void add() {
        String name = etName.getText().toString();
        String sPrice = etPrice.getText().toString();

        int category = c1.isChecked() ? 1 : c2.isChecked() ? 2 : c3.isChecked() ? 3 : c4.isChecked() ? 4 : c5.isChecked() ? 5 : 0;
        if (name.isEmpty() || sPrice.isEmpty() || category == 0 || image == null) {
            Toast.makeText(getBaseContext(), "Please fill in all data!" , Toast.LENGTH_SHORT).show();
            return;
        }
        int price = Integer.parseInt(sPrice);
        JSONObject postData = new JSONObject();
        try {
            postData.put("command", "addProduct");
            postData.put("email", Data.getEmail());
            postData.put("prodName", name);
            postData.put("prodPrice", price);
            postData.put("prodCategory", category);
            postData.put("prodImage", image);
            new Server().execute(postData.toString());
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(getBaseContext(), "Adding product failed!", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(getBaseContext(), "Product added successfully!", Toast.LENGTH_SHORT).show();
        new Data().refresh();
    }
}

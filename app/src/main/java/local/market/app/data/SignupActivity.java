package local.market.app.data;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import local.market.app.R;

public class SignupActivity extends AppCompatActivity implements Response {
    Server server = new Server();
    String result = null;
    EditText password;
    EditText email;
    EditText address;
    EditText phoneNumber;
    EditText location;
    String p;
    String e;
    String a;
    String pn;
    String l;
    Button buttonUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        password = (EditText) findViewById(R.id.editText6);
        email = (EditText) findViewById(R.id.editText3);
        phoneNumber = (EditText) findViewById(R.id.editText4);
        address = (EditText) findViewById(R.id.editText5);
        buttonUp = (Button) findViewById(R.id.button4);
        location = (EditText) findViewById(R.id.editText9);

        buttonUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                signUp();
            }
        });
    }
    private void signUp() {
        p = password.getText().toString();
        e = email.getText().toString();
        a = address.getText().toString();
        pn = phoneNumber.getText().toString();
        l = location.getText().toString();
        if (p.isEmpty() || e.isEmpty() || a.isEmpty() || pn.isEmpty() || l.isEmpty()) {
            Toast.makeText(getBaseContext(), "Please fill in all data before submitting!" , Toast.LENGTH_SHORT).show();
            return;
        }
        if (!checkSignupData(e, p, a, pn, l)) {
            Toast.makeText(getBaseContext(), "Invalid data!" , Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(getBaseContext(), "Signup Successful!" , Toast.LENGTH_SHORT).show();
        Intent myIntent = new Intent(SignupActivity.this, LoginActivity.class);
        SignupActivity.this.startActivity(myIntent);
    }

    private Boolean checkSignupData(String email, String password, String address, String phoneNumber, String location) {
        server.delegate = this;
        JSONObject postData = new JSONObject();
        try {
            postData.put("command", "checkSignup");
            postData.put("email", email);
            postData.put("address", address);
            postData.put("phone", phoneNumber);
            postData.put("location", location);
            if (Data.DEBUG == false)
                server.execute(postData.toString());
            else
                return true;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        while (result == null) {}
        if (result == "SUCCESS")
            return true;
        result = null;
        return false;
    }

    @Override
    public void processFinish(String result){
        this.result = result;
    }

}

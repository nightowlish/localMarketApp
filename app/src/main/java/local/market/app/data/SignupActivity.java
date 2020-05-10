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
    String p;
    String e;
    String a;
    String pn;
    Button buttonUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
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
        if (p.isEmpty() || e.isEmpty() || a.isEmpty() || pn.isEmpty()) {
            Toast.makeText(getBaseContext(), "Please fill in all data before submitting!" , Toast.LENGTH_SHORT).show();
            return;
        }
        if (!checkSignupData(e, p, a, pn)) {
            Toast.makeText(getBaseContext(), "Invalid data!" , Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(getBaseContext(), "Signup Successful!" , Toast.LENGTH_SHORT).show();
        Intent myIntent = new Intent(SignupActivity.this, LoginActivity.class);
        SignupActivity.this.startActivity(myIntent);
    }

    private Boolean checkSignupData(String email, String password, String address, String phoneNumber) {
        server.delegate = this;
        JSONObject postData = new JSONObject();
        try {
            postData.put("command", "checkSignup");
            postData.put("email", email);
            postData.put("address", address);
            postData.put("phone", phoneNumber);
            server.execute(postData.toString());
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

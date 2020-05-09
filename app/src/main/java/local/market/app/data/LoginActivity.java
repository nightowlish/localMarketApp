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

public class LoginActivity extends AppCompatActivity implements Response {
    Server server = new Server();
    String result = null;
    EditText password;
    EditText email;
    String e;
    String p;
    Button buttonIn;
    Button buttonUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        password = (EditText) findViewById(R.id.editText);
        email = (EditText) findViewById(R.id.editText2);
        buttonUp = (Button) findViewById(R.id.button19);
        buttonIn = (Button) findViewById(R.id.button3);
        buttonIn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                login();
            }
        });
        buttonUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                signUp();
            }
        });
    }

    private void signUp() {
        Intent myIntent = new Intent(LoginActivity.this, SignupActivity.class);
        LoginActivity.this.startActivity(myIntent);
    }

    private void login() {
        e = email.getText().toString();
        p = password.getText().toString();
        if (e.isEmpty() || p.isEmpty()) {
            Toast.makeText(getBaseContext(), "Please fill in email and password!" , Toast.LENGTH_SHORT).show();
            return;
        }
        if (!checkLoginData(e, p)) {
            Toast.makeText(getBaseContext(), "Incorrect email or password!" , Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(getBaseContext(), "Login Successful!" , Toast.LENGTH_SHORT).show();

        Intent myIntent = new Intent(LoginActivity.this, MainActivity.class);
        LoginActivity.this.startActivity(myIntent);
    }

    private Boolean checkLoginData(String email, String password) {
        server.delegate = this;
        JSONObject postData = new JSONObject();
        try {
            postData.put("command", "checkLogin");
            postData.put("email", email);
            postData.put("password", password);
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

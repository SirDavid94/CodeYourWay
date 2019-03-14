package vcu.cmsc355.codeyourway;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class LoginActivity extends AppCompatActivity {
    //EditText textEmail;
    EditText textUsername;
    EditText textPassword;
    Button buttonLogin;
    TextView ForgotPasswordButton;
    TextView ForgotUsernameButton;
    TextView textViewRegister;
    DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new DatabaseHelper(this);
        textUsername = (EditText)findViewById(R.id.text_username);
        textPassword = (EditText)findViewById(R.id.text_password);
        ForgotPasswordButton =(TextView) findViewById(R.id.forgot_Password);
        ForgotUsernameButton = (TextView) findViewById(R.id.forgot_username);
        buttonLogin = (Button)findViewById(R.id.button_login);
        textViewRegister = (TextView)findViewById(R.id.text_register);
        textViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent registerIntent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(registerIntent);
            }
        });

        //ForgotUsernameButton.setOnClickListener();


        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = textUsername.getText().toString().trim();
                String pwd = textPassword.getText().toString().trim();
                Boolean res = db.checkUser(user,pwd);
                if (res == true)
                {
                    Intent loginActivity = new Intent(LoginActivity.this, WalkthroughActivity.class);
                    startActivity(loginActivity);
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "login Error", Toast. LENGTH_SHORT).show();

                }
            }
        }


        );



    }
}

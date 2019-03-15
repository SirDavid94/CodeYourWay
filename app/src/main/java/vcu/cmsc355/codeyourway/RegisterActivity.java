package vcu.cmsc355.codeyourway;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


//Instantiating variables
public class RegisterActivity extends AppCompatActivity {

    EditText textFirstName;
    EditText textLastName;
    EditText textExpertise;
    EditText textEmail;
    EditText textUsername;
    EditText textPassword;
    EditText textCnfPassword;
    Button buttonRegister;
    TextView textViewLogin;
    DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        textExpertise = (EditText) findViewById(R.id.textExpertise);
        db = new DatabaseHelper(this);
        textFirstName = (EditText) findViewById(R.id.textFirstName);
        textLastName = (EditText) findViewById(R.id.textLastName);
        textEmail = (EditText) findViewById(R.id.text_email);
        textUsername = (EditText) findViewById(R.id.text_username);
        textPassword = (EditText) findViewById(R.id.text_password);
        textCnfPassword = (EditText) findViewById(R.id.text_cnf_password);
        buttonRegister = (Button) findViewById(R.id.button_register);
        textViewLogin = (TextView) findViewById(R.id.text_login);

        //opens the Login Page if the login button is clicked
        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(LoginIntent);
            }
        });

        //Uses valid user info to create an account
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = textEmail.getText().toString().trim();
                String user = textUsername.getText().toString().trim();
                String pwd = textPassword.getText().toString().trim();
                String cnf_pwd = textCnfPassword.getText().toString().trim();
                String firstName = textFirstName.getText().toString().trim();
                String lastName = textLastName.getText().toString().trim();
                String exp = textExpertise.getText().toString().trim();

                //checks if email and password is valid
                if ( Validate() )
                {
                    Toast.makeText(RegisterActivity.this, "Invalid Username/Password Combo", Toast.LENGTH_SHORT).show();

                }
                //checks if email is valid
                else if (ValidateEmail())
                {
                    Toast.makeText(RegisterActivity.this, "Invalid Email", Toast.LENGTH_SHORT).show();
                }
                else if ( db.MultipleUser(user, email) )
                {
                    Toast.makeText(RegisterActivity.this, "Account already Exists!!", Toast.LENGTH_SHORT).show();
                }
                else {
                        //Checks if user password matches
                    if (pwd.equals(cnf_pwd)) {

                        long val = db.addUser(email, user, pwd,firstName, lastName, exp);
                        if (val > 0) {

                            Toast.makeText(RegisterActivity.this, "Account Registered ", Toast.LENGTH_SHORT).show();
                            Intent moveToLogin = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(moveToLogin);
                        } else {

                            Toast.makeText(RegisterActivity.this, "Registration error", Toast.LENGTH_SHORT).show();

                        }

                    } else {
                        Toast.makeText(RegisterActivity.this, "Password doesn't match", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });


    }

    /**
     * This ensure user uses a minimum of three characters for username & a minimum of 4 characters for password
     * @return boolean true if username is less than 3 characters and if password is less than 4 and
     * false if otherwise
     */
    private boolean Validate() {

        if ((textUsername.getText().length() < 3) || (textPassword.getText().length() < 4)) {
            return true;
        }
        return false;
    }

    /**
     * function checks for specific characters in email
     * @return boolean true if email contains required characters and false if otherwise
     */
    private boolean ValidateEmail() {

        if (textEmail.getText().toString().contains("@") || textEmail.getText().toString().contains(".") ) {
            return false;
        }
        return true;
    }
}

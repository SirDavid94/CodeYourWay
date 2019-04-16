package vcu.cmsc355.codeyourway;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import vcu.cmsc355.codeyourway.Model.Common;
import vcu.cmsc355.codeyourway.Model.User;
import vcu.cmsc355.codeyourway.WalkThrough.WalkThroughActivity;


public class LoginActivity extends AppCompatActivity {

    //Instantiating variables
    public EditText textUsername;
    EditText textPassword;
    Button buttonLogin;
    TextView ForgotPasswordButton;
    TextView ForgotUsernameButton;
    TextView textViewRegister;

    //Instantiating Database
    FirebaseDatabase database;
    DatabaseReference users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // make the activity on full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // hides the action bar
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);


        database = FirebaseDatabase.getInstance();
        users = database.getReference("Users");
        textUsername = (EditText) findViewById(R.id.text_username);
        textPassword = (EditText) findViewById(R.id.text_password);
        ForgotPasswordButton = (TextView) findViewById(R.id.forgot_Password);
        ForgotUsernameButton = (TextView) findViewById(R.id.forgot_username);
        buttonLogin = (Button) findViewById(R.id.button_login);
        textViewRegister = (TextView) findViewById(R.id.text_register);

        // button Opens the Registration page when clicked
        textViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(registerIntent);


            }
        });

        //Button is under development. Displays toast until completion
        ForgotUsernameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "Button Under Development", Toast.LENGTH_SHORT).show();
            }
        });

        //Resets Password
        ForgotPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resetPasswordIntent = new Intent(LoginActivity.this, ResetPasswordActivity.class);
                startActivity(resetPasswordIntent);

            }
        });

        //Uses the SignIn function to sign User into app with valid info
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignIn(textUsername.getText().toString().trim().toLowerCase(),
                        textPassword.getText().toString().trim());
            }
        });


    }

    /**
     * Verifies if provided username and password matches record on firebase database
     * The user is redirected to the login page if successful or an error toast is
     * given if otherwise
     * @param user username provided
     * @param pwd  password provided
     */
    private void SignIn(final String user, final String pwd) {
        users.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(user).exists()) {
                    if (!user.isEmpty()) {
                        User login  = dataSnapshot.child(user).getValue(User.class);

                                if (login.getPassword().equals(pwd)) {

                            Intent successfulLogin = new Intent(LoginActivity.this, WalkThroughActivity.class);
                            successfulLogin.putExtra("username",user);
                            startActivity(successfulLogin);
                            Common.currentUser = user;

                        } else {
                            Toast.makeText(LoginActivity.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(LoginActivity.this, "Please enter Username", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                    Toast.makeText(LoginActivity.this, "User not found ! ", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled( DatabaseError databaseError) {

                Toast.makeText(LoginActivity.this, "Error, Please check your Internet Connection", Toast.LENGTH_SHORT).show();

            }


        });

    }

}




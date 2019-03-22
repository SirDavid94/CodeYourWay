package vcu.cmsc355.codeyourway;


import android.app.Notification;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.Query;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.ChildEventListener;
import vcu.cmsc355.codeyourway.Model.User;



//Instantiating variables
public class LoginActivity extends AppCompatActivity {

    public static String walkthroughUser;
    public EditText textUsername;
    EditText textPassword;
    Button buttonLogin;
    TextView ForgotPasswordButton;
    TextView ForgotUsernameButton;
    TextView textViewRegister;

    FirebaseDatabase database;
    DatabaseReference users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        database = FirebaseDatabase.getInstance();
        users = database.getReference("Users");

        textUsername = (EditText) findViewById(R.id.text_username);
        textPassword = (EditText) findViewById(R.id.text_password);
        ForgotPasswordButton = (TextView) findViewById(R.id.forgot_Password);
        ForgotUsernameButton = (TextView) findViewById(R.id.forgot_username);
        buttonLogin = (Button) findViewById(R.id.button_login);
        textViewRegister = (TextView) findViewById(R.id.text_register);


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

        //Button is under development. Displays toast until completion
        ForgotPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "Button Under Development", Toast.LENGTH_SHORT).show();
            }
        });


        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignIn(textUsername.getText().toString().trim(),
                        textPassword.getText().toString().trim());
            }
        });


    }

    private void SignIn(final String userName, final String pwd) {
        users.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(userName).exists()) {
                    if (!userName.isEmpty()) {
                        User user = dataSnapshot.getValue(User.class);

                        Toast.makeText(LoginActivity.this, "Logging in User", Toast.LENGTH_SHORT).show();
                        if (user.getPassword().equals(pwd)) {
                            Toast.makeText(LoginActivity.this, "Logging in User", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(LoginActivity.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(LoginActivity.this, "Please enter Username", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onCancelled( DatabaseError databaseError) {

            }


        });

    }

    /**
     * passes non static username variable to a static context
     * @return Static variable username
     */
    public  String getUser() {
        return walkthroughUser;

    }




}




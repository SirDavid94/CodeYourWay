package vcu.cmsc355.codeyourway;


import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.ChildEventListener;

import vcu.cmsc355.codeyourway.Model.Awards;
import vcu.cmsc355.codeyourway.Model.Common;
import vcu.cmsc355.codeyourway.Model.User;

//Instantiating variables
public class RegisterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText textFirstName;
    EditText textLastName;
    Spinner textExpertise;
    EditText textEmail;
    EditText textUsername;
    EditText textPassword;
    EditText textCnfPassword;
    Button buttonRegister;
    TextView textViewLogin;
    int awardCount =0;


    FirebaseDatabase database;
    DatabaseReference users, Award;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        database = FirebaseDatabase.getInstance();
        users = database.getReference("Users");
        Award = database.getReference("Awards");
        textFirstName = (EditText) findViewById(R.id.textFirstName);
        textLastName = (EditText) findViewById(R.id.textLastName);
        textEmail = (EditText) findViewById(R.id.text_email);
        textUsername = (EditText) findViewById(R.id.text_username);
        textPassword = (EditText) findViewById(R.id.text_password);
        textExpertise = (Spinner) findViewById(R.id.textExpertise);
        textCnfPassword = (EditText) findViewById(R.id.text_cnf_password);
        buttonRegister = (Button) findViewById(R.id.button_register);
        textViewLogin = (TextView) findViewById(R.id.text_login);
        textExpertise.setOnItemSelectedListener(this);



        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.expertise, android.R.layout.simple_spinner_item);
         // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        textExpertise.setAdapter(adapter);





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

                if ( Validate() )
                {
                    Toast.makeText(RegisterActivity.this, "Invalid Username/Password Combo", Toast.LENGTH_SHORT).show();

                }
                //checks if email is valid
                else if (ValidateEmail())
                {
                    Toast.makeText(RegisterActivity.this, "Invalid Email", Toast.LENGTH_SHORT).show();
                }

                else if (ValidatePwd())
                {
                    Toast.makeText(RegisterActivity.this, "Passwords doesn't match", Toast.LENGTH_SHORT).show();
                }
                else
                SignUp();
            }

        });


    }

    private void SignUp() {
        textUsername = (EditText) findViewById(R.id.text_username);
        textPassword = (EditText) findViewById(R.id.text_password);
        textEmail = (EditText) findViewById(R.id.text_email);
        textFirstName = (EditText) findViewById(R.id.textFirstName);
        textLastName = (EditText) findViewById(R.id.textLastName);
        textExpertise = (Spinner) findViewById(R.id.textExpertise);
        textCnfPassword = (EditText) findViewById(R.id.text_cnf_password);


        final Awards awardUpload = new Awards(textUsername.getText().toString().trim(),
                awardCount);


        final User user = new User(textUsername.getText().toString().trim(),
                textPassword.getText().toString().trim(),
                textEmail.getText().toString().trim(),
                textFirstName.getText().toString().trim(),
                textLastName.getText().toString().trim(),
                String.valueOf(textExpertise.getSelectedItem()));
        users.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(user.getUsername()).exists())

                    Toast.makeText(RegisterActivity.this, "User Already exists !", Toast.LENGTH_SHORT).show();
                else {
                    //Creates user profile in user database
                    users.child(user.getUsername())
                            .setValue(user);
                        //Creates an award profile for user
                    Award.child(Awards.getUser())
                            .setValue(awardUpload);
                    Toast.makeText(RegisterActivity.this, "User Registration Successful !", Toast.LENGTH_SHORT).show();

                    startActivity( new Intent(RegisterActivity.this, LoginActivity.class));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Toast.makeText(RegisterActivity.this, "Database Error !", Toast.LENGTH_SHORT).show();


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

        if (textEmail.getText().toString().contains("@") && textEmail.getText().toString().contains(".") ) {
            return false;
        }
        return true;
    }

    /**
     * function validates User password for a match
     * @return boolean true if passwords match and false if otherwise
     */
    private boolean ValidatePwd() {

        if (textPassword.getText().toString().equals(textCnfPassword.getText().toString())) {
            return false;
        }
        return true;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

        // Another interface callback
    }

}


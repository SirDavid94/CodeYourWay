package vcu.cmsc355.codeyourway;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.google.firebase.database.FirebaseDatabase;

import vcu.cmsc355.codeyourway.TutorialPages.ArraysTutorialActivity;


public class ChangePasswordActivity extends AppCompatActivity {

    EditText currentPassword, newPassword, confirmPassword;
    TextView instructionAlert;
    FirebaseUser firebaseUser;
    Button submit;
    FirebaseDatabase firebaseDatabase;
    String userCurrentPassword, userNewPassword, userConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        currentPassword = findViewById(R.id.current_pass);
        newPassword = findViewById((R.id.new_pass));
        confirmPassword = findViewById((R.id.confirm_pass));
        instructionAlert = findViewById(R.id.PasswordInstruction);
        submit = findViewById(R.id.btn_submit);


        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();

        userCurrentPassword = currentPassword.getText().toString();
         userNewPassword = newPassword.getText().toString();
        userConfirmPassword = confirmPassword.getText().toString();




        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ( PasswordLengthCheck() && PasswordMatchCheck())
                {
                    //Password Replace code goes here
                    firebaseUser.updatePassword(userConfirmPassword).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(ChangePasswordActivity.this, "Password Changed",Toast.LENGTH_SHORT).show();
                                finish();
                            }

                            else {

                                Toast.makeText(ChangePasswordActivity.this, "Update failed",Toast.LENGTH_SHORT).show();

                            }
                        }
                    });

                }
            }
        });
        }

    /**
     * Checks if the user input and the confirmation matches
     * @return boolean true if passwords are a match and boolean false is otherwise
     */
    private boolean PasswordMatchCheck() {

        if (userNewPassword != userConfirmPassword) {

            Toast.makeText(ChangePasswordActivity.this, "Passwords doesn't Match", Toast.LENGTH_SHORT).show();

        }
        return true;
    }

    /**
     * Checks the new password string to ensure it is longer than 6 characters
     * @return boolean true if password is longer than 6 characters and false if otherwise
     */
    private boolean PasswordLengthCheck() {

        if (userCurrentPassword.length() < 6) {
            instructionAlert.setTextColor(Color.RED);
            Toast.makeText(this, "Password must be longer than 6 characters", Toast.LENGTH_SHORT).show();
        }
        return true;
    }


    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menuLogout:
                Toast.makeText(this, "Logging user out", Toast.LENGTH_SHORT).show();
                finish();
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.menuSettings:
                startActivity(new Intent(this, SettingsActivity.class));
                break;

            case R.id.menuProfile:
                Toast.makeText(this, "Opening user profile", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ChangePasswordActivity.this, ProfileActivity.class));
                finish();
                break;

            case R.id.HallOfFame:
                Toast.makeText(this, "Opening LeaderBoardActivity", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, LeaderBoardActivity.class));
                finish();
                break;

            case R.id.home_menu:
                Toast.makeText(this, "Going Home", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, HomeActivity.class));
                finish();
                break;
        }
        return true;

    }
}
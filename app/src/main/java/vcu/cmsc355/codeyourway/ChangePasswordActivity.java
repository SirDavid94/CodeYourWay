package vcu.cmsc355.codeyourway;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
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
import vcu.cmsc355.codeyourway.TutorialPages.ArraysTutorialActivity;
import vcu.cmsc355.codeyourway.WalkThrough.WalkThroughActivity;


public class ChangePasswordActivity extends AppCompatActivity {

    public EditText currentPassword, newPassword, confirmPassword;
    TextView instructionAlert;
    final String pwd = "password";
    Button submit;
    FirebaseDatabase Database;
    DatabaseReference PasswordChangeReference;
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

        Database = FirebaseDatabase.getInstance();
        PasswordChangeReference = Database.getReference("Users");

        userCurrentPassword = currentPassword.getText().toString().trim();
         userNewPassword = newPassword.getText().toString().trim();
        userConfirmPassword = confirmPassword.getText().toString().trim();


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ( !(PasswordLengthCheck() || PasswordMatchCheck())) {

                    CompletePasswordChange(currentPassword.getText().toString().trim());

                }

            }
        });
        }

    private void CompletePasswordChange(String password) {

        PasswordChangeReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User AccountData = dataSnapshot.child(Common.getCurrentUser()).getValue(User.class);

                if (AccountData.getPassword().equals(userCurrentPassword)) {

                    //use set value function to update database
                    PasswordChangeReference.child(Common.getCurrentUser()).child(pwd).setValue(userConfirmPassword);

                    Toast.makeText(ChangePasswordActivity.this, "Password Changed", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(new Intent(ChangePasswordActivity.this, LoginActivity.class));

                } else {
                    Toast.makeText(ChangePasswordActivity.this, "Incorrect Password!!", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

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

        if (userNewPassword.length() < 6) {
            instructionAlert.setTextColor(Color.RED);
            Toast.makeText(this, "Password must be longer than 6 characters", Toast.LENGTH_SHORT).show();
        }
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
                Toast.makeText(this, "Opening LeaderBoard", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, LeaderBoardActivity.class));
                finish();
                break;

            case R.id.home_menu:
                startActivity(new Intent(this, HomeActivity.class));
                finish();
                break;
        }
        return true;

    }
}
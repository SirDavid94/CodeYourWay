package vcu.cmsc355.codeyourway;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.google.firebase.database.FirebaseDatabase;


public class ChangePasswordActivity extends AppCompatActivity {

    EditText currentPassword, newPassword, confirmPassword;
    FirebaseUser firebaseUser;
    Button submit;
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        currentPassword = findViewById(R.id.current_pass);
        newPassword = findViewById((R.id.new_pass));
        confirmPassword = findViewById((R.id.confirm_pass));

        submit = findViewById(R.id.btn_submit);


        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();

        String userCurrent_Password = currentPassword.getText().toString();
        String userNew_Password = newPassword.getText().toString();
        String userConfirm_Password = confirmPassword.getText().toString();
        firebaseUser.updatePassword(userCurrent_Password).addOnCompleteListener(new OnCompleteListener<Void>() {
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
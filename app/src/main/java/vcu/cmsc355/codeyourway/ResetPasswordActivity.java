package vcu.cmsc355.codeyourway;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import vcu.cmsc355.codeyourway.LoginActivity;
import vcu.cmsc355.codeyourway.R;

public class ResetPasswordActivity extends AppCompatActivity {

    Button resetPassword;
    EditText enterEmail;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);



        mAuth = FirebaseAuth.getInstance();

        resetPassword = (Button) findViewById(R.id.resetPasswordButton);
        enterEmail = (EditText) findViewById(R.id.resetPasswordEditText);



        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEmail = enterEmail.getText().toString();

                if (TextUtils.isEmpty(userEmail)){
                    Toast.makeText(ResetPasswordActivity.this, "Please enter a valid email", Toast.LENGTH_SHORT).show();
                }
                else{
                    mAuth.sendPasswordResetEmail(userEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(ResetPasswordActivity.this, "Please check your email for the reset link", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(ResetPasswordActivity.this, LoginActivity.class));
                            }
                            else{
                                String message = task.getException().getMessage();
                                Toast.makeText(ResetPasswordActivity.this, "There's an error: " + message, Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }

        });

    }

}

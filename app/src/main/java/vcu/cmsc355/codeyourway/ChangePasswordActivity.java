package vcu.cmsc355.codeyourway;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ChangePasswordActivity extends AppCompatActivity implements View.OnClickListener {

    EditText currentPassword, newPassword, confirmPassword;
    FirebaseAuth auth;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        currentPassword = (EditText)findViewById(R.id.current_pass);
        newPassword = (EditText)findViewById((R.id.new_pass));
        confirmPassword = (EditText)findViewById((R.id.confirm_pass));

        button1 = findViewById(R.id.btn_submit);

        button1.setOnClickListener(this);
    }


     button1.setOnClickListener(new View.OnClickListener() {


}


}
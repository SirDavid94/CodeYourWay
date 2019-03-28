package vcu.cmsc355.codeyourway;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.rengwuxian.materialedittext.MaterialEditText;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ChangePasswordActivity extends AppCompatActivity {

    EditText currentPassword, newPassword, confirmPassword;
    //FirebaseAuth auth;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        currentPassword = (EditText) findViewById(R.id.current_pass);
        newPassword = (EditText) findViewById((R.id.new_pass));
        confirmPassword = (EditText) findViewById((R.id.confirm_pass));

        button1 = findViewById(R.id.btn_submit);



 button1.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
            updatePassword();

     }
 });


}


        public void updatePassword() {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(ChangePasswordActivity.this);
            alertDialog.setTitle("Change Password");
            alertDialog.setMessage("Please fill all information");

            LayoutInflater inflater = LayoutInflater.from(this);
            View layout_pwd = inflater.inflate(R.layout.activity_change_password,null);

            MaterialEditText password = (MaterialEditText) layout_pwd.findViewById(current_pass)
            MaterialEditText password = (MaterialEditText) layout_pwd.findViewById(new)
    }


}
package vcu.cmsc355.codeyourway;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ChangePasswordActivity extends AppCompatActivity {

    EditText currentPassword, newPassword, confirmPassword;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        currentPassword = (EditText)findViewById(R.id.current_pass);
        newPassword = (EditText)findViewById((R.id.new_pass));
        confirmPassword = (EditText)findViewById((R.id.confirm_pass));
        auth = FirebaseAuth.getInstance();
    }

    public void change(View v) {

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user!=null)
        {
           user.updatePassword(confirmPassword.getText().toString())
                   .addOnCompleteListener(new OnCompleteListener<Void>() {
                       @Override
                       public void onComplete(@NonNull Task<Void> task) {
                           if(task.isSuccessful())
                           {
                               Toast.makeText(getApplicationContext())
                           }
                       }
                   })

        }


    }
}

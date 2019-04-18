package vcu.cmsc355.codeyourway;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import vcu.cmsc355.codeyourway.Model.Common;

public class EditProfileActivity extends AppCompatActivity {

    EditText firstName, lastName, email, expertise, username;
    private FirebaseDatabase mData;
    private DatabaseReference profileUserRef;
    Button saveProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        mData = FirebaseDatabase.getInstance();
        profileUserRef = mData.getReference().child("Users").child(Common.getCurrentUser());

        firstName = (EditText) findViewById(R.id.firstname_edit);
        lastName = (EditText) findViewById(R.id.lastname_edit);
        email = (EditText) findViewById(R.id.email_edit);
        expertise = (EditText) findViewById(R.id.expertise_edit);
        username = (EditText) findViewById(R.id.username_edit);
        saveProfile = (Button) findViewById(R.id.save_profile);


        profileUserRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()){
                    String myUserName = dataSnapshot.child("username").getValue().toString();
                    String myFirstName = dataSnapshot.child("firstName").getValue().toString();
                    String myLastName = dataSnapshot.child("lastName").getValue().toString();
                    String myEmail = dataSnapshot.child("email").getValue().toString();
                    String myExpertise = dataSnapshot.child("expertise").getValue().toString();

                    username.setText("@"+ myUserName);
                    firstName.setText(myFirstName);
                    lastName.setText(myLastName);
                    email.setText(myEmail);
                    expertise.setText(myExpertise);

                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //initiates when save button is clicked
        saveProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profileUserRef.child("firstName").setValue(firstName);
                profileUserRef.child("lastName").setValue(lastName);
                profileUserRef.child("email").setValue(email);
                profileUserRef.child("expertise").setValue(expertise);
                profileUserRef.child("username").setValue(username);
            }
        });

    }
}

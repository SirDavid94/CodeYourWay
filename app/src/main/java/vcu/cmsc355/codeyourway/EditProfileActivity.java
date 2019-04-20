package vcu.cmsc355.codeyourway;

import android.content.Intent;
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
    private DatabaseReference userRef;
    Button btSaveProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);



        mData = FirebaseDatabase.getInstance();
        userRef = mData.getReference().child("Users").child(Common.getCurrentUser());

        firstName = (EditText) findViewById(R.id.firstname_edit);
        lastName = (EditText) findViewById(R.id.lastname_edit);
        email = (EditText) findViewById(R.id.email_edit);
        expertise = (EditText) findViewById(R.id.expertise_edit);
        username = (EditText) findViewById(R.id.username_edit);
        btSaveProfile = (Button) findViewById(R.id.save_profile);


        userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()){
                    String myUserName = dataSnapshot.child("username").getValue().toString();
                    String myFirstName = dataSnapshot.child("firstName").getValue().toString();
                    String myLastName = dataSnapshot.child("lastName").getValue().toString();
                    String myEmail = dataSnapshot.child("email").getValue().toString();
                    String myExpertise = dataSnapshot.child("expertise").getValue().toString();

                    username.setText(myUserName);
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
        btSaveProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userRef.child("firstName").setValue(firstName);
                userRef.child("lastName").setValue(lastName);
                userRef.child("email").setValue(email);
                userRef.child("expertise").setValue(expertise);
                userRef.child("username").setValue(username);
                startActivity(new Intent(EditProfileActivity.this, ProfileActivity.class));
            }
        });
    }

}

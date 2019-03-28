package vcu.cmsc355.codeyourway;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import vcu.cmsc355.codeyourway.Model.Common;


public class ProfileActivity extends AppCompatActivity {

    Button changePassword,downloadGameData;
    TextView name, lastName, EmailProfile, userName, levelsCompleted, moduleCompletionLevel, expertise;
    private String currentUserId;
    private FirebaseAuth mAuth;
    private DatabaseReference profileUserRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        mAuth = FirebaseAuth.getInstance();
       // currentUserId = mAuth.getCurrentUser().getUid();
        profileUserRef = FirebaseDatabase.getInstance().getReference().child("Users").child(Common.getCurrentUser());



        name = (TextView) findViewById(R.id.profile_firstname);
        lastName = (TextView) findViewById(R.id.profile_lastname);
        EmailProfile = (TextView) findViewById(R.id.email_address_profile);
        userName = (TextView) findViewById(R.id.username);
        expertise = (TextView) findViewById(R.id.expertise_profile);
        //levelsCompleted = (TextView) findViewById(R.id.levelCompleted);


        profileUserRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    String myUserName = dataSnapshot.child("userName").getValue().toString();
                    String myFirstName = dataSnapshot.child("firstName").getValue().toString();
                    String myLastName = dataSnapshot.child("lastName").getValue().toString();
                    String myEmail = dataSnapshot.child("email").getValue().toString();
                    String myExpertise = dataSnapshot.child("expertise").getValue().toString();


                    userName.setText("@"+ myUserName);
                    name.setText(myFirstName);
                    lastName.setText(myLastName);
                    EmailProfile.setText(myEmail);
                    expertise.setText(myExpertise);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }



}

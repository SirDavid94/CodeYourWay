package vcu.cmsc355.codeyourway;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import vcu.cmsc355.codeyourway.GameLevel.LevelSelectionActivity;
import vcu.cmsc355.codeyourway.Model.Common;
import vcu.cmsc355.codeyourway.TutorialPages.ArraysTutorialActivity;


public class ProfileActivity extends AppCompatActivity {

    ImageButton backBtn;


    TextView name, lastName, EmailProfile, userName, levelsCompleted, moduleCompletionLevel, expertise;
    private FirebaseDatabase mData;
    private DatabaseReference profileUserRef, moduleUserRef, levelUserRef;
    Button btChangePassword,btDownloadGameData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mData = FirebaseDatabase.getInstance();
        profileUserRef = mData.getReference().child("Users").child(Common.getCurrentUser());
        levelUserRef = mData.getReference().child("Awards").child(Common.getCurrentUser());
        //moduleUserRef = mData.getReference().child("Users").child(Common.getCurrentUser());


        backButton();
        name = (TextView) findViewById(R.id.profile_firstname);
        lastName = (TextView) findViewById(R.id.profile_lastname);
        EmailProfile = (TextView) findViewById(R.id.email_address_profile);
        userName = (TextView) findViewById(R.id.username);
        expertise = (TextView) findViewById(R.id.expertise_profile);
        btChangePassword = (Button) findViewById(R.id.changePasswrdProfile);
        btDownloadGameData = (Button) findViewById(R.id.downloadGameDataProfile);

        //working on this function
        levelsCompleted = (TextView) findViewById(R.id.levelCompleted);
        //moduleCompletionLevel = (TextView) findViewById(R.id.moduleCompletionLevel);



        profileUserRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

               if (dataSnapshot.exists()){
                    String myUserName = dataSnapshot.child("username").getValue().toString();
                    String myFirstName = dataSnapshot.child("firstName").getValue().toString();
                    String myLastName = dataSnapshot.child("lastName").getValue().toString();
                    String myEmail = dataSnapshot.child("email").getValue().toString();
                    String myExpertise = dataSnapshot.child("expertise").getValue().toString();
                    //String myLevelsCompleted = dataSnapshot.child("awardCount").getValue().toString();

                    userName.setText("@"+ myUserName);
                    name.setText(myFirstName);
                    lastName.setText(myLastName);
                    EmailProfile.setText(myEmail);
                    expertise.setText(myExpertise);
                    //levelsCompleted.setText(myLevelsCompleted);

               }
            }



            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //This button takes you to the change password page
        btChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, ChangePasswordActivity.class));
            }
        });

        //Initiates the downloading of user game data
        btDownloadGameData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ProfileActivity.this, "Button under construction", Toast.LENGTH_SHORT).show();
            }
        });

    }

    //Function for the pressing of the back button
    public void backButton(){
        backBtn = (ImageButton) findViewById(R.id.backbtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }


}

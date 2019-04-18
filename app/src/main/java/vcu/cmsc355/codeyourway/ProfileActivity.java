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

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import vcu.cmsc355.codeyourway.GameLevel.LevelSelectionActivity;
import vcu.cmsc355.codeyourway.Model.Awards;
import vcu.cmsc355.codeyourway.Model.Common;
import vcu.cmsc355.codeyourway.TutorialPages.ArraysTutorialActivity;


public class ProfileActivity extends AppCompatActivity {

    ImageButton backBtn;
    TextView name, lastName, EmailProfile, userName, levelsCompleted, expertise;
    private FirebaseDatabase mData;
    String myLevelsCompleted;
    private DatabaseReference profileUserRef,levelUserRef;
    Button btChangePassword,btDownloadGameData, edit_profile;

    private String GameData = ""; //the user information is stored temporarily

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mData = FirebaseDatabase.getInstance();
        profileUserRef = mData.getReference().child("Users").child(Common.getCurrentUser());
        levelUserRef = mData.getReference().child("Awards").child(Common.getCurrentUser());

        backButton();

        //View all badges clickable textView
        TextView viewAllBadges  = findViewById(R.id.ViewAllBadges);



        name = (TextView) findViewById(R.id.profile_firstname);
        lastName = (TextView) findViewById(R.id.profile_lastname);
        EmailProfile = (TextView) findViewById(R.id.email_address_profile);
        userName = (TextView) findViewById(R.id.username);
        expertise = (TextView) findViewById(R.id.expertise_profile);
        btChangePassword = (Button) findViewById(R.id.changePasswrdProfile);
        btDownloadGameData = (Button) findViewById(R.id.downloadGameDataProfile);

        //working on this function
        levelsCompleted = (TextView) findViewById(R.id.levelCompleted);

        // Opens the Badges page when clicked
        viewAllBadges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent badgeDisplay = new Intent(ProfileActivity.this, BadgeActivity.class);
                badgeDisplay.putExtra("total", String.valueOf(myLevelsCompleted));
                badgeDisplay.putExtra("picture","R.id.drawable/profile_pic" );
                startActivity(badgeDisplay);
            }
        });

        //Starts the edit profile activity
       edit_profile.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent editProfile = new Intent(ProfileActivity.this, EditProfileActivity.class);
               startActivity(editProfile);
           }
       });

        profileUserRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

               if (dataSnapshot.exists()){
                    String myUserName = dataSnapshot.child("username").getValue().toString();
                    String myFirstName = dataSnapshot.child("firstName").getValue().toString();
                    String myLastName = dataSnapshot.child("lastName").getValue().toString();
                    String myEmail = dataSnapshot.child("email").getValue().toString();
                    String myExpertise = dataSnapshot.child("expertise").getValue().toString();

                    GameData = myUserName+ ", "+myFirstName+", "+myLastName+", "+myEmail+", "+myExpertise;

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



        levelUserRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    myLevelsCompleted = dataSnapshot.child("awardCount").getValue().toString();

                    levelsCompleted.setText(myLevelsCompleted);
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
                saveDataOnDevice(GameData);
            }
        });
    }


    public void saveDataOnDevice(String sBody) {
        FileOutputStream fos = null;
        String FILE_NAME = "SavedData.txt";
        try {
          fos =openFileOutput(FILE_NAME, MODE_PRIVATE);
          fos.write(sBody.getBytes());
          Toast.makeText(this, "String saved to "+getFilesDir()+ "/"+FILE_NAME, Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fos !=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
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


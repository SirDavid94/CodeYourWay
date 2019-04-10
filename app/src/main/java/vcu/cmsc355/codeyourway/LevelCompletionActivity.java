package vcu.cmsc355.codeyourway;

/**
 * Class LevelCompletionActivity displays after User has successfully completed a game level
 * It display the game stats and informs the user if they passed a level or not
 * Game data is uploaded if user earns a badge with a score greater than 80%
 */

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;

import vcu.cmsc355.codeyourway.Model.Awards;
import vcu.cmsc355.codeyourway.Model.Common;
import vcu.cmsc355.codeyourway.TutorialPages.ArraysTutorialActivity;


public class LevelCompletionActivity extends AppCompatActivity {
    Button tryAgain;
    int completedLevel,completedModule;
    Button nextLevel;
    String awardLabel = "badge";
    String awardCount = "awardCount"; //point to award to user every time they complete a level
    TextView completionMessage, congratulationMessage,
             passingScore,totalScore,failedMessage;

    //FireBase instance
    FirebaseDatabase database;
    DatabaseReference Award;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levelcompletion_page);

        //LeaderBoardActivity Instantiation
        database = FirebaseDatabase.getInstance();
        Award = database.getReference("Awards");
        completionMessage = findViewById(R.id.completionMessage);
        congratulationMessage = findViewById(R.id.congratulationMessage);
        passingScore = findViewById(R.id.passingScoreMessage);
        totalScore = findViewById(R.id.scoreMessage);
        failedMessage = findViewById(R.id.failedMessage);
        tryAgain = (Button) findViewById(R.id.tryAgainButton);
        nextLevel = (Button) findViewById(R.id.nextLevelButton);

        // Gets a copy of the user's name for database purposes
        final String currentUser = Common.getCurrentUser();

        //Gets all data sent from previous page
         Bundle bundle = getIntent().getExtras();
        if (bundle != null)
        {
            String totalString     = bundle.getString("total");
            String scoreString     = bundle.getString("correct");
            String incorrectString = bundle.getString("Incorrect");
            String moduleString    = bundle.getString("ModuleID");
            String levelString     = bundle.getString("LevelID");
            awardLabel             +=moduleString+levelString;




            double total = (double)Integer.parseInt(totalString);
            double scoreInt = (double)Integer.parseInt(scoreString);
            int incorrect = Integer.parseInt(incorrectString);
            completedModule      = Integer.parseInt(moduleString);
            completedLevel        = Integer.parseInt(levelString);


            //Sets the passing score to green
            passingScore.setTextColor(Color.GREEN);


            // Calculates Percentage for passing score
            int score = (int)((scoreInt/5)*100);

            // If score is 80% or greater then the user has passed the level
            if(score >= 80)
            {
                totalScore.setTextColor(Color.GREEN);
                failedMessage.setVisibility(View.INVISIBLE);

                //Uses user's Username as a key to upload badge data to Database

                Award.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if ( dataSnapshot.child(currentUser).child(awardLabel).exists())
                        {
                            Awards Label  = dataSnapshot.child(currentUser).getValue(Awards.class);
                           Awards Count  = dataSnapshot.child(currentUser).getValue(Awards.class);

                           final int labelCount = Label.getCount()+1;
                           // getcount gets 0 every time due to count function in awards
                            // I need to update to actually get Badge ID value
                           final int awardCounter = Count.getAwardCount()+1;

                            Award.child(currentUser).child(awardLabel).setValue(labelCount);
                            Award.child(currentUser).child(awardCount).setValue(awardCounter);

                        }

                        else
                        {
                            Award.child(currentUser).child(awardLabel).setValue(1);
                            Awards Count  = dataSnapshot.child(currentUser).getValue(Awards.class);
                            final int awardCounter = Count.getAwardCount()+1;
                            Award.child(currentUser).child(awardCount).setValue(awardCounter);
                            //Update AwardCount
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


            }
            else
            {
                // If score is less than 80% then the user failed the level
                totalScore.setTextColor(Color.RED);
                congratulationMessage.setText("Sorry you did not pass. Try Again!!");
                congratulationMessage.setTextColor(Color.RED);
            }
            // Sets the user's score to the display page
            totalScore.setText(" YOUR SCORE :    "+ score + "%");
        }

        //Starts the same game Level over again
        tryAgain.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent tryAgainIntent = new Intent(LevelCompletionActivity.this, GamePlay.class);
                tryAgainIntent.putExtra("moduleID", completedModule);
                tryAgainIntent.putExtra("level", completedLevel);
                startActivity(tryAgainIntent);
            }
        });



        //Starts the next Game Level when the button is clicked
        nextLevel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Checks to see if a user has finished a module and takes them to the next module
                if ( completedLevel == 6 && completedModule < 5)
                {
                    completedModule++;
                    completedLevel = 1;
                }
                // condition checks if user hasn't finished all the levels in a module
                else if ( completedLevel <6 ) {
                    completedLevel++;
                }

                Intent nextLevel = new Intent(LevelCompletionActivity.this,GamePlay.class);
                nextLevel.putExtra("moduleID",completedModule );
                nextLevel.putExtra("level",completedLevel );
                startActivity(nextLevel);
            }
        });
    }
    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menuLogout:
                Toast.makeText(this, "Logging user out", Toast.LENGTH_SHORT).show();
                finish();
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.menuSettings:
                startActivity(new Intent(this, SettingsActivity.class));
                break;

            case R.id.menuProfile:
                Toast.makeText(this, "Opening user profile", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LevelCompletionActivity.this, ProfileActivity.class));
                finish();
                break;

            case R.id.HallOfFame:
                Toast.makeText(this, "Opening LeaderBoardActivity", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, LeaderBoardActivity.class));
                finish();
                break;

            case R.id.home_menu:
                Toast.makeText(this, "Going Home", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, HomeActivity.class));
                finish();
                break;
        }
        return true;

    }
}

package vcu.cmsc355.codeyourway;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import vcu.cmsc355.codeyourway.Model.Awards;
import vcu.cmsc355.codeyourway.Model.Common;
import vcu.cmsc355.codeyourway.Model.LeaderBoard;

public class LeaderBoardActivity extends AppCompatActivity {

    String username;
    int score =0;
    int i =9;
    FirebaseDatabase database;
    DatabaseReference AwardsDatabase;
    TextView rank1,rank2,rank3,rank4,rank5,rank6,rank7,rank8,rank9,rank10;
    TextView score1,score2,score3,score4,score5,score6,score7,score8,score9,score10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
        database = FirebaseDatabase.getInstance();
        AwardsDatabase = database.getReference("Awards");
        Button homeButton = findViewById(R.id.HallOfFameHomeButton);



       UpdateScore();


        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LeaderBoardActivity.this, HomeActivity.class));
            }
        });
    }




   private void UpdateScore() {
        AwardsDatabase.orderByChild("awardCount").limitToFirst(10)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                         for ( DataSnapshot data: dataSnapshot.getChildren())
                         {
                             Awards rank = data.getValue(Awards.class);
                             username = data.getKey();
                             score = (int)(rank.getAwardCount());

                             ShowLeaderBoard(i);
                             i--;

                         }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(LeaderBoardActivity.this, "Database Connection error!! ", Toast.LENGTH_SHORT).show();
                    }
                });

    }

    private void ShowLeaderBoard(int num) {

        TextView [] rankList ={
                rank1 = findViewById(R.id.rank1),
                rank2 = findViewById(R.id.rank2),
                rank3 = findViewById(R.id.rank3),
                rank4 = findViewById(R.id.rank4),
                rank5 = findViewById(R.id.rank5),
                rank6 = findViewById(R.id.rank6),
                rank7 = findViewById(R.id.rank7),
                rank8 = findViewById(R.id.rank8),
                rank9 = findViewById(R.id.rank9),
                rank10 = findViewById(R.id.rank10)
        };

        TextView [] scoreList ={
                score1 = findViewById(R.id.score1),
                score2 = findViewById(R.id.score2),
                score3 = findViewById(R.id.score3),
                score4 = findViewById(R.id.score4),
                score5 = findViewById(R.id.score5),
                score6 = findViewById(R.id.score6),
                score7 = findViewById(R.id.score7),
                score8 = findViewById(R.id.score8),
                score9 = findViewById(R.id.score9),
                score10 = findViewById(R.id.score10)
        };

        rankList[num].setText(username);
        scoreList[num].setText(" "+score+" ");


    }
}

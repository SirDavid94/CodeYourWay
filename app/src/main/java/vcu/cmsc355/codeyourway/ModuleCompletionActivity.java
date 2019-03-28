package vcu.cmsc355.codeyourway;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class ModuleCompletionActivity extends AppCompatActivity {

    Button BtHome;
    Button BtNextModule;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_completion);


        BtHome = (Button) findViewById(R.id.goHomeButton);
        BtNextModule = (Button) findViewById(R.id.nextModuleButton);



        BtHome.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent moduleHomeIntent = new Intent(ModuleCompletionActivity.this, HomeActivity.class);
                startActivity(moduleHomeIntent);
            }
        });

        BtNextModule.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(ModuleCompletionActivity.this, "Button Under Development", Toast.LENGTH_SHORT).show();
            }
        });
    }
}


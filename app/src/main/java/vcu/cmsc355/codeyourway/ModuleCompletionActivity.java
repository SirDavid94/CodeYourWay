package vcu.cmsc355.codeyourway;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


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
                Intent moduleCompletionIntent = new Intent(ModuleCompletionActivity.this, HomeActivity.class);
                startActivity(moduleCompletionIntent);
            }
        });
    }
}


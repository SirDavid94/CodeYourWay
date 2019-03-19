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
        setContentView(R.layout.activity_arrays);



        BtHome = (Button) findViewById(R.id.goHomeButton);
        BtNextModule = (Button) findViewById(R.id.nextModuleButton);

    }

    // will finish this class today// David.//
}


package com.jeongbaeoh.constlayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class ParcelableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcelable);

        Button button = (Button)findViewById(R.id.parcelableBackButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Intent passedIntent = getIntent();
        processIntent(passedIntent);
    }

    private void processIntent(Intent intent) {
        if(intent != null) {
            ArrayList<String> names = (ArrayList<String>)intent.getSerializableExtra("names");
            if(names != null) {
                Toast.makeText(getApplicationContext(), "Number of Passed Intent: "+names.size(), Toast.LENGTH_LONG).show();
            }

            SimpleData data = (SimpleData)intent.getParcelableExtra("data");
            if(data != null) {
                Toast.makeText(getApplicationContext(), "Passed SimpleData: "+data.message+", "+data.number, Toast.LENGTH_LONG).show();
            }
        }
    }
}

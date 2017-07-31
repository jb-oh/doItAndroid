package com.jeongbaeoh.constlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OrientationActivity extends AppCompatActivity {
    EditText editText;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orientation);
        
        editText = (EditText) findViewById(R.id.EditText);

        Button button = (Button) findViewById(R.id.portraitButton);
        if(button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    name = editText.getText().toString();
                    Toast.makeText(getApplicationContext(), "Input assigned to variable \"name\"", Toast.LENGTH_SHORT).show();
                }
            });
        }

        if(savedInstanceState != null) {
            String name = savedInstanceState.getString("name");
            if(editText != null) {
                editText.setText("Recovered: "+name);
                Toast.makeText(getApplicationContext(), "Name recovered: "+name, Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("name", name);
    }
}

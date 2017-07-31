package com.jeongbaeoh.constlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class FragActivity extends AppCompatActivity {

    MainFragment fragment1;
    MenuFragment fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag);

        fragment1 = new MainFragment();
        fragment2 = new MenuFragment();

        Button button = (Button) findViewById(R.id.frag0MainButton);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragContainer, fragment1).commit();
            }

        });

        Button button2 = (Button) findViewById(R.id.frag0MenuButton);
        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragContainer, fragment2).commit();
            }

        });
    }

    public void onFragmentChange(int i) {
        if(i == 0) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragContainer, fragment1).commit();
        } else if(i == 1) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragContainer, fragment2).commit();
        }
    }
}

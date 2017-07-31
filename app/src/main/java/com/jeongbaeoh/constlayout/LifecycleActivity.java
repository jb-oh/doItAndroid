package com.jeongbaeoh.constlayout;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LifecycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);

        Toast.makeText(this, "onCreate() called", Toast.LENGTH_SHORT).show(); // onCreate method가 시작되었을 때 호출됨

        Button button = (Button) findViewById(R.id.closeButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        Toast.makeText(this, "onStart() called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();

        Toast.makeText(this, "onStop() called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Toast.makeText(this, "onDestroy() called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() { // 보통 onPause 상태에서 데이터를 저장함
        super.onPause();

        Toast.makeText(this, "onPause() called", Toast.LENGTH_SHORT).show();

        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE); // 기본적으론 MODE_PRIVATE을 씀
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("name", "John");
        editor.commit(); // 여기에서는 commit이 필수적임
    }

    @Override
    protected void onResume() { // onPause에서 저장한 데이터는 onResume에서 복구함
        super.onResume();

        Toast.makeText(this, "onResume() called", Toast.LENGTH_SHORT).show();

        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        if(pref != null) {
            String name = pref.getString("name", "");
            Toast.makeText(this, "Recovered name: "+name, Toast.LENGTH_SHORT).show();
        }
    }
}

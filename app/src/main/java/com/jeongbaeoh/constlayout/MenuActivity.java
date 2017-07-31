package com.jeongbaeoh.constlayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button button = (Button)findViewById(R.id.goBack);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("name", "Mike"); // intent 안의 데이터 중에서 시스템에서 해석하지 않는 데이터. 다른 activity로 전달하는 데이터를 포함. key, value 형식

                setResult(Activity.RESULT_OK, intent); // 이 경우는 정상 응답을 의미

                finish(); // activity stack에서 LIFO 방식이라 생각하면 됨
            }
        });
    }
}

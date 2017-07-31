package com.jeongbaeoh.constlayout;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class IntentActivity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        editText = (EditText)findViewById(R.id.inputPhoneNo);

        Button button = (Button)findViewById(R.id.callButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String receiver = editText.getText().toString();
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+receiver));
                startActivity(intent);
            }
        });

        Button button2 = (Button)findViewById(R.id.backButton);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                다른 방식으로 인텐트 구현하기 -> ComponentName 방식
                문자열로 component, 즉 activity를 지정할 수 있음. 즉, 아직 만들어지지 않은 상태에서도 지정 가능
                */
                Intent intent2 = new Intent();
                ComponentName name = new ComponentName("com.jeongbaeoh.constlayout", "com.jeongbaeoh.constlayout.SwitchImageActivity");
                intent2.setComponent(name);
                startActivity(intent2);
            }
        });
    }
}

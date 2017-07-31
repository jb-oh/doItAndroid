package com.jeongbaeoh.constlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class SwitchImageActivity extends AppCompatActivity {
    ImageView imageView; // 여기서 선언을 해줘야 onCreate와 onButton1Clicked 둘 다에서 사용 가능
    ImageView imageView2;

    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_image);

        imageView = (ImageView) findViewById(R.id.imageView); // (ImageView)와 같이 형 변환을 해줘야 함
        imageView2 = (ImageView) findViewById(R.id.imageView2);
    }

    public void onButton1Clicked(View v) {
        index += 1;
        if (index > 1) {
            index = 0;
        }

        if (index == 0) {
            imageView.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.INVISIBLE);
        } else if (index == 1) {
            imageView.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.VISIBLE);
        }

    }
}

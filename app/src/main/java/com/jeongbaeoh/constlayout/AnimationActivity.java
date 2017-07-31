package com.jeongbaeoh.constlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class AnimationActivity extends AppCompatActivity {
    TextView textView;
    Animation flowAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        textView = (TextView) findViewById(R.id.aniTextView);
        flowAnim = AnimationUtils.loadAnimation(this, R.anim.flow);

        Button button = (Button) findViewById(R.id.aniButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.startAnimation(flowAnim);
            }
        });
    }
}

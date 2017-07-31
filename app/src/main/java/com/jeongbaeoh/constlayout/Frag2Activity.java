package com.jeongbaeoh.constlayout;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class Frag2Activity extends AppCompatActivity {

    ListFragment fragment1;
    ViewerFragment fragment2;

    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag2);

        manager = getSupportFragmentManager();

        fragment1 = (ListFragment) manager.findFragmentById(R.id.listFragment);
        fragment2 = (ViewerFragment) manager.findFragmentById(R.id.viewerFragment);
    }

    public void onImageChange(int i) {
        fragment2.setImage(i);
    }
}

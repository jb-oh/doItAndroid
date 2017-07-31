package com.jeongbaeoh.constlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by jboh on 31/07/2017.
 */

public class ViewerFragment extends Fragment {

    ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_viewer, container, false);

        imageView = (ImageView) rootView.findViewById(R.id.imageViewFrag1);

        return rootView;
    }

    public void setImage(int i) {
        if(i == 0) {
            imageView.setImageResource(R.drawable.yonsei_china);
        } else if(i == 1) {
            imageView.setImageResource(R.drawable.yonsei_china_2);
        } else if(i == 2) {
            imageView.setImageResource(R.drawable.blue);
        }
    }
}

package com.jeongbaeoh.constlayout;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by jboh on 31/07/2017.
 */

public class ListFragment extends Fragment {

    Frag2Activity activity;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (Frag2Activity) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_list, container, false);

        Button button = (Button) rootView.findViewById(R.id.buttonImage1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.onImageChange(0);
            }
        });

        Button button2 = (Button) rootView.findViewById(R.id.buttonImage2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.onImageChange(1);
            }
        });

        Button button3 = (Button) rootView.findViewById(R.id.buttonImage3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.onImageChange(2);
            }
        });

        return rootView;
    }
}

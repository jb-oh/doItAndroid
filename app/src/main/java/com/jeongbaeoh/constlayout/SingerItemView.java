package com.jeongbaeoh.constlayout;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by jboh on 07/08/2017.
 */

public class SingerItemView extends LinearLayout {

    TextView textViewName, textViewPhone;
    ImageView imageView;

    public SingerItemView(Context context) {
        super(context);
        init(context);
    }

    public SingerItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.singer_item, this, true);
        textViewName = (TextView) findViewById(R.id.textViewName);
        textViewPhone = (TextView) findViewById(R.id.textViewPhone);
        imageView = findViewById(R.id.listViewImageView);
    }

    public void setName(String name) {
        textViewName.setText(name);
    }

    public void setMobile(String mobile) {
        textViewPhone.setText(mobile);
    }

    public void setImage(int resId) {
        imageView.setImageResource(resId);
    }
}

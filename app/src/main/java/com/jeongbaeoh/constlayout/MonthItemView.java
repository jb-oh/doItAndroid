package com.jeongbaeoh.constlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by jboh on 13/08/2017.
 */

public class MonthItemView extends RelativeLayout {

    TextView textView;

    public MonthItemView(Context context) {
        super(context);
        init(context);
    }

    public MonthItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.month_item, this, true);

        textView = findViewById(R.id.textViewDate);
    }

    public void setDay(String day) {
        textView.setText(day);
    }
}

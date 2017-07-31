package com.jeongbaeoh.constlayout;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ToastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        Button button = (Button) findViewById(R.id.buttonToast);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getApplicationContext(), "Re-positioned toast", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP|Gravity.LEFT, 200, 200);
                toast.show();
            }
        });

        Button button2 = (Button) findViewById(R.id.buttonToast2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.toastborder, (ViewGroup) findViewById(R.id.toast_layout_root));

                TextView text = (TextView) layout.findViewById(R.id.text);
                text.setText("Toast with changed shape");
                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.CENTER, 0, -200);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setView(layout);
                toast.show();
            }
        });

        Button button3 = (Button) findViewById(R.id.buttonToast3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "This is a Snackbar.", Snackbar.LENGTH_SHORT).show();
            }
        });
    }
}

package com.jeongbaeoh.constlayout;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText serviceEditText;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 101:
                if (grantResults.length > 0) {
                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(this, "SMS receive permission has been granted by user.", Toast.LENGTH_SHORT).show();
                    } else if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
                        Toast.makeText(this, "SMS receive permission has been denied by user.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "SMS receive permission has not been granted by user.", Toast.LENGTH_SHORT).show();
                }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.buttonMenu);
        button.setOnClickListener(new View.OnClickListener() { // 이것이 xml에서 onClick 지정하고 동일한 이름의 method를 만드는 것과 동일
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class); // MenuActivity의 instance object
                startActivityForResult(intent, 101); // 끝나고 돌아올 때 응답을 받아야 할 경우. 뒤 인자가 상황별 코드를 의미함
            }
        });

        Button button2 = (Button) findViewById(R.id.parcelableButton);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ParcelableActivity.class);

                ArrayList<String> names = new ArrayList<String>();
                names.add("JB");
                names.add("Hongsub");

                intent.putExtra("names", names);

                SimpleData data = new SimpleData(100, "Hello");
                intent.putExtra("data", data);

                startActivityForResult(intent, 101);
            }
        });

        serviceEditText = (EditText) findViewById(R.id.serviceEditText);
        Button serviceButton = (Button) findViewById(R.id.serviceButton);
        serviceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = serviceEditText.getText().toString();

                Intent serviceIntent = new Intent(getApplicationContext(), MyService.class);
                serviceIntent.putExtra("command", "show");
                serviceIntent.putExtra("name", name);
                startService(serviceIntent);
            }
        });

        //Intent passedIntent = getIntent();
        //processCommand(passedIntent);

        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS);
        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            //Toast.makeText(this, "SMS receive permission granted.", Toast.LENGTH_SHORT).show();
        } else {
            //Toast.makeText(this, "SMS receive permission not granted.", Toast.LENGTH_SHORT).show();

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.RECEIVE_SMS)) {
                //Toast.makeText(this, "SMS Permission Explain needed.", Toast.LENGTH_SHORT).show();
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECEIVE_SMS}, 101);
            }
        }

    }


    // 아래가 응답을 받아주는 메소드임.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 101) {
            String name = data.getStringExtra("name");
            Toast.makeText(getApplicationContext(), "Response from menu: " + name, Toast.LENGTH_LONG).show();
        }
    }

    public void onClickInflater(View v) {
        Intent intentInflater = new Intent(this, LayoutInflaterActivity.class);
        startActivity(intentInflater);
    }

    public void onClickSwitchImage(View v) {
        Intent intentSwitchImage = new Intent(this, SwitchImageActivity.class);
        startActivity(intentSwitchImage);
    }

    public void onClickIntent(View v) {
        Intent intentIntent = new Intent(this, IntentActivity.class);
        startActivity(intentIntent);
    }

    public void onClickLifecycle(View v) {
        Intent intentLifecycle = new Intent(this, LifecycleActivity.class);
        startActivity(intentLifecycle);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        processCommand(intent);
        super.onNewIntent(intent);
    }

    private void processCommand(Intent intent) {
        if (intent != null) {
            String command = intent.getStringExtra("command");
            String name = intent.getStringExtra("name");
            //Toast.makeText(this, intent.toString(), Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Received from service: " + command + ", " + name, Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickEvent(View v) {
        Intent intentTouch = new Intent(this, TouchEventActivity.class);
        startActivity(intentTouch);
    }

    public void onClickOrientation(View v) {
        Intent intentOrientation = new Intent(this, OrientationActivity.class);
        startActivity(intentOrientation);
    }

    public void onClickOrientation2(View v) {
        Intent intentOrientation2 = new Intent(this, Orientation2Activity.class);
        startActivity(intentOrientation2);
    }

    public void onClickToast(View v) {
        Intent intentToast = new Intent(this, ToastActivity.class);
        startActivity(intentToast);
    }

    public void onClickDialog(View v) {
        Intent intentDialog = new Intent(this, DialogActivity.class);
        startActivity(intentDialog);
    }

    public void onClickProgress(View v) {
        Intent intentProgress = new Intent(this, ProgressActivity.class);
        startActivity(intentProgress);
    }

    public void onClickAnimation(View v) {
        Intent intentAnim = new Intent(this, AnimationActivity.class);
        startActivity(intentAnim);
    }

    public void onClickSliding(View v) {
        Intent intentSlide = new Intent(this, SlidingActivity.class);
        startActivity(intentSlide);
    }

    public void onClickFragment(View v) {
        Intent intentFrag = new Intent(this, FragActivity.class);
        startActivity(intentFrag);
    }

    public void onClickFragment2(View v) {
        Intent intentFrag2 = new Intent(this, Frag2Activity.class);
        startActivity(intentFrag2);
    }

    public void onClickOption(View v) {
        Intent intentOption = new Intent(this, OptionActivity.class);
        startActivity(intentOption);
    }

    public void onClickAction(View v) {
        Intent intentAction = new Intent(this, ActionActivity.class);
        startActivity(intentAction);
    }

    public void onClickWebview(View v) {
        Intent intentWebview = new Intent(this, WebviewActivity.class);
        startActivity(intentWebview);
    }

    public void onClickNinePatch(View v) {
        Intent intentNine = new Intent(this, NinepatchActivity.class);
        startActivity(intentNine);
    }

    public void onClickBitmap(View v) {
        Intent intentBitmap = new Intent(this, BitmapActivity.class);
        startActivity(intentBitmap);
    }

    public void onClickListview(View v) {
        Intent intentList = new Intent(this, ListviewActivity.class);
        startActivity(intentList);
    }

    public void onClickSpinner(View v) {
        Intent intentSpinner = new Intent(this, SpinnerActivity.class);
        startActivity(intentSpinner);
    }

    public void onClickGrid(View v) {
        Intent intentGrid = new Intent(this, GridviewActivity.class);
        startActivity(intentGrid);
    }

    public void onClickPicker(View v) {
        Intent intentPicker = new Intent(this, PickerActivity.class);
        startActivity(intentPicker);
    }

}

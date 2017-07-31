package com.jeongbaeoh.constlayout;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SmsReceiver extends BroadcastReceiver {
    private static final String TAG = "SmsReceiver";

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive() called.");

        Bundle bundle = intent.getExtras();
        SmsMessage[] messages = parseSmsMessage(bundle);
        if(messages[0] == null) {
            Log.e(TAG, "Message is null");
        } else if(messages.length > 0) {
            String sender = messages[0].getOriginatingAddress();
            Log.d(TAG, "Sender: "+sender);

            String contents  = messages[0].getMessageBody();
            Log.d(TAG, "Contents: "+contents);

            Date receivedDate = new Date(messages[0].getTimestampMillis());
            Log.d(TAG, "Date received: "+receivedDate);

            sendToActivity(context, sender, contents, receivedDate);
        }
    }

    private void sendToActivity(Context context, String sender, String contents, Date receivedDate) {
        Intent intent = new Intent(context, SmsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|
                        Intent.FLAG_ACTIVITY_SINGLE_TOP|
                        Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("sender", sender);
        intent.putExtra("contents", contents);
        intent.putExtra("receivedDate", format.format(receivedDate));
        context.startActivity(intent);
    }

    private SmsMessage[] parseSmsMessage(Bundle bundle) {
        Object[] objs = (Object[]) bundle.get("pdus"); // pdus는 SMS를 처리하는 표준 프로토콜 내의 데이터
        SmsMessage[] messages = new SmsMessage[objs.length];

        for(int i=0; i<objs.length; i++) {
            /*if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                String format = bundle.getString("format");
                SmsMessage.createFromPdu((byte[]) objs[i], format);
            } else {
                messages[i] = SmsMessage.createFromPdu((byte[]) objs[i]);
            }*/
            messages[i] = SmsMessage.createFromPdu((byte[]) objs[i]);
        }
        return messages;
    }
}

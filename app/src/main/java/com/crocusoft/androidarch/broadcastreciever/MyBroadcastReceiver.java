package com.crocusoft.androidarch.broadcastreciever;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.widget.Toast;

import com.crocusoft.androidarch.R;

import java.util.logging.Handler;

/**
 * Created by Asus on 3/1/2018.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(final Context context, Intent intent) {
        Toast.makeText(context, "Broadcast reciever is triggered", Toast.LENGTH_SHORT).show();
        android.os.Handler handler = new android.os.Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                showNotification(context);
            }
        }, 5000);
    }

    private void showNotification(Context context) {
        String CHANNEl_ID = "my_channel_id_01";
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEl_ID);
        builder.setSmallIcon(R.drawable.sendbroadcasticon);
        builder.setContentTitle("Successful");
        builder.setContentText("Your broadcast message is received");
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, builder.build());

    }
}

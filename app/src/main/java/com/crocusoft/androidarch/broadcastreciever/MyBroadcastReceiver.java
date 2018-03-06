package com.crocusoft.androidarch.broadcastreciever;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.crocusoft.androidarch.R;
import com.crocusoft.androidarch.utility.Helper;

import static com.crocusoft.androidarch.utility.Constants.CHANNEl_ID;
import static com.crocusoft.androidarch.utility.Constants.NOTIFY_RECEIVE_TIMEOUT;

/**
 * Created by Asus on 3/1/2018.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(final Context context, Intent intent) {
        Helper.showMessage(context,context.getResources().getString(R.string.broadcast_trigger));
        android.os.Handler handler = new android.os.Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                showNotification(context);
            }
        }, NOTIFY_RECEIVE_TIMEOUT);
    }

    private void showNotification(Context context) {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEl_ID);
        builder.setSmallIcon(R.drawable.sendbroadcasticon);
        builder.setContentTitle(context.getResources().getString(R.string.successfull));
        builder.setContentText(context.getResources().getString(R.string.broadcast_recieve_message));
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, builder.build());

    }
}

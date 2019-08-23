package com.luralabs.statussaver.listener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class NotificationBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

       /* String notificationMsg = intent.getStringExtra(WhatsappSaverConstants.notificationMsg);

        String notificationId = intent.getStringExtra(WhatsappSaverConstants.NOTIFICATION_ID);
        String notiMsg = intent.getStringExtra(WhatsappSaverConstants.MESSAGE);
        String sentTime = intent.getStringExtra(WhatsappSaverConstants.SENT_TIME);

        Database database = new Database(context);
        Bundle bundle = new Bundle();
        bundle.putString(WhatsappSaverConstants.NOTIFICATION_ID, notificationId);
        bundle.putString(WhatsappSaverConstants.MESSAGE, notiMsg);
        bundle.putString(WhatsappSaverConstants.SENT_TIME, sentTime);
        database.insertNotificationData(bundle);

        Toast.makeText(context, "q " + notificationMsg, Toast.LENGTH_SHORT).show();*/
    }
}

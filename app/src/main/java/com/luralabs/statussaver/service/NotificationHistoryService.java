package com.luralabs.statussaver.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.Log;

import com.luralabs.statussaver.database.WhatsAppDBHistoryDao;
import com.luralabs.statussaver.database.WhatsAppDBHistoryMessageDao;
import com.luralabs.statussaver.database.WhatsAppHistoryDB;
import com.luralabs.statussaver.database.model.WhatsAppHistory;
import com.luralabs.statussaver.database.model.WhatsAppHistoryMessages;

import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.List;

public class NotificationHistoryService extends NotificationListenerService {

    public final String WHATS_APP_PACK_NAME = "com.whatsapp";

    @Override
    public IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    @Override
    //@TargetApi(Build.VERSION_CODES.N)
    public void onListenerConnected() {
       /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
          //  getActiveNotifications();
        }*/
    }

    @Override
    @TargetApi(Build.VERSION_CODES.N)
    public void onListenerDisconnected() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            // Notification listener disconnected - requesting rebind
            requestRebind(new ComponentName(this, NotificationListenerService.class));
        }
    }


    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {

        Log.i("NotifyService", "got notification");

        if (sbn.getPackageName().contains(WHATS_APP_PACK_NAME)) {
            String tag = sbn.getTag();
            // long time = sbn.getPostTime();
            //int id = sbn.getId();
            //  String ticker = null;
            String message = null;
            //  String submessage = null;
            //   String summary = null;
            //   String info = null;
            String title = null;
            String mobile;

            Notification notification = sbn.getNotification();
            Bundle extras = notification.extras;
            if (extras.getCharSequence("android.title") != null) {
                title = extras.getString("android.title");
            }
            if (extras.getCharSequence("android.text") != null) {
                message = extras.getString("android.text");
            }
            /*if (extras.getCharSequence("android.subText") != null) {
                submessage = extras.getCharSequence("android.subText").toString();
            }
            if (extras.getCharSequence("android.summaryText") != null) {
                summary = extras.getCharSequence("android.summaryText").toString();
            }
            if (extras.getCharSequence("android.infoText") != null) {
                info = extras.getCharSequence("android.infoText").toString();
            }*/
            if (tag != null && !TextUtils.isEmpty(tag) && tag.contains("@")) {
                mobile = tag.substring(0, tag.indexOf("@"));
            } else {
                mobile = title;
            }

            WhatsAppHistory whatsAppHistory = new WhatsAppHistory(title, mobile,
                    DateFormat.format("hh:mm:ss aaa EEE dd-MM-yyyy", new Date(sbn.getPostTime())).toString());

            SaveHistory saveHistory = new SaveHistory(this, whatsAppHistory, message);
            saveHistory.execute();

        }
    }

   /* @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
        int notificationCode = matchNotificationCode(sbn);

        if (sbn.getPackageName().contains(ApplicationPackageNames.WHATS_APP_PACK_NAME)) {

            StatusBarNotification[] activeNotifications = this.getActiveNotifications();

            if (activeNotifications != null && activeNotifications.length > 0) {
                for (int i = 0; i < activeNotifications.length; i++) {
                    if (notificationCode == matchNotificationCode(activeNotifications[i])) {
                        Intent intent = new Intent(WhatsAppSaverConstants.notificationConstant);
                        intent.putExtra(WhatsAppSaverConstants.notificationCode, notificationCode);
                        intent.putExtra(WhatsAppSaverConstants.NOTIFICATION_ID, String.valueOf(sbn.getId()));
                        intent.putExtra(WhatsAppSaverConstants.MESSAGE, sbn.toString());
                        intent.putExtra(WhatsAppSaverConstants.SENT_TIME,
                                DateFormat.format("dd/MM/yyyy hh:mm:ss aaa", new Date(sbn.getPostTime())).toString());
                        sendBroadcast(intent);
                        break;
                    }
                }
            }
        }
    }

    private int matchNotificationCode(StatusBarNotification sbn) {
        String packageName = sbn.getPackageName();

        if (packageName.contains(ApplicationPackageNames.FACEBOOK_PACK_NAME)
                || packageName.contains(ApplicationPackageNames.FACEBOOK_MESSENGER_PACK_NAME)) {
            return (InterceptedNotificationCode.FACEBOOK_CODE);
        } else if (packageName.contains(ApplicationPackageNames.INSTAGRAM_PACK_NAME)) {
            return (InterceptedNotificationCode.INSTAGRAM_CODE);
        } else if (packageName.contains(ApplicationPackageNames.WHATS_APP_PACK_NAME)) {
            return (InterceptedNotificationCode.WHATSAPP_CODE);
        } else {
            return (InterceptedNotificationCode.OTHER_NOTIFICATIONS_CODE);
        }
    }*/
}

class SaveHistory extends AsyncTask<Void, Void, Void> {

    private WeakReference<Context> context;
    private WhatsAppHistory whatsAppHistory;
    private String message;

    public SaveHistory(Context context, WhatsAppHistory whatsAppHistory, String msg) {
        this.context = new WeakReference<>(context);
        this.whatsAppHistory = whatsAppHistory;
        this.message = msg;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        //adding to database
        WhatsAppDBHistoryDao dao = WhatsAppHistoryDB.getInstance(context.get()).getHistoryDao();
        WhatsAppDBHistoryMessageDao msgDAO = WhatsAppHistoryDB.getInstance(context.get()).getMessageDao();
        WhatsAppHistoryMessages whatsAppHistoryMessage = new WhatsAppHistoryMessages(whatsAppHistory.getName(),
                whatsAppHistory.getMobileNo(), message, whatsAppHistory.getUpdateDate());
        List<WhatsAppHistory> historySize = dao.getMobileHistory(whatsAppHistory.getName(), whatsAppHistory.getMobileNo());
        if (historySize != null && historySize.size() > 0) {
            dao.update(whatsAppHistory);
        } else {
            dao.insert(whatsAppHistory);
        }
        msgDAO.insert(whatsAppHistoryMessage);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }
}
package com.luralabs.statussaver.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.luralabs.statussaver.R;
import com.luralabs.statussaver.database.model.WhatsAppHistoryMessages;

import java.util.List;

public class NotificationMessageAdapter extends RecyclerView.Adapter<NotificationMessageAdapter.NotificationsHistoryHolder> {
    List<WhatsAppHistoryMessages> whatsAppHistoryList;
    Activity activity;

    public NotificationMessageAdapter(Activity activity, List<WhatsAppHistoryMessages> whatsAppHistoryList) {
        this.whatsAppHistoryList = whatsAppHistoryList;
        this.activity = activity;
    }

    @Override
    public NotificationMessageAdapter.NotificationsHistoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_notification_item, parent, false);
        NotificationsHistoryHolder notificationsHistoryHolder = new NotificationsHistoryHolder(v);
        return notificationsHistoryHolder;
    }

    @Override
    public void onBindViewHolder(NotificationsHistoryHolder holder, int position) {
        try {
            holder.name.setText(whatsAppHistoryList.get(position).getMessage());
            holder.time.setText(whatsAppHistoryList.get(position).getMessageCreatedTime());
            /*if (whatsAppHistoryList.get(position).getMessageInfo() != null &&
                    whatsAppHistoryList.get(position).getMessageInfo().size() > 0) {
                holder.message.setText(whatsAppHistoryList.get(0).getMessageInfo().get(0).getMessage());
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return whatsAppHistoryList.size();
    }


    public static class NotificationsHistoryHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView time;
        TextView message;
        ImageView imageView;
        CardView cardView;

        public NotificationsHistoryHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            time = (TextView) itemView.findViewById(R.id.time);
            message = (TextView) itemView.findViewById(R.id.message);
            imageView = (ImageView) itemView.findViewById(R.id.notificationImage);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
        }
    }
}

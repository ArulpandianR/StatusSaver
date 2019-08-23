package com.luralabs.statussaver.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.luralabs.statussaver.R;
import com.luralabs.statussaver.database.model.WhatsAppHistory;
import com.luralabs.statussaver.ui.main.HistoryMessageActivity;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationsHistoryHolder> {
    List<WhatsAppHistory> whatsAppHistoryList;
    Activity activity;

    public NotificationAdapter(Activity activity, List<WhatsAppHistory> whatsAppHistoryList) {
        this.whatsAppHistoryList = whatsAppHistoryList;
        this.activity = activity;
    }

    @Override
    public NotificationAdapter.NotificationsHistoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_notification_item, parent, false);
        NotificationsHistoryHolder notificationsHistoryHolder = new NotificationsHistoryHolder(v);
        return notificationsHistoryHolder;
    }

    @Override
    public void onBindViewHolder(NotificationsHistoryHolder holder, int position) {
        holder.name.setText(whatsAppHistoryList.get(position).getName());
        holder.time.setText(whatsAppHistoryList.get(position).getUpdateDate());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, HistoryMessageActivity.class);
                intent.putExtra("name", whatsAppHistoryList.get(position).getName());
                intent.putExtra("mobile", whatsAppHistoryList.get(position).getMobileNo());
                activity.startActivity(intent);
            }
        });
            /*if (whatsAppHistoryList.get(position).getMessageInfo() != null &&
                    whatsAppHistoryList.get(position).getMessageInfo().size() > 0) {
                holder.message.setText(whatsAppHistoryList.get(0).getMessageInfo().get(0).getMessage());
            }*/
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

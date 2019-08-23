package com.luralabs.statussaver.ui.main.notification;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.luralabs.statussaver.R;
import com.luralabs.statussaver.adapter.NotificationAdapter;
import com.luralabs.statussaver.database.WhatsAppHistoryDB;
import com.luralabs.statussaver.database.model.WhatsAppHistory;
import com.luralabs.statussaver.ui.base.BaseFragment;
import com.luralabs.statussaver.util.WhatsAppSaverConstants;

import java.util.List;

import butterknife.ButterKnife;


public class NotificationFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG = NotificationFragment.class.getSimpleName();
    View rootView;
    RecyclerView notificationsRecycler;
    SwipeRefreshLayout swipeRefreshLayout;

    public static NotificationFragment newInstance() {
        Bundle args = new Bundle();
        NotificationFragment fragment = new NotificationFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.notification_list, container, false);
        ButterKnife.bind(this, rootView);

        notificationsRecycler = (RecyclerView) rootView.findViewById(R.id.notificationsRecycler);
        swipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipeRefresh);
        swipeRefreshLayout.setOnRefreshListener(this);
        notificationsRecycler.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        notificationsRecycler.setHasFixedSize(true);
        WhatsAppHistoryDB.getInstance(getActivity());
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();

        getTasks();
        swipeRefreshLayout.setRefreshing(true);
        //fillNotificationsData();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
            }
        }, WhatsAppSaverConstants.DELAY_TIME);
    }

    /*@Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.delete:
                database.deleteNotifications();
                fillNotificationsData();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }*/

    private void getTasks() {
        class GetHistory extends AsyncTask<Void, Void, List<WhatsAppHistory>> {
            List<WhatsAppHistory> taskList;

            @Override
            protected List<WhatsAppHistory> doInBackground(Void... voids) {
                taskList = WhatsAppHistoryDB.getInstance(getActivity()).getHistoryDao().getAll();
                return taskList;
            }

            @Override
            protected void onPostExecute(List<WhatsAppHistory> tasks) {
                super.onPostExecute(tasks);
                fillNotificationsData(taskList);
            }
        }

        GetHistory gt = new GetHistory();
        gt.execute();
    }

    @Override
    public void onRefresh() {
        getTasks();
    }

    private void fillNotificationsData(List<WhatsAppHistory> taskList) {
        NotificationAdapter notificationAdapter = new NotificationAdapter(getActivity(), taskList);
        notificationAdapter.notifyDataSetChanged();
        notificationsRecycler.setAdapter(notificationAdapter);
        swipeRefreshLayout.setRefreshing(false);
    }
}
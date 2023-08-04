package com.example.myfpl.fragment;

import android.app.AlertDialog;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfpl.ApiInterface;
import com.example.myfpl.R;
import com.example.myfpl.adapter.NotificationAdapter;
import com.example.myfpl.model.Notification;
import com.example.myfpl.model.NotificationDetail;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HocTapFragment extends Fragment {

    private RecyclerView rcvNotification;
    private NotificationAdapter notificationAdapter;
    private List<Notification> notificationList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Khởi tạo danh sách thông báo và danh sách kết quả tìm kiếm
        notificationList = new ArrayList<>();
        //Khởi tạo notificationAdapter và đưa danh sách ban đầu vào RecyclerView
        notificationAdapter = new NotificationAdapter(notificationList);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_hoctap, container,false);

        rcvNotification = view.findViewById(R.id.rcvNotification);
        rcvNotification.setLayoutManager(new LinearLayoutManager(getActivity()));

        notificationAdapter = new NotificationAdapter(notificationList);
        rcvNotification.setAdapter(notificationAdapter);

        //Khởi tạo retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://172.16.69.208/challenges/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Gọi API và cập nhật dữ liệu vào adapter khi nhận được kết quả
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<List<Notification>> call = apiInterface.getNotifications();
        call.enqueue(new Callback<List<Notification>>() {
            @Override
            public void onResponse(Call<List<Notification>> call, Response<List<Notification>> response) {
                if (response.isSuccessful() && response.body() != null){
                    List<Notification> notifications = response.body();
                    //notificationAdapter.updateData(notifications);
                    notificationList.clear();
                    notificationList.addAll(notifications);
                    notificationAdapter.notifyDataSetChanged();

                }else {

                }
            }

            @Override
            public void onFailure(Call<List<Notification>> call, Throwable t) {

            }
        });
        //Thêm sự kiện click vào RecyclerView item
        notificationAdapter.setOnItemClickListener(new NotificationAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Notification notification) {
                showNotificationDetailDialog(notification);
            }
        });
        return view;
    }

    private void showNotificationDetailDialog(Notification notification) {
        //khởi tạo retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.31.170/challenges/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //gọi API để lấy nội dung chi tiết thông báo
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<NotificationDetail> call = apiInterface.getNotificationDetail(notification.getId());//thay đổi phương thức lấy thông báo chi tiết
        call.enqueue(new Callback<NotificationDetail>() {
            @Override
            public void onResponse(Call<NotificationDetail> call, Response<NotificationDetail> response) {
                if (response.isSuccessful() && response.body() != null){
                    NotificationDetail notificationDetail = response.body();
                    showDetailDialog(notificationDetail.getContent());
                }else {
                    Toast.makeText(getContext(), "lỗi", Toast.LENGTH_SHORT).show();
                    //xử lý lỗi khi không lấy được dữ liệu từ API
                }
            }

            @Override
            public void onFailure(Call<NotificationDetail> call, Throwable t) {

            }
        });
    }

    private void showDetailDialog(String content) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Nội dung chi tiết");
        builder.setMessage(content);
        builder.setPositiveButton("OK",null);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }


}


package com.example.myfpl;

import com.example.myfpl.model.Notification;
import com.example.myfpl.model.NotificationDetail;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    //Phương thức để lấy danh sách thông báo
    @GET("get_notifications.php")
    Call<List<Notification>> getNotifications();

    //Phương thức để lấy nội dung chi tiết của một thông báo
    @GET("get_notification_detail.php")
    Call<NotificationDetail> getNotificationDetail(@Query("notification_id") int notificationId);


}

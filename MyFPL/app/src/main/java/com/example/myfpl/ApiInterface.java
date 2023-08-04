package com.example.myfpl;

import com.example.myfpl.model.LichHoc;
import com.example.myfpl.model.LichThi;
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

    //Phương thức để lấy danh sách thông báo
    @GET("get_hoatdong.php")
    Call<List<Notification>> getHoatDong();

    //Phương thức để lấy nội dung chi tiết của một thông báo
    @GET("get_hoatdong_detail.php")
    Call<NotificationDetail> getHoatDong(@Query("hoatdong_id") int hoatdongId);

    @GET("get_lich_hoc.php")
    Call<List<LichHoc>> getLichHoc();

    // phương thức lấy danh sách lịch thi
    @GET("get_lich_thi.php")
    Call<List<LichThi>>getLichThi();
}

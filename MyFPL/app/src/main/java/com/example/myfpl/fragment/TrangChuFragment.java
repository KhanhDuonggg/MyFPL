package com.example.myfpl.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.example.myfpl.R;
import com.example.myfpl.adapter.SlideShowAdapter;

import java.util.ArrayList;
import java.util.List;

public class TrangChuFragment extends Fragment {

//    private ViewPager2 viewPager;
//    private List<Integer> imageList;

  ViewFlipper viewFlipper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trang_chu, container, false);
//        viewPager = view.findViewById(R.id.viewPager2);
//
//        // Khởi tạo danh sách hình ảnh (ID của hình ảnh)
//        imageList = new ArrayList<>();
//        imageList.add(R.drawable.a1);
//        imageList.add(R.drawable.a2);
//        imageList.add(R.drawable.a1);
//        imageList.add(R.drawable.a2);
//        // Thêm các hình ảnh khác vào danh sách
//
//        SlideShowAdapter adapter = new SlideShowAdapter(imageList);
//        viewPager.setAdapter(adapter);

        viewFlipper = view.findViewById(R.id.viewFlipper);
        BannerFliper();

        return view;
    }

    private  void BannerFliper(){
        ArrayList<String> list = new ArrayList<>();
        list.add("https://sanfulou.com/wp-content/uploads/2018/01/18-2-Copy-1024x683.jpg");
        list.add("https://sanfulou.com/wp-content/uploads/2018/01/DSC6633-Copy-1024x683.jpg");
        list.add("https://sanfulou.com/wp-content/uploads/2018/01/DSC08880-Copy-1024x683.jpg");
        list.add("https://sanfulou.com/wp-content/uploads/2018/01/CVP08895-Edit-Copy.jpg");



        for (int i = 0; i < list.size(); i++){
            ImageView imageView = new ImageView(getContext());
            Glide.with(getContext()).load(list.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            viewFlipper.addView(imageView);
        }

        viewFlipper.setFlipInterval(3500);
        viewFlipper.setAutoStart(true);

        Animation slideIn = AnimationUtils.loadAnimation(getContext(),R.anim.slide_in_right);
        Animation slideOut = AnimationUtils.loadAnimation(getContext(),R.anim.slide_out_right);

        viewFlipper.setInAnimation(slideIn);
        viewFlipper.setOutAnimation(slideOut);

        ThongBaoFragment thongBaoFragment = new ThongBaoFragment();
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayoutHT, thongBaoFragment);
        fragmentTransaction.commit();
    }
}







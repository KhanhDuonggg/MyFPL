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
        list.add("https://scontent.fsgn2-7.fna.fbcdn.net/v/t39.30808-6/277779143_3114317295448256_2446305358192948538_n.jpg?_nc_cat=108&ccb=1-7&_nc_sid=8631f5&_nc_ohc=SshYgLxrYYYAX8TuhPS&_nc_ht=scontent.fsgn2-7.fna&oh=00_AfBOlsFFkS_6yTpbNmHcZIhCxYpIUJuMC9mc70E8vbrdpw&oe=64D1D617");
        list.add("https://scontent.fsgn2-7.fna.fbcdn.net/v/t39.30808-6/362673342_768486631950705_5815616646323454831_n.jpg?_nc_cat=100&ccb=1-7&_nc_sid=e3f864&_nc_ohc=HH_rNompseUAX80nfB2&_nc_ht=scontent.fsgn2-7.fna&oh=00_AfAiKp4ReAqIYPPbjZL5xLcQdrpq_-TsTim4fhIXssu5BQ&oe=64D3091E");
        list.add("https://scontent.fsgn2-9.fna.fbcdn.net/v/t39.30808-6/301628773_195416636168484_3681579572725010941_n.png?_nc_cat=103&ccb=1-7&_nc_sid=e3f864&_nc_ohc=4ZW9f5b-FdoAX9KSkjV&_nc_ht=scontent.fsgn2-9.fna&oh=00_AfDYhWGHqSjIRs09PxdCs2xIfR3irf-7NXI1dC3D7rvJ1A&oe=64D15775");
        list.add("https://scontent.fsgn2-7.fna.fbcdn.net/v/t39.30808-6/301772883_195549102821904_6169508124093322401_n.jpg?_nc_cat=108&ccb=1-7&_nc_sid=8bfeb9&_nc_ohc=SizfYY46u-0AX_Qh0MP&_nc_oc=AQnzELEFXaDBU0sAVy1hmPmb8fOF_c7-52HeawDayJ2l8enyRvENlkJw1ckuzmbhwKk&_nc_ht=scontent.fsgn2-7.fna&oh=00_AfBtltevekMcmrZPLl-_MQkngdah_Agsk3p5ZFlzOZIbGA&oe=64D31D38");



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







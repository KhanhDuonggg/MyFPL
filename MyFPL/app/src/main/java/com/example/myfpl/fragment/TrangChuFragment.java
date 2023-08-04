package com.example.myfpl.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.myfpl.R;
import com.example.myfpl.adapter.SlideShowAdapter;

import java.util.ArrayList;
import java.util.List;

public class TrangChuFragment extends Fragment {

    private ViewPager2 viewPager;
    private List<Integer> imageList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trang_chu, container, false);
        viewPager = view.findViewById(R.id.viewPager2);

        // Khởi tạo danh sách hình ảnh (ID của hình ảnh)
        imageList = new ArrayList<>();
        imageList.add(R.drawable.a1);
        imageList.add(R.drawable.a2);
        imageList.add(R.drawable.a1);
        imageList.add(R.drawable.a2);
        // Thêm các hình ảnh khác vào danh sách

        SlideShowAdapter adapter = new SlideShowAdapter(imageList);
        viewPager.setAdapter(adapter);

        return view;
    }
}







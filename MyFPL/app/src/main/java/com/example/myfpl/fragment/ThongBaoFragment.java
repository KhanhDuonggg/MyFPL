package com.example.myfpl.fragment;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myfpl.MainActivity;
import com.example.myfpl.R;

public class ThongBaoFragment extends Fragment implements View.OnClickListener{

    ColorStateList colorStateList;
    TextView item1, item2, select;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_thongbao, container,false);

        item1 = view.findViewById(R.id.item1);
        item2 = view.findViewById(R.id.item2);

        item1.setOnClickListener(this);
        item2.setOnClickListener(this);

        select = view.findViewById(R.id.select);

        HocTapFragment hocTapFragment = new HocTapFragment();
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout_TB, hocTapFragment);
        fragmentTransaction.commit();
        return view;
    }



    @Override
    public void onClick(View view) {
        Fragment fragment = null;
        if (view.getId() == R.id.item1){
            fragment = new HocTapFragment();
            select.animate().x(0).setDuration(500);

        }else {
            fragment = new HoatDongFragment();
            int size = item2.getWidth();
            select.animate().x(size).setDuration(500);
        }

        getChildFragmentManager().beginTransaction()
                .replace(R.id.frameLayout_TB,fragment).commit();
    }
}


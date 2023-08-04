package com.example.myfpl.fragment;

import android.app.AlertDialog;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfpl.ApiInterface;
import com.example.myfpl.R;
import com.example.myfpl.SearchableFragment;
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

public class LichFragment extends Fragment implements View.OnClickListener{

    private SearchableFragment currentFragment;
    TextView item1, item2, select;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_lich, container,false);

        item1 = view.findViewById(R.id.item1);
        item2 = view.findViewById(R.id.item2);

        item1.setText("Lịch học");
        item2.setText("Lịch thi");

        item1.setOnClickListener(this);
        item2.setOnClickListener(this);

        select = view.findViewById(R.id.select);

        LichHocFragment lichHocFragment = new LichHocFragment();
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout_LH, lichHocFragment);
        fragmentTransaction.commit();

        return view;
    }

    @Override
    public void onClick(View view) {
        Fragment fragment = null;
        if (view.getId() == R.id.item1){
            fragment = new LichHocFragment();
            select.animate().x(0).setDuration(500);

        }else {
            fragment = new ScoreFragment();
            int size = item2.getWidth();
            select.animate().x(size).setDuration(500);
        }

        getChildFragmentManager().beginTransaction()
                .replace(R.id.frameLayout_LH,fragment).commit();
    }
}

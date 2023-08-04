package com.example.myfpl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.myfpl.fragment.ChatFragment;
import com.example.myfpl.fragment.LichFragment;
import com.example.myfpl.fragment.QRFragment;
import com.example.myfpl.fragment.TaiKhoanFragment;
import com.example.myfpl.fragment.ThongBaoFragment;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    private MeowBottomNavigation bottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation = findViewById(R.id.bottomNavigation);
        toolbar = findViewById(R.id.toolBar);

        setSupportActionBar(toolbar);

        toolbar.setTitle("Trang chủ");
        bottomNavigation.show(1, true);
        ThongBaoFragment thongBaoFragment = new ThongBaoFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, thongBaoFragment);
        fragmentTransaction.commit();

        bottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.home));
        bottomNavigation.add(new MeowBottomNavigation.Model(2,R.drawable.lichhoc));
        bottomNavigation.add(new MeowBottomNavigation.Model(3,R.drawable.qr));
        bottomNavigation.add(new MeowBottomNavigation.Model(4,R.drawable.chat));
        bottomNavigation.add(new MeowBottomNavigation.Model(5,R.drawable.user));

        bottomNavigation.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {

                Fragment fragment = null;
                switch (model.getId()){
                    case 1:
                        toolbar.setTitle("Trang chủ");
                        fragment = new ThongBaoFragment();
                        break;

                    case 2:
                        toolbar.setTitle("Lịch");
                        fragment = new LichFragment();
                        break;

                    case 3:
                        toolbar.setTitle("QR Scan");
                        fragment = new QRFragment();
                        break;
                    case 4:
                        toolbar.setTitle("Trò chuyện");
                        fragment = new ChatFragment();
                    break;

                    case 5:
                        toolbar.setTitle("Tài khoản");
                        fragment = new TaiKhoanFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout,fragment).commit();
                return null;
            }
        });

        bottomNavigation.setOnShowListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {

                switch (model.getId()){
                    case 1:
                        break;
                }
                return null;
            }
        });

        bottomNavigation.setOnShowListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {

                switch (model.getId()){
                    case 2: break;
                }
                return null;
            }
        });

        bottomNavigation.setOnShowListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {

                switch (model.getId()){
                    case 3: break;
                }
                return null;
            }
        });

        bottomNavigation.setOnShowListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {

                switch (model.getId()){
                    case 4: break;
                }
                return null;
            }
        });
    }
}
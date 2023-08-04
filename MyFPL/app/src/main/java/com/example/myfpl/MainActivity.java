package com.example.myfpl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.myfpl.fragment.ChatFragment;
import com.example.myfpl.fragment.DisplayQRContentFragment;
import com.example.myfpl.fragment.LichFragment;
import com.example.myfpl.fragment.TaiKhoanFragment;
import com.example.myfpl.fragment.ThongBaoFragment;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    private MeowBottomNavigation bottomNavigation;

    private SearchableFragment currentFragment;
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
                        fragment = new DisplayQRContentFragment();
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

                if (fragment instanceof SearchableFragment){
                    currentFragment = (SearchableFragment) fragment;
                }else {
                    currentFragment = null;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu to add items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_toolbar,menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        MenuItem searchMenuItem = menu.findItem(R.id.actionSearch);
        SearchView searchView = (SearchView) searchMenuItem.getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        //Lắng nghe sự kiện tìm kiếm và gửi yêu cầu tìm kiếm đến Fragment đang hiển thị
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (currentFragment != null){
                    currentFragment.performSearch(query);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //không làm gì khi người dùng thay đổi nội dung
                return false;
            }
        });
        return true;
    }
}
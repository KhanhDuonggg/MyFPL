package com.example.myfpl.fragment;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.myfpl.LoginActivity;
import com.example.myfpl.R;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class TaiKhoanFragment extends Fragment {

    GoogleSignInClient mGoogleSignInClient;
    SharedPreferences sharedPreferences;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_taikhoan, container,false);

        ImageView imgProfile = view.findViewById(R.id.imgProfileNav);
        TextView tvNameProfile = view.findViewById(R.id.tvNameProfileNav);
        TextView tvEmailProfile = view.findViewById(R.id.tvEmailProfileNav);
       // CardView btnlogout = view.findViewById(R.id.logout);

        sharedPreferences = getActivity().getSharedPreferences("userdata",MODE_PRIVATE);
        String nameProfile = sharedPreferences.getString("name","");
        String emailProfile = sharedPreferences.getString("email","");
        String pictureProfile = sharedPreferences.getString("picture", "");

        Glide.with(this).load(pictureProfile).circleCrop().into(imgProfile);
        tvNameProfile.setText(nameProfile);
        tvEmailProfile.setText(emailProfile);

//        btnlogout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                SharedPreferences.Editor editor = getActivity().getSharedPreferences("userdata",MODE_PRIVATE).edit();
//                        editor.clear();
//                        editor.apply();

//                    mGoogleSignInClient.signOut();
//                Intent intent = new Intent(getContext(), LoginActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                startActivity(intent);
//                mGoogleSignInClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("userdata",MODE_PRIVATE).edit();
//                        editor.clear();
//                        editor.apply();
//
//                        Intent intent = new Intent(getContext(), LoginActivity.class);
//                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                        startActivity(intent);
//                    }
//                });
//            }
//        });
        return view;
    }
}

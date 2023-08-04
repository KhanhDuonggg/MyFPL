package com.example.myfpl.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfpl.R;

import java.util.List;

public class SlideShowAdapter extends RecyclerView.Adapter<SlideShowAdapter.SlideshowViewHolder> {
    private List<Integer> imageList; // Danh sách ID của hình ảnh

    public SlideShowAdapter(List<Integer> imageList) {
        this.imageList = imageList;
    }

    @NonNull
    @Override
    public SlideshowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_slideshow, parent, false);
        return new SlideshowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SlideshowViewHolder holder, int position) {
        int imageResId = imageList.get(position);
        holder.imageView.setImageResource(imageResId);
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    static class SlideshowViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        SlideshowViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img);
        }
    }
}

package com.example.myfpl.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfpl.R;
import com.example.myfpl.model.LichHoc;

import java.util.List;

public class LichHocAdapter extends RecyclerView.Adapter<LichHocAdapter.LichHocViewHolder> {

    private List<LichHoc> lichHocs;
    private boolean isShow = false;

    public LichHocAdapter(List<LichHoc> lichHocs) {
        this.lichHocs = lichHocs;
    }
    public void updateDataLichHoc(List<LichHoc> newData){
        lichHocs.clear();
        lichHocs.addAll(newData);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LichHocViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lich_hoc,parent,false);
        return new LichHocViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LichHocViewHolder holder, int position) {
        LichHoc lichHoc = lichHocs.get(position);
        holder.tvPhong.setText(lichHoc.getPhong());
        holder.tvCaHoc.setText(lichHoc.getCa_hoc());
        holder.tvNgayHoc.setText(lichHoc.getNgay());
        holder.tvMaMon.setText(lichHoc.getMa_mon());
        holder.tvTenMon.setText(lichHoc.getTen_mon());
        holder.tvTenGiangVien.setText(lichHoc.getTen_giang_vien());
        holder.cardView.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return lichHocs.size();
    }

    public class LichHocViewHolder extends RecyclerView.ViewHolder {
        private TextView tvPhong, tvCaHoc, tvNgayHoc, tvMaMon, tvTenMon, tvTenGiangVien;
        ImageView imgShow;
        CardView cardView;
        public LichHocViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPhong = itemView.findViewById(R.id.tvPhong);
            tvCaHoc = itemView.findViewById(R.id.tvCaHoc);
            tvNgayHoc = itemView.findViewById(R.id.tvNgayHoc);
            tvMaMon = itemView.findViewById(R.id.tvMaMon);
            tvTenMon = itemView.findViewById(R.id.tvTenMon);
            tvTenGiangVien = itemView.findViewById(R.id.tvTenGiangVien);
            cardView = itemView.findViewById(R.id.cardview_lich_hoc);
            imgShow = itemView.findViewById(R.id.imgShowDetail_lichhoc);

            imgShow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(!isShow){
                        imgShow.setImageResource(R.drawable.down);
                        cardView.setVisibility(View.VISIBLE);
                        isShow=true;
                    }
                    else{
                        imgShow.setImageResource(R.drawable.right);
                        cardView.setVisibility(View.GONE);
                        isShow=false;
                    }
                }
            });

        }
    }
}

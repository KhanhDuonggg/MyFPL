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
import com.example.myfpl.model.LichThi;

import java.util.List;

public class LichThiAdapter extends RecyclerView.Adapter<LichThiAdapter.LichThiViewHolder> {

    private List<LichThi> lichThiList;
    private boolean isShow = false;

    public LichThiAdapter(List<LichThi> lichThiList) {
        this.lichThiList = lichThiList;
    }

    public void updateDataLichThi(List<LichThi> newData) {
        lichThiList.clear();
        lichThiList.addAll(newData);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LichThiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lich_thitung, parent, false);
        return new LichThiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LichThiViewHolder holder, int position) {
        LichThi lichThi = lichThiList.get(position);
        holder.tvLopThi.setText("Lớp: "+lichThi.getLop());
        holder.tvPhongThi.setText(lichThi.getPhong());
        holder.tvCaThi.setText("Ca: "+lichThi.getCa_thi());
        holder.tvNgayThi.setText(lichThi.getNgay());
        holder.tvMaMonThi.setText(lichThi.getMa_mon());
        holder.tvTenMonThi.setText(lichThi.getTen_mon());
        holder.tvDotThi.setText(lichThi.getDot_thi());
        holder.tvGV1.setText(lichThi.getGv1());
        holder.cardView.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return lichThiList.size();
    }

    public class LichThiViewHolder extends RecyclerView.ViewHolder {
        private TextView tvLopThi, tvPhongThi, tvCaThi, tvNgayThi, tvMaMonThi, tvTenMonThi, tvDotThi, tvGV1;
        CardView cardView;
        ImageView imgShow;

        public LichThiViewHolder(@NonNull View itemView) {
            super(itemView);
            tvLopThi = itemView.findViewById(R.id.tvLopThi);
            tvPhongThi = itemView.findViewById(R.id.tvPhongThi);
            tvCaThi = itemView.findViewById(R.id.tvCaThi);
            tvNgayThi = itemView.findViewById(R.id.tvNgayThi);
            tvMaMonThi = itemView.findViewById(R.id.tvMaMonThi);
            tvTenMonThi = itemView.findViewById(R.id.tvTenMonThi);
            tvDotThi = itemView.findViewById(R.id.tvDotThi);
            tvGV1 = itemView.findViewById(R.id.tvGV1);
            cardView = itemView.findViewById(R.id.cardview_lich_thi);
            imgShow = itemView.findViewById(R.id.imgShowDetail_lichthi);

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

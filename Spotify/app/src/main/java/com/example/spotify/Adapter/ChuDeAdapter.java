package com.example.spotify.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spotify.DSBaiHatActivity;
import com.example.spotify.Object.ChuDeObj;
import com.example.spotify.R;

import java.io.Serializable;
import java.util.List;

public class ChuDeAdapter extends RecyclerView.Adapter<ChuDeAdapter.ChuDeViewHolder>{
    List<ChuDeObj> chuDeObjList;

    public void setDataChuDe(List<ChuDeObj> list){
        this.chuDeObjList = list;
    }

    @NonNull
    @Override
    public ChuDeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_chu_de, parent, false);

        return new ChuDeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChuDeViewHolder holder, int position) {
        ChuDeObj chuDeObj = chuDeObjList.get(position);
        int id = position;
        String keyname = "keychude";
        String idobj = "idchude";

        if(chuDeObj == null) return;

        holder.tvchude.setText(chuDeObj.getNameChuDe());
        holder.imgchude.setImageResource(chuDeObj.getHinhChuDe());
        holder.itemchude.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context mContext = v.getContext();
                Context c = v.getContext();
                c.startActivity(new Intent(c, DSBaiHatActivity.class)
                        .putExtra("keyvalue", keyname)
                        .putExtra("keyobj", idobj)
                        .putExtra(keyname, (Serializable) chuDeObjList)
                        .putExtra(idobj, id));
            }
        });
    }

    @Override
    public int getItemCount() {
        if(chuDeObjList != null) return chuDeObjList.size();
        return 0;
    }

    class ChuDeViewHolder extends RecyclerView.ViewHolder {
        TextView tvchude;
        ImageView imgchude;
        CardView itemchude;
        public ChuDeViewHolder(@NonNull View itemView) {
            super(itemView);
            tvchude = itemView.findViewById(R.id.tvchude);
            imgchude = itemView.findViewById(R.id.imgchude);
            itemchude = itemView.findViewById(R.id.item_chu_de);
        }
    }
}

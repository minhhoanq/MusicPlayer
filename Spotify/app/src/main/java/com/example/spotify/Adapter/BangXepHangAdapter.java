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
import com.example.spotify.Object.BXHObj;
import com.example.spotify.R;

import java.io.Serializable;
import java.util.List;

public class BangXepHangAdapter extends RecyclerView.Adapter<BangXepHangAdapter.BangXepHangViewHolder>{
    private List<BXHObj> bxhObjList;

    public void getListData(List<BXHObj> list){
        this.bxhObjList = list;
    }

    @NonNull
    @Override
    public BangXepHangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_bxh, parent, false);

        return new BangXepHangViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BangXepHangViewHolder holder, int position) {
        BXHObj bxhObj = bxhObjList.get(position);
        int id = position;
        String keyname = "keybxh";
        String idobj = "idbxh";

        if(bxhObj == null) return;

        holder.tvbxh.setText(bxhObj.getTenbxh());
        holder.imgbxh.setImageResource(bxhObj.getHinhbxh());
        holder.itembxh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context mContext = v.getContext();
                Context c = v.getContext();
                c.startActivity(new Intent(c, DSBaiHatActivity.class)
                        .putExtra("keyvalue", keyname)
                        .putExtra("keyobj", idobj)
                        .putExtra(keyname, (Serializable) bxhObjList)
                        .putExtra(idobj, id));
            }
        });
    }

    @Override
    public int getItemCount() {
        if(bxhObjList != null) return bxhObjList.size();
        return 0;
    }

    class BangXepHangViewHolder extends RecyclerView.ViewHolder {
        TextView tvbxh;
        ImageView imgbxh;
        CardView itembxh;
        public BangXepHangViewHolder(@NonNull View itemView) {
            super(itemView);
            tvbxh = itemView.findViewById(R.id.tvbangxephang);
            imgbxh = itemView.findViewById(R.id.imgbangxephang);
            itembxh = itemView.findViewById(R.id.item_bxh);
        }
    }
}

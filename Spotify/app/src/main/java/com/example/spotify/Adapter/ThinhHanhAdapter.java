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
import com.example.spotify.Object.ThinhHanhObj;
import com.example.spotify.R;

import java.io.Serializable;
import java.util.List;

public class ThinhHanhAdapter extends RecyclerView.Adapter<ThinhHanhAdapter.ThinhHanhViewHolder>{
    private List<ThinhHanhObj> thinhHanhObjList;

    public void getListData(List<ThinhHanhObj> list){
        this.thinhHanhObjList = list;
    }

    @NonNull
    @Override
    public ThinhHanhViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_thinh_hanh, parent, false);
        return new ThinhHanhViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ThinhHanhViewHolder holder, int position) {
        ThinhHanhObj thinhHanhObj = thinhHanhObjList.get(position);
        int id = position;
        String keyname = "keythinhhanh";
        String idobj = "idthinhhanh";

        if(thinhHanhObj == null) return;

        holder.imgthinhhanh.setImageResource(thinhHanhObj.getHinhThinhHanh());
        holder.itemthinhhanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context mContext = v.getContext();
                Context c = v.getContext();
                c.startActivity(new Intent(c, DSBaiHatActivity.class)
                        .putExtra("keyvalue", keyname)
                        .putExtra("keyobj", idobj)
                        .putExtra(keyname, (Serializable) thinhHanhObjList)
                        .putExtra(idobj, id));
            }
        });
    }

    @Override
    public int getItemCount() {
        if(thinhHanhObjList != null) return thinhHanhObjList.size();
        return 0;
    }

    class ThinhHanhViewHolder extends RecyclerView.ViewHolder {
        ImageView imgthinhhanh;
        CardView itemthinhhanh;

        public ThinhHanhViewHolder(@NonNull View itemView) {
            super(itemView);
            imgthinhhanh = itemView.findViewById(R.id.imgthinhhanh);
            itemthinhhanh = itemView.findViewById(R.id.item_thinh_hanh);
        }
    }
}

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
import com.example.spotify.Object.TheLoaiObj;
import com.example.spotify.R;

import java.io.Serializable;
import java.util.List;

public class TheLoaiAdapter extends RecyclerView.Adapter<TheLoaiAdapter.TheLoaiViewHolder>{
    List<TheLoaiObj> theLoaiObjList;

    public void getDataTheLoai(List<TheLoaiObj> list){
        this.theLoaiObjList = list;
    }

    @NonNull
    @Override
    public TheLoaiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_the_loai, parent,false);
        return new TheLoaiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TheLoaiViewHolder holder, int position) {
        TheLoaiObj theLoaiObj = theLoaiObjList.get(position);
        int id = position;
        String keyname = "keytheloai";
        String idobj = "idtheloai";

        if(theLoaiObj == null) return;

        holder.tvTheLoai.setText(theLoaiObj.getNametheloai());
        holder.imageTheLoai.setImageResource(theLoaiObj.getHinhTheLoai());
        holder.itemtheloai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context mContext = v.getContext();
                Context c = v.getContext();
                c.startActivity(new Intent(c, DSBaiHatActivity.class)
                            .putExtra("keyvalue", keyname)
                            .putExtra("keyobj", idobj)
                            .putExtra(keyname, (Serializable) theLoaiObjList)
                            .putExtra(idobj, id));
            }
        });
    }

    @Override
    public int getItemCount() {
        if(theLoaiObjList != null) return theLoaiObjList.size();
        return 0;
    }

    class TheLoaiViewHolder extends RecyclerView.ViewHolder {
        TextView tvTheLoai;
        ImageView imageTheLoai;
        CardView itemtheloai;
        public TheLoaiViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTheLoai = itemView.findViewById(R.id.tvtheloai);
            imageTheLoai = itemView.findViewById(R.id.imgtheloai);
            itemtheloai = itemView.findViewById(R.id.item_theloai);
        }
    }
}

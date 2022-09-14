package com.example.spotify.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spotify.ActivitySong;
import com.example.spotify.DSBaiHatActivity;
import com.example.spotify.Object.NgheSiObj;
import com.example.spotify.R;

import java.io.Serializable;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class NgheSiAdapter extends RecyclerView.Adapter<NgheSiAdapter.NgheSiViewHolder>{
    List<NgheSiObj> ngheSiObjList;

    public void setDataNgheSi(List<NgheSiObj> list){
        this.ngheSiObjList = list;
    }

    @NonNull
    @Override
    public NgheSiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_nghe_si, parent, false);

        return new NgheSiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NgheSiViewHolder holder, int position) {
        NgheSiObj ngheSiObj = ngheSiObjList.get(position);
        int id= position;
        String keyname = "keynghesi";
        String idobj = "idnghesi";

        if(ngheSiObj == null) return;

        holder.tvnghesi.setText(ngheSiObj.getNameNgheSi());
        holder.cimgnghesi.setImageResource(ngheSiObj.getHinhNgheSi());
        holder.itemnghesi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context mContext = v.getContext();
                Context c = v.getContext();
                c.startActivity(new Intent(c, DSBaiHatActivity.class)
                            .putExtra("keyvalue", keyname)
                            .putExtra("keyobj", idobj)
                            .putExtra(keyname, (Serializable) ngheSiObjList)
                            .putExtra(idobj, id));
            }
        });
    }

    @Override
    public int getItemCount() {
        if(ngheSiObjList != null) return ngheSiObjList.size();
        return 0;
    }

    class NgheSiViewHolder extends RecyclerView.ViewHolder {
        CardView itemnghesi;
        TextView tvnghesi;
        CircleImageView cimgnghesi;
        public NgheSiViewHolder(@NonNull View itemView) {
            super(itemView);
            tvnghesi = itemView.findViewById(R.id.tvnghesi);
            cimgnghesi = itemView.findViewById(R.id.cimgnghesi);
            itemnghesi = itemView.findViewById(R.id.item_nghesi);
        }
    }
}

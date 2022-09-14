package com.example.spotify.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spotify.Object.NgheSiObj;
import com.example.spotify.Object.Song;
import com.example.spotify.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class NSLibsAdapter extends RecyclerView.Adapter<NSLibsAdapter.NSLibsViewHolder>{
    private List<NgheSiObj> ngheSiObjList;

    public void setListData(List<NgheSiObj> list){
        this.ngheSiObjList = list;
    }

    @NonNull
    @Override
    public NSLibsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_libs_nghesi, parent, false);
        return new NSLibsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NSLibsViewHolder holder, int position) {
        NgheSiObj ngheSiObj = ngheSiObjList.get(position);

        if(ngheSiObj == null) return;

        holder.tvtenns.setText(ngheSiObj.getNameNgheSi());
        holder.imghinhns.setImageResource(ngheSiObj.getHinhNgheSi());
    }

    @Override
    public int getItemCount() {
        if(ngheSiObjList != null) return ngheSiObjList.size();
        return 0;
    }

    class NSLibsViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imghinhns;
        TextView tvtenns;
        public NSLibsViewHolder(@NonNull View itemView) {
            super(itemView);
            imghinhns = itemView.findViewById(R.id.imageviewthuviennghesi);
            tvtenns = itemView.findViewById(R.id.textviewthuviennghesi);
        }
    }
}

package com.example.spotify.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spotify.ActivitySong;
import com.example.spotify.DSBaiHatActivity;
import com.example.spotify.Object.Song;
import com.example.spotify.R;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.List;

public class ListSongAdapter extends RecyclerView.Adapter<ListSongAdapter.ListSongViewHolder>{
    private List<Song> listSong;

    public void setDataSong(List<Song> list){
        this.listSong = list;
    }

    @NonNull
    @Override
    public ListSongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_song, parent, false);
        return new ListSongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListSongViewHolder holder, int position) {
        Song song = listSong.get(position);
        int id = position;

        if(song == null) return;

        holder.imgview.setImageResource(song.getResourceID());
        holder.tvtenbaihat.setText(song.getName());
        holder.tvtencasi.setText(song.getDescripsion());
        holder.layoutnghesi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context mContext = v.getContext();
                Context c = v.getContext();
                c.startActivity(new Intent(c, ActivitySong.class)
                        .putExtra("listsong", (Serializable) listSong)
                        .putExtra("idsong", id));
            }
        });
    }

    @Override
    public int getItemCount() {
        if(listSong != null) return listSong.size();
        return 0;
    }

    class ListSongViewHolder extends RecyclerView.ViewHolder {
        ImageView imgview;
        TextView tvtenbaihat;
        TextView tvtencasi;
        ConstraintLayout layoutnghesi;
        public ListSongViewHolder(@NonNull View itemView) {
            super(itemView);
            imgview = itemView.findViewById(R.id.imghinhbaihat);
            tvtenbaihat = itemView.findViewById(R.id.tvtenbaihat);
            tvtencasi = itemView.findViewById(R.id.tvtencasi);
            layoutnghesi = itemView.findViewById(R.id.layoutlistnghesi);
        }
    }
}

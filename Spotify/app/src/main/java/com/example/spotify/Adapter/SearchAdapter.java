package com.example.spotify.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spotify.Object.Song;
import com.example.spotify.R;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {
    private List<Song> listSong;

    public SearchAdapter(List<Song> listSong) {
        this.listSong = listSong;
    }

    public void setDataSearch(List<Song> list){
        this.listSong = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_song_search, parent, false);
        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        Song song = listSong.get(position);

        if(song == null) return;

        holder.tvName.setText(song.getName());
        holder.tvDescription.setText(song.getDescripsion());
        holder.imgViewSearch.setImageResource(song.getResourceID());

    }

    @Override
    public int getItemCount() {
        if(listSong != null) return listSong.size();
        return 0;
    }


    class SearchViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvDescription;
        ImageView imgViewSearch;
        public SearchViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvDescription = itemView.findViewById(R.id.tvdescription);
            imgViewSearch = itemView.findViewById(R.id.imgsearch);
        }
    }
}

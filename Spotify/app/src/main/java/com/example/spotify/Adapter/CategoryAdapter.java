package com.example.spotify.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spotify.ActivitySong;
import com.example.spotify.Object.Category;
import com.example.spotify.Object.Song;
import com.example.spotify.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>{
    private List<Category> listCategory;
    private Context mContext;

    public CategoryAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<Category> list){
        this.listCategory = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.custom_item_group, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = listCategory.get(position);

        if(category == null) return;

        holder.tvcategory.setText(category.getNameCate());
    }

    @Override
    public int getItemCount() {
        if(listCategory != null) return listCategory.size();
        return 0;
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvcategory;
        RecyclerView rcvgroup;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvcategory = itemView.findViewById(R.id.tv_category);
            rcvgroup = itemView.findViewById(R.id.rcv_item);
        }
    }
}

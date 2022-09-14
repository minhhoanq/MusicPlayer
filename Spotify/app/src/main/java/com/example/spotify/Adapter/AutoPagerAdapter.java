package com.example.spotify.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.spotify.Object.Song;
import com.example.spotify.R;

import java.util.List;

public class AutoPagerAdapter extends PagerAdapter {

    private Context mContext;
    private List<Song> mListSong;

    public AutoPagerAdapter(Context mContext, List<Song> mListSong) {
        this.mContext = mContext;
        this.mListSong = mListSong;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.auto_slide_item, container, false);
        ImageView imgAuto = view.findViewById(R.id.imgauto);

        Song song = mListSong.get(position);
        if(song != null){
            Glide.with(mContext).load(song.getResourceID()).into(imgAuto);
        }

        container.addView(view);

        return view;
    }

    @Override
    public int getCount() {
        if(mListSong != null) return mListSong.size();
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}

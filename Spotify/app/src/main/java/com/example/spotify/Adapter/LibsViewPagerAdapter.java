package com.example.spotify.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.spotify.Fragment.AlbumFragment;
import com.example.spotify.Fragment.NSLibsFragment;
import com.example.spotify.Fragment.PlayListFragment;

public class LibsViewPagerAdapter extends FragmentStatePagerAdapter {
    public LibsViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 :
                return new PlayListFragment();
            case 1 :
                return new NSLibsFragment();
            case 2 :
                return new AlbumFragment();
        }
        return new PlayListFragment();
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0 :
                title = "PLAYLIST";
                break;
            case 1 :
                title = "NGHỆ SĨ";
                break;
            case 2 :
                title = "ALBUM";
                break;
        }
        return title;
    }
}

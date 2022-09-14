package com.example.spotify.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.spotify.Adapter.BangXepHangAdapter;
import com.example.spotify.Object.BXHObj;
import com.example.spotify.Object.Song;
import com.example.spotify.R;

import java.util.ArrayList;
import java.util.List;

public class BangXepHangFragment extends Fragment {
    RecyclerView rcvbxh;
    BangXepHangAdapter bangXepHangAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bang_xep_hang, container, false);
        rcvbxh = view.findViewById(R.id.rcvbangxephang);
        LinearLayoutManager linear = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rcvbxh.setLayoutManager(linear);
        bangXepHangAdapter = new BangXepHangAdapter();
        bangXepHangAdapter.getListData(getListBXH());
        rcvbxh.setAdapter(bangXepHangAdapter);

        return view;
    }

    private List<BXHObj> getListBXH() {
        List<BXHObj> list = new ArrayList<>();

        list.add(new BXHObj("Top 50 Việt Nam", R.drawable.top50vietnam, ListSongOfBXHVN()));
        list.add(new BXHObj("Top 50 Việt Nam", R.drawable.top50southkorea, ListSongOfBXHVN()));
        list.add(new BXHObj("Top 50 Việt Nam", R.drawable.top50global, ListSongOfBXHVN()));

        return list;
    }

    private List<Song> ListSongOfBXHVN(){
        List<Song> list = new ArrayList<>();
        list.add(new Song(R.drawable.haimuoihaijpg,"Hai mươi hai(22)", "Amee", R.raw.haimuoihai));
        list.add(new Song(R.drawable.embe,"Em bé", "Amee", R.raw.embe));
        list.add(new Song(R.drawable.exhateme,"Ex's hate me", "Amee", R.raw.exshateme));
        list.add(new Song(R.drawable.misstoanthubackhoa,"Miss toàn thư bách khoa", "Amee", R.raw.misstoanthubk));
        list.add(new Song(R.drawable.neumaichiatay,"Nếu mai chia tay", "Amee", R.raw.neumaichiatay));
        list.add(new Song(R.drawable.doforlove,"Do for love", "Amee", R.raw.doforlove));

        return list;
    }
}
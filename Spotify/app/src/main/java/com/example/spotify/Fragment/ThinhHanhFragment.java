package com.example.spotify.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.spotify.Adapter.ThinhHanhAdapter;
import com.example.spotify.Object.Song;
import com.example.spotify.Object.ThinhHanhObj;
import com.example.spotify.R;

import java.util.ArrayList;
import java.util.List;

public class ThinhHanhFragment extends Fragment {
    private RecyclerView rcvthinhhanh;
    private ThinhHanhAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_thinh_hanh, container, false);
        rcvthinhhanh = view.findViewById(R.id.rcvthinhhanh);
        adapter = new ThinhHanhAdapter();
        LinearLayoutManager linear = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rcvthinhhanh.setLayoutManager(linear);
        adapter.getListData(getListThinhHanh());
        rcvthinhhanh.setAdapter(adapter);
        return view;
    }

    private List<ThinhHanhObj> getListThinhHanh() {
        List<ThinhHanhObj> list = new ArrayList<>();
        list.add(new ThinhHanhObj("Nhạc Hoa Ngữ", R.drawable.nhahoangu, R.drawable.nhachoangu2, ListSongOfNhacHoaNgu()));
        list.add(new ThinhHanhObj("Rap Việt", R.drawable.rapviet, R.drawable.rapviet2, ListSongOfNhacHoaNgu()));
        list.add(new ThinhHanhObj("Nhạc Nhật", R.drawable.nhacnhat, R.drawable.nhacnhat2, ListSongOfNhacHoaNgu()));

        return list;
    }

    private List<Song> ListSongOfNhacHoaNgu(){
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
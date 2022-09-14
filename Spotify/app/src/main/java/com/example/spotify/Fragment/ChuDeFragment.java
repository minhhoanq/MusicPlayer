package com.example.spotify.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.spotify.Adapter.ChuDeAdapter;
import com.example.spotify.Object.ChuDeObj;
import com.example.spotify.Object.Song;
import com.example.spotify.R;

import java.util.ArrayList;
import java.util.List;

public class ChuDeFragment extends Fragment {
    private RecyclerView rcvchude;
    private ChuDeAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chu_de, container, false);
        rcvchude = view.findViewById(R.id.rcvchude);

        LinearLayoutManager linear = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rcvchude.setLayoutManager(linear);
        adapter = new ChuDeAdapter();
        adapter.setDataChuDe(setListChuDe());
        rcvchude.setAdapter(adapter);
        return view;
    }

    private List<ChuDeObj> setListChuDe() {
        List<ChuDeObj> list = new ArrayList<>();

        list.add(new ChuDeObj("Nhạc Buồn", R.drawable.nhacbuon2, ListSongOfNhacPhim()));
        list.add(new ChuDeObj("ADM 2021", R.drawable.adm2021, ListSongOfNhacPhim()));
        list.add(new ChuDeObj("Du Lịch", R.drawable.dulicj, ListSongOfNhacPhim()));
        list.add(new ChuDeObj("Gaming", R.drawable.gaming, ListSongOfNhacPhim()));
        list.add(new ChuDeObj("Nhạc Phim", R.drawable.nhacphim, ListSongOfNhacPhim()));
        list.add(new ChuDeObj("K-POP", R.drawable.nhachanchongaymoi, ListSongOfNhacPhim()));
        list.add(new ChuDeObj("The Best Of 2021", R.drawable.thebestof2021, ListSongOfNhacPhim()));

        return list;
    }

    private List<Song> ListSongOfNhacPhim(){
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
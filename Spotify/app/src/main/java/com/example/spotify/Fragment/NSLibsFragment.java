package com.example.spotify.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.spotify.Adapter.NSLibsAdapter;
import com.example.spotify.Object.NgheSiObj;
import com.example.spotify.Object.Song;
import com.example.spotify.R;

import java.util.ArrayList;
import java.util.List;

public class NSLibsFragment extends Fragment {
    private RecyclerView rcvnslibs;
    private NSLibsAdapter nsLibsAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_n_s_libs, container, false);

        rcvnslibs = view.findViewById(R.id.rcv_libs_ns);
        LinearLayoutManager linear = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rcvnslibs.setLayoutManager(linear);
        nsLibsAdapter = new NSLibsAdapter();
        nsLibsAdapter.setListData(getListNgheSi());
        rcvnslibs.setAdapter(nsLibsAdapter);

        return view;
    }
    private List<NgheSiObj> getListNgheSi() {
        List<NgheSiObj> listSongNgheSi = new ArrayList<>();

        listSongNgheSi.add(new NgheSiObj("MIN", R.drawable.min, ListSongOfMIN()));
        listSongNgheSi.add(new NgheSiObj("Sơn Tùng M-TP", R.drawable.albumsontungmtp, ListSongOfSonTung()));
        listSongNgheSi.add(new NgheSiObj("Amee", R.drawable.amee, ListSongOfAmee()));
        listSongNgheSi.add(new NgheSiObj("Andiez", R.drawable.albumandiez, ListSongOfAmee()));
        listSongNgheSi.add(new NgheSiObj("Chi Dân", R.drawable.chidan, ListSongOfAmee()));
        listSongNgheSi.add(new NgheSiObj("Mr.Siro", R.drawable.albummrsiro, ListSongOfAmee()));
        listSongNgheSi.add(new NgheSiObj("SooBin Hoàng Sơn", R.drawable.albumsoobinhoangson, ListSongOfAmee()));
        listSongNgheSi.add(new NgheSiObj("Trung Quân Idol", R.drawable.albumtrungquanidol, ListSongOfAmee()));
        listSongNgheSi.add(new NgheSiObj("Đen Vâu", R.drawable.densong, ListSongOfAmee()));
        listSongNgheSi.add(new NgheSiObj("Bích Phương", R.drawable.bichphuong, ListSongOfAmee()));

        return listSongNgheSi;
    }

    private List<Song> ListSongOfAmee(){
        List<Song> list = new ArrayList<>();
        list.add(new Song(R.drawable.haimuoihaijpg,"Hai mươi hai(22)", "Amee", R.raw.haimuoihai));
        list.add(new Song(R.drawable.embe,"Em bé", "Amee", R.raw.embe));
        list.add(new Song(R.drawable.exhateme,"Ex's hate me", "Amee", R.raw.exshateme));
        list.add(new Song(R.drawable.misstoanthubackhoa,"Miss toàn thư bách khoa", "Amee", R.raw.misstoanthubk));
        list.add(new Song(R.drawable.neumaichiatay,"Nếu mai chia tay", "Amee", R.raw.neumaichiatay));
        list.add(new Song(R.drawable.doforlove,"Do for love", "Amee", R.raw.doforlove));

        return list;
    }

    private List<Song> ListSongOfSonTung(){
        List<Song> list = new ArrayList<>();
        list.add(new Song(R.drawable.albumsontungmtp,"Âm Thầm Bên Em", "Sơn Tùng", R.raw.amthambenem));
        list.add(new Song(R.drawable.albumsontungmtp,"Âm Thầm Bên Em", "Sơn Tùng", R.raw.amthambenem));
        list.add(new Song(R.drawable.albumsontungmtp,"Âm Thầm Bên Em", "Sơn Tùng", R.raw.amthambenem));
        list.add(new Song(R.drawable.albumsontungmtp,"Âm Thầm Bên Em", "Sơn Tùng", R.raw.amthambenem));
        list.add(new Song(R.drawable.albumsontungmtp,"Âm Thầm Bên Em", "Sơn Tùng", R.raw.amthambenem));
        list.add(new Song(R.drawable.albumsontungmtp,"Âm Thầm Bên Em", "Sơn Tùng", R.raw.amthambenem));

        return list;
    }

    private List<Song> ListSongOfMIN(){
        List<Song> list = new ArrayList<>();
        list.add(new Song(R.drawable.min,"Yêu (Acoustic Version)", "MIN", R.raw.haimuoihai));
        list.add(new Song(R.drawable.amee,"Hai mươi hai(22)", "Amee", R.raw.haimuoihai));
        list.add(new Song(R.drawable.amee,"Hai mươi hai(22)", "Amee", R.raw.haimuoihai));
        list.add(new Song(R.drawable.amee,"Hai mươi hai(22)", "Amee", R.raw.haimuoihai));
        list.add(new Song(R.drawable.amee,"Hai mươi hai(22)", "Amee", R.raw.haimuoihai));
        list.add(new Song(R.drawable.amee,"Hai mươi hai(22)", "Amee", R.raw.haimuoihai));

        return list;
    }
}
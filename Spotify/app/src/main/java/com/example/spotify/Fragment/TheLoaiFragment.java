package com.example.spotify.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.spotify.Adapter.TheLoaiAdapter;
import com.example.spotify.Object.Song;
import com.example.spotify.Object.TheLoaiObj;
import com.example.spotify.R;

import java.util.ArrayList;
import java.util.List;

public class TheLoaiFragment extends Fragment {
    private RecyclerView rcvtheloai;
    private TheLoaiAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_the_loai, container, false);
        rcvtheloai = view.findViewById(R.id.rcvtheloai);

        adapter = new TheLoaiAdapter();
        LinearLayoutManager linear = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rcvtheloai.setLayoutManager(linear);
        adapter.getDataTheLoai(ListTheLoai());
        rcvtheloai.setAdapter(adapter);
        return view;
    }

    private List<TheLoaiObj> ListTheLoai() {
        List<TheLoaiObj> list = new ArrayList<>();

        list.add(new TheLoaiObj("Lofi", R.drawable.toplofi2022, ListTheLoaiLofi()));
        list.add(new TheLoaiObj("Người chơi hệ K-POP", R.drawable.nguoichoihekpop, ListTheLoaiKPOP()));
        list.add(new TheLoaiObj("Piano", R.drawable.piano, ListTheLoaiKPOP()));
        list.add(new TheLoaiObj("Coffee Time", R.drawable.coffeetime, ListTheLoaiKPOP()));
        list.add(new TheLoaiObj("Chill Out", R.drawable.chillout, ListTheLoaiKPOP()));
        list.add(new TheLoaiObj("Vì Em Quá Cô Đơn Rồi", R.drawable.viemquacodonroi, ListTheLoaiKPOP()));
        list.add(new TheLoaiObj("Yêu Một Người Có Phải Chăng Lỗi Lầm", R.drawable.yeumoinguoipclaloilam, ListTheLoaiKPOP()));

        return list;
    }

    private List<Song> ListTheLoaiLofi(){
        List<Song> list = new ArrayList<>();

        list.add(new Song(R.drawable.bamotkhongbayhai, "3107-2", "DuongG, Nâu, W/n, Freak D", R.raw.bamotkhongbayhai));
        list.add(new Song(R.drawable.nhunhunggianhnoi, "Như những gì anh nói", "Bozitt", R.raw.nhunhunggianhnoi));
        list.add(new Song(R.drawable.chungtacuasaunay, "Chúng ta của sau này", "T.R.I, Freak D", R.raw.chungtacuasaunay));
        list.add(new Song(R.drawable.lieugio, "Liệu giờ", "2T, Venn, Ekid", R.raw.lieugio));
        list.add(new Song(R.drawable.vaigiaynuathoi, "Vài giây nữa thôi", "Reddy (Hữu Duy), Freak D", R.raw.vaigiaynuathoi));

        return list;
    }

    private List<Song> ListTheLoaiKPOP(){
        List<Song> list = new ArrayList<>();

        list.add(new Song(R.drawable.black, "Black", "G-Dragon, Jennie", R.raw.black));
        list.add(new Song(R.drawable.pinkvenom, "Pink Venom", "BlackPink", R.raw.pinkvenom));
        list.add(new Song(R.drawable.killthislove, "Kill This Love", "BlackPink", R.raw.killthislove));
        list.add(new Song(R.drawable.ddududdudu, "DDU-DU DDU-DU", "BlackPink", R.raw.ddududdudu));
        list.add(new Song(R.drawable.boombayah, "Boombayah ", "BlackPink", R.raw.boombayah));

        return list;
    }



}
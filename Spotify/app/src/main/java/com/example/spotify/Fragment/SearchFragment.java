package com.example.spotify.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.spotify.Adapter.SearchAdapter;
import com.example.spotify.MainActivity;
import com.example.spotify.Object.Song;
import com.example.spotify.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchFragment extends Fragment {
    private RecyclerView rcvSearch;
    private SearchAdapter searchAdapter;
    private SearchView searchView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        //recycleview
        rcvSearch = view.findViewById(R.id.rcv_search);
        searchAdapter = new SearchAdapter(getListDataSearch());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rcvSearch.setLayoutManager(layoutManager);
        rcvSearch.setAdapter(searchAdapter);

        //Search view
        searchView = view.findViewById(R.id.search_view);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });

        return view;
    }

    public List<Song> getListDataSearch() {
        List<Song> listSong = new ArrayList<>();



        listSong.add(new Song(R.drawable.black, "Black", "G-Dragon, Jennie", R.raw.black));
        listSong.add(new Song(R.drawable.pinkvenom, "Pink Venom", "BlackPink", R.raw.pinkvenom));
        listSong.add(new Song(R.drawable.killthislove, "Kill This Love", "BlackPink", R.raw.killthislove));


        listSong.add(new Song(R.drawable.wnsong, "3107", "W/n", R.raw.bamotkhongbay));
        listSong.add(new Song(R.drawable.mrsirosong, "Em g??i m??a", "Mr.Siro", R.raw.emgaimua));
        listSong.add(new Song(R.drawable.stsong, "??m th???m b??n em", "S??n T??ng Mtp", R.raw.amthambenem));
        listSong.add(new Song(R.drawable.densong, "Gieo qu???", "??en V??u", R.raw.gieoque));

        listSong.add(new Song(R.drawable.bamotkhongbayhai, "3107-2", "DuongG, N??u, W/n, Freak D", R.raw.bamotkhongbayhai));
        listSong.add(new Song(R.drawable.nhunhunggianhnoi, "Nh?? nh???ng g?? anh n??i", "Bozitt", R.raw.nhunhunggianhnoi));

        listSong.add(new Song(R.drawable.ddududdudu, "DDU-DU DDU-DU", "BlackPink", R.raw.ddududdudu));
        listSong.add(new Song(R.drawable.boombayah, "Boombayah ", "BlackPink", R.raw.boombayah));listSong.add(new Song(R.drawable.chungtacuasaunay, "Ch??ng ta c???a sau n??y", "T.R.I, Freak D", R.raw.chungtacuasaunay));

        listSong.add(new Song(R.drawable.lieugio, "Li???u gi???", "2T, Venn, Ekid", R.raw.lieugio));
        listSong.add(new Song(R.drawable.vaigiaynuathoi, "V??i gi??y n???a th??i", "Reddy (H???u Duy), Freak D", R.raw.vaigiaynuathoi));

        listSong.add(new Song(R.drawable.bichphuong, "B??a y??u", "B??ch Ph????ng", R.raw.buayeu));
        listSong.add(new Song(R.drawable.soobin, "??i ????? tr??? v???", "SooBin Ho??ng S??n", R.raw.didetrove));
        listSong.add(new Song(R.drawable.amee, "Hai m????i hai", "Amee", R.raw.haimuoihai));
        listSong.add(new Song(R.drawable.trungquan, "V??? ph??a m??a", "Trung Qu??n Idol", R.raw.vephiamua));
        return listSong;
    }

    private void filterList(String newText) {
        List<Song> list = new ArrayList<>();
        for(Song song : getListDataSearch()){
            if(song.getName().toLowerCase().contains(newText.toLowerCase())){
                list.add(song);
            }
        }
        searchAdapter.setDataSearch(list);
    }
}
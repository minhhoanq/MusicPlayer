package com.example.spotify.category;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.spotify.Adapter.AutoPagerAdapter;
import com.example.spotify.Object.Song;
import com.example.spotify.R;
import com.example.spotify.UserActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class CategoryFragment extends Fragment {
    private ViewPager viewPager;
    private CircleIndicator indicator;
    private AutoPagerAdapter autoPagerAdapter;
    private Timer timer;
    private ImageView viewmenu;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        viewPager = view.findViewById(R.id.viewpager);
        indicator = view.findViewById(R.id.indicator);
        viewmenu = view.findViewById(R.id.view_menu);

        autoPagerAdapter = new AutoPagerAdapter(getActivity(), ListAutoSlide());
        viewPager.setAdapter(autoPagerAdapter);
        indicator.setViewPager(viewPager);
        autoPagerAdapter.registerDataSetObserver(indicator.getDataSetObserver());
        autoSlideImg();

        viewmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UserActivity.class);
                getActivity().startActivity(intent);
            }
        });

        return view;
    }

    private void autoSlideImg(){
        if(ListAutoSlide() == null || ListAutoSlide().isEmpty() || viewPager == null){
            return;
        }
        if(timer == null){
            timer = new Timer();
        }

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        int currentItem = viewPager.getCurrentItem();
                        int totalItem = ListAutoSlide().size() - 1;
                        if(currentItem < totalItem){
                            currentItem++;
                            viewPager.setCurrentItem(currentItem);
                        }else {
                            viewPager.setCurrentItem(0);
                        }
                    }
                });
            }
        }, 500, 2000);
    }

    private List<Song> ListAutoSlide(){
        List<Song> list = new ArrayList<>();

        list.add(new Song(R.drawable.tunglacuanhauqc, "Top lofi 2022 (QC)", "Quảng cáo", R.raw.boombayah));
        list.add(new Song(R.drawable.quangcaowhee, "Top lofi 2022 (QC)", "Quảng cáo", R.raw.boombayah));
        list.add(new Song(R.drawable.quangcaorapvietgaynghien, "Top lofi 2022 (QC)", "Quảng cáo", R.raw.boombayah));
        list.add(new Song(R.drawable.quangcaowinner, "Top lofi 2022 (QC)", "Quảng cáo", R.raw.boombayah));
        list.add(new Song(R.drawable.kpoponqc, "Top lofi 2022 (QC)", "Quảng cáo", R.raw.boombayah));
        list.add(new Song(R.drawable.nhachoaqc , "Top lofi 2022 (QC)", "Quảng cáo", R.raw.boombayah));
        list.add(new Song(R.drawable.quangcaochungthanhduy, "Top lofi 2022 (QC)", "Quảng cáo", R.raw.boombayah));

        return list;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(timer != null){
            timer.cancel();
            timer = null;
        }
    }
}
package com.example.spotify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.service.controls.actions.FloatAction;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.spotify.Adapter.ListSongAdapter;
import com.example.spotify.Object.BXHObj;
import com.example.spotify.Object.ChuDeObj;
import com.example.spotify.Object.NgheSiObj;
import com.example.spotify.Object.Song;
import com.example.spotify.Object.TheLoaiObj;
import com.example.spotify.Object.ThinhHanhObj;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;
import java.util.ArrayList;


public class DSBaiHatActivity extends AppCompatActivity {
    private ImageView imgdanhsachcakhuc;
    private TextView tendsck;
    private RecyclerView rcvsong;
    private FloatingActionButton actionButton;
    ArrayList<NgheSiObj> listnghesi;
    ArrayList<TheLoaiObj> listtheloai;
    ArrayList<BXHObj> listbxh;
    ArrayList<ThinhHanhObj> listthinhhanh;
    ArrayList<ChuDeObj> listchude;
    ArrayList<Song> songArrayList;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsbai_hat);
        init();
        Intent i = getIntent();
        Bundle bundle = i.getExtras();
        String keyname = bundle.getString("keyvalue");
        String keyid = bundle.getString("keyobj");

        String c = keyname;
        if(c.equals("keytheloai")){
            listtheloai = (ArrayList) bundle.getParcelableArrayList(keyname);
            id = bundle.getInt(keyid);
            tendsck.setText(listtheloai.get(id).getNametheloai());
            imgdanhsachcakhuc.setImageResource(listtheloai.get(id).getHinhTheLoai());
            songArrayList = (ArrayList<Song>) listtheloai.get(id).getListSongTheLoai();
        }

        if (c.equals("keynghesi")){
            listnghesi = (ArrayList) bundle.getParcelableArrayList(keyname);
            id = bundle.getInt(keyid);
            tendsck.setText(listnghesi.get(id).getNameNgheSi());
            imgdanhsachcakhuc.setImageResource(listnghesi.get(id).getHinhNgheSi());
            songArrayList = (ArrayList<Song>) listnghesi.get(id).getListSongNgheSi();
        }

        if (c.equals("keybxh")){
            listbxh = (ArrayList) bundle.getParcelableArrayList(keyname);
            id = bundle.getInt(keyid);
            tendsck.setText(listbxh.get(id).getTenbxh());
            imgdanhsachcakhuc.setImageResource(listbxh.get(id).getHinhbxh());
            songArrayList = (ArrayList<Song>) listbxh.get(id).getListBxh();
        }

        if (c.equals("keythinhhanh")){
            listthinhhanh = (ArrayList) bundle.getParcelableArrayList(keyname);
            id = bundle.getInt(keyid);
            tendsck.setText(listthinhhanh.get(id).getNameThinhHanh());
            imgdanhsachcakhuc.setImageResource(listthinhhanh.get(id).getHinhThinhHanhMin());
            songArrayList = (ArrayList<Song>) listthinhhanh.get(id).getListThinhHanh();
        }

        if (c.equals("keychude")){
            listchude = (ArrayList) bundle.getParcelableArrayList(keyname);
            id = bundle.getInt(keyid);
            tendsck.setText(listchude.get(id).getNameChuDe());
            imgdanhsachcakhuc.setImageResource(listchude.get(id).getHinhChuDe());
            songArrayList = (ArrayList<Song>) listchude.get(id).getListChuDe();
        }

        ListSongAdapter adapter = new ListSongAdapter();
        LinearLayoutManager linear = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        adapter.setDataSong(songArrayList);
        rcvsong.setLayoutManager(linear);
        rcvsong.setAdapter(adapter);

        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DSBaiHatActivity.this, ActivitySong.class)
                        .putExtra("listsong", (Serializable) songArrayList)
                        .putExtra("idsong", 0));
            }
        });
    }

    private void init(){
        imgdanhsachcakhuc = findViewById(R.id.imageviewdanhsachcakhuc);
        tendsck = findViewById(R.id.tvdanhsachcakhuc);
        rcvsong = findViewById(R.id.rcvdanhsachbaihat);
        actionButton = findViewById(R.id.floatingactionbutton);
    }
}
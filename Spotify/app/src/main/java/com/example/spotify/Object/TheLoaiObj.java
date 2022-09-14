package com.example.spotify.Object;

import java.io.Serializable;
import java.util.List;

public class TheLoaiObj implements Serializable {
    private String nametheloai;
    private int hinhTheLoai;
    private List<Song> listSongTheLoai;

    public TheLoaiObj(String name, int hinhTheLoai, List<Song> listSong) {
        this.nametheloai = name;
        this.hinhTheLoai = hinhTheLoai;
        this.listSongTheLoai = listSong;
    }

    public List<Song> getListSongTheLoai() {
        return listSongTheLoai;
    }

    public String getNametheloai() {
        return nametheloai;
    }

    public int getHinhTheLoai() {
        return hinhTheLoai;
    }
}

package com.example.spotify.Object;

import java.io.Serializable;
import java.util.List;

public class NgheSiObj implements Serializable {
    private String namenghesi;
    private int hinhNgheSi;
    private List<Song> listSongNgheSi;

    public NgheSiObj(String name, int hinhNgheSi, List<Song> listSong) {
        this.namenghesi = name;
        this.hinhNgheSi = hinhNgheSi;
        this.listSongNgheSi = listSong;
    }

    public List<Song> getListSongNgheSi() {
        return listSongNgheSi;
    }

    public String getNameNgheSi() {
        return namenghesi;
    }

    public int getHinhNgheSi() {
        return hinhNgheSi;
    }
}

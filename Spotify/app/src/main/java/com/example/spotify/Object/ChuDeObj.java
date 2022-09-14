package com.example.spotify.Object;

import java.io.Serializable;
import java.util.List;

public class ChuDeObj implements Serializable {
    private String namechude;
    private int hinhChuDe;
    private List<Song> listChuDe;

    public ChuDeObj(String name, int hinhChuDe, List<Song> listChuDe) {
        this.namechude = name;
        this.hinhChuDe = hinhChuDe;
        this.listChuDe = listChuDe;
    }

    public String getNameChuDe() {
        return namechude;
    }

    public int getHinhChuDe() {
        return hinhChuDe;
    }

    public List<Song> getListChuDe() {
        return listChuDe;
    }
}

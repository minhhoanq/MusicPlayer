package com.example.spotify.Object;

import java.io.Serializable;
import java.util.List;

public class ThinhHanhObj implements Serializable {
    private String nameThinhHanh;
    private int hinhThinhHanh;
    private int hinhThinhHanhMin;
    private List<Song> listThinhHanh;

    public ThinhHanhObj(String nameThinhHanh, int hinhThinhHanh, int hinhThinhHanhMin, List<Song> listThinhHanh) {
        this.nameThinhHanh = nameThinhHanh;
        this.hinhThinhHanh = hinhThinhHanh;
        this.hinhThinhHanhMin = hinhThinhHanhMin;
        this.listThinhHanh = listThinhHanh;
    }

    public String getNameThinhHanh() {
        return nameThinhHanh;
    }

    public int getHinhThinhHanh() {
        return hinhThinhHanh;
    }

    public int getHinhThinhHanhMin() {
        return hinhThinhHanhMin;
    }

    public List<Song> getListThinhHanh() {
        return listThinhHanh;
    }
}

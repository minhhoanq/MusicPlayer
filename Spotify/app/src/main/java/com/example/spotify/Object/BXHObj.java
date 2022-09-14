package com.example.spotify.Object;

import java.io.Serializable;
import java.util.List;

public class BXHObj implements Serializable {
    private String tenbxh;
    private int hinhbxh;
    private List<Song> listBxh;

    public BXHObj(String tenbxh, int hinhbxh, List<Song> listBxh) {
        this.tenbxh = tenbxh;
        this.hinhbxh = hinhbxh;
        this.listBxh = listBxh;
    }

    public String getTenbxh() {
        return tenbxh;
    }

    public int getHinhbxh() {
        return hinhbxh;
    }

    public List<Song> getListBxh() {
        return listBxh;
    }
}

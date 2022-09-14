package com.example.spotify.Object;

import java.io.Serializable;
import java.util.List;

public class Category implements Serializable {
    private String nameCate;
    private List<Song> song;

    public Category(String nameCate, List<Song> listSong) {
        this.nameCate = nameCate;
        this.song = listSong;
    }

    public String getNameCate() {
        return nameCate;
    }

    public List<Song> getListSong() {
        return song;
    }
}

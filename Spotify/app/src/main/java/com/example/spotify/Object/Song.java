package com.example.spotify.Object;


import java.io.Serializable;

public class Song implements Serializable {
    private int resourceID;
    private String descripsion, name;
    private int mysong;

    public Song(int resourceID, String name, String descripsion, int mysong) {
        this.resourceID = resourceID;
        this.descripsion = descripsion;
        this.name = name;
        this.mysong = mysong;
    }

    public String getName() {
        return name;
    }

    public int getResourceID() {
        return resourceID;
    }

    public String getDescripsion() {
        return descripsion;
    }

    public int getMysong() {
        return mysong;
    }

}

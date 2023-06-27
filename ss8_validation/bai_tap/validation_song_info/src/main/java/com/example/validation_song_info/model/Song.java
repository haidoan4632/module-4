package com.example.validation_song_info.model;

import javax.persistence.*;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String singer;
    private String kindOfMusic;
    @Column(name = "flag_delete",nullable = false)
    private boolean FlagDelete;

    public Song() {
    }

    public Song(int id, String name, String singer, String kindOfMusic, Boolean flagDelete) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.kindOfMusic = kindOfMusic;
        FlagDelete = flagDelete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }

    public Boolean getFlagDelete() {
        return FlagDelete;
    }

    public void setFlagDelete(Boolean flagDelete) {
        FlagDelete = flagDelete;
    }
}

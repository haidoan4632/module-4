package com.example.validation_song_info.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongDto implements Validator {
    private int id;
    @NotNull
    @Size(max = 800)
    @Pattern(regexp = "^[\\w ]+$", message = "Không chứa ký tự đặc biệt")
    private String name;
    @NotNull
    @Size(max = 300)
    @Pattern(regexp = "^[\\w ]+$", message = "Không chứa ký tự đặc biệt")
    private String singer;
    @NotNull
    @Size(max = 1000)
    @Pattern(regexp = "^[\\w ,]+$", message = "Không chứa ký tự đặc biệt ngoại trừ dấu phẩy")
    private String kindOfMusic;

    public SongDto() {
    }

    public SongDto(int id, String name, String singer, String kindOfMusic) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.kindOfMusic = kindOfMusic;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}

package com.example.validation_song_info.service;


import com.example.validation_song_info.model.Song;

import java.util.List;

public interface ISongService {
   List<Song> display();
    void createSong(Song song);
    void editSong(Song song);
    void deleteSong(Integer id);

    Song findById(Integer id);

}

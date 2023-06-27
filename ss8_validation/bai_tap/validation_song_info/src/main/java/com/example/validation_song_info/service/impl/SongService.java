package com.example.validation_song_info.service.impl;


import com.example.validation_song_info.model.Song;
import com.example.validation_song_info.repository.ISongRepository;
import com.example.validation_song_info.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository songRepository;

    @Override
    public List<Song> display() {
        return songRepository.findAll();
    }

    @Override
    public void createSong(Song song) {
        songRepository.save(song);
    }

    @Override
    public void editSong(Song song) {
        songRepository.save(song);
    }

    @Override
    public boolean deleteSong(Integer id) {
        return false;
    }

    @Override
    public Song detailSong(Integer id) {
        return songRepository.findById(id).get();
    }
}

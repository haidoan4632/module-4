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
        return songRepository.findAllByFlagDeleteIsFalse();
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
    public void deleteSong(Integer id) {
        Song song1 = songRepository.getSongsByIdAndFlagDeleteIsFalse(id);
        song1.setFlagDelete(true);
        songRepository.save(song1);
    }


    @Override
    public Song findById(Integer id) {
        return songRepository.getSongsByIdAndFlagDeleteIsFalse(id);
    }
}

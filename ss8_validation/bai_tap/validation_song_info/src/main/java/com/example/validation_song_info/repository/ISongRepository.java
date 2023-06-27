package com.example.validation_song_info.repository;

import com.example.validation_song_info.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Entity;
import java.util.List;



public interface ISongRepository extends JpaRepository<Song, Integer> {
    List<Song> findAllByFlagDeleteIsFalse();
    Song getSongsByIdAndFlagDeleteIsFalse(Integer id);

}

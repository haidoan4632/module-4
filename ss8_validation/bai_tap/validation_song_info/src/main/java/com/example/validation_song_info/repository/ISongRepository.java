package com.example.validation_song_info.repository;

import com.example.validation_song_info.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
@Repository
public interface ISongRepository extends JpaRepository<Song,Integer> {
    @Modifying
    @Transactional
    @Query(value = "update song as s set flag_delete = true where s.id = :id ", nativeQuery = true)
    void isDelete(@Param(value = "id") Integer id);
}

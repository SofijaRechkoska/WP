package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;

import java.util.List;

public interface SongService{
    List<Song> listSongs();
    void addArtistToSong(Artist artist, Long songId);
    Song findByTrackId(String trackId);
    Song findById(Long id);
    List<Song> songsByAlbumId(Long id);
    void save(Song song);
    void delete(Song song);
    void addReview(String trackId,int rating,String comment);
}

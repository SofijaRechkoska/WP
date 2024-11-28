package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SongRepository {
    public List<Song> findAll(){
        return DataHolder.songs;
    }
    public Song findByTrackId(String trackId){
        return DataHolder.songs.stream().filter(song -> song.getTrackId().equals(trackId)).findFirst().orElse(null);
    }
    public Artist addArtistToSong(Artist artist,Song song){
        for (Song s:DataHolder.songs) {
            if (s.getTrackId().equals(song.getTrackId())){
                s.addArtist(artist);
                return artist;
            }
        }
        return null;
    }
    public Song findById(Long id){
        return DataHolder.songs.stream().filter(song -> song.getId().equals(id)).findFirst().orElse(null);
    }
}

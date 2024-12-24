package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Review;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.repository.jpa.SongRepositoryJPA;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {
    private final SongRepositoryJPA songRepository;

    public SongServiceImpl(SongRepositoryJPA songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }

    public void addArtistToSong(Artist artist, Long songId) {
        Song song = songRepository.findById(songId)
                .orElseThrow(() -> new RuntimeException("Song not found"));
        song.addArtist(artist);
        songRepository.save(song);
    }


    @Override
    public Song findByTrackId(String trackId) {
        return songRepository.findByTrackId(trackId);
    }

    @Override
    public Song findById(Long id) {
        return songRepository.findById(id).orElse(null);
    }

    @Override
    public List<Song> songsByAlbumId(Long id) {
        return songRepository.findAllByAlbum_Id(id);
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public void delete(Song song) {
        songRepository.delete(song);
    }
    public void addReview(String trackId,int rating,String comment){
        Song song=songRepository.findByTrackId(trackId);
        song.getReviews().add(new Review(rating,comment));
    }

}

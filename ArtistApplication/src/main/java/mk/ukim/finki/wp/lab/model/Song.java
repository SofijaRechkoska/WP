package mk.ukim.finki.wp.lab.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.wp.lab.bootstrap.DataHolder;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Song {
    private Long id;
    private String trackId;
    private String title;
    private String genre;
    private int releaseYear;
    private List<Artist> performers;

    private Album album;

    public Song(String trackId, String title, String genre, int releaseYear, List<Artist> performers, Album album) {
        this.id = (long) (Math.random() * 1000);
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.performers = performers;
        this.album = album;
    }

    public void addArtist(Artist a) {
        for (Song song : DataHolder.songs) {
            if (song.getPerformers().contains(a)) {
                continue;
            }
            song.getPerformers().add(a);
        }
    }
}

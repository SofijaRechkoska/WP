//package mk.ukim.finki.wp.lab.bootstrap;
//
//import jakarta.annotation.PostConstruct;
//import mk.ukim.finki.wp.lab.model.Album;
//import mk.ukim.finki.wp.lab.model.Artist;
//import mk.ukim.finki.wp.lab.model.Song;
//import mk.ukim.finki.wp.lab.repository.jpa.AlbumRepositoryJPA;
//import mk.ukim.finki.wp.lab.repository.jpa.ArtistRepositoryJPA;
//import mk.ukim.finki.wp.lab.repository.jpa.SongRepositoryJPA;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class DataHolder {
//    private ArtistRepositoryJPA artistRepositoryJPA;
//    private SongRepositoryJPA songRepositoryJPA;
//    private AlbumRepositoryJPA albumRepositoryJPA;
//
//
//    public DataHolder(ArtistRepositoryJPA artistRepositoryJPA, SongRepositoryJPA songRepositoryJPA, AlbumRepositoryJPA albumRepositoryJPA) {
//        this.artistRepositoryJPA = artistRepositoryJPA;
//        this.songRepositoryJPA = songRepositoryJPA;
//        this.albumRepositoryJPA = albumRepositoryJPA;
//    }
//
//    public static List<Artist> artists = new ArrayList<>();
//    public static List<Song> songs = new ArrayList<>();
//    public static List<Album> albums = new ArrayList<>();
//
//    @PostConstruct
//    public void init() {
//
//        artists.add(new Artist( "John", "Lennon", "English singer, songwriter, and peace activist."));
//        artists.add(new Artist( "Freddie", "Mercury", "British singer, songwriter, and lead vocalist of Queen."));
//        artists.add(new Artist( "Elton", "John", "English singer, pianist, and composer."));
//        artists.add(new Artist("David", "Bowie", "English singer, songwriter, and actor."));
//        artists.add(new Artist("Bob", "Dylan", "American singer-songwriter, known for folk and rock music."));
//
//
//        albums.add(new Album("Imagine", "Pop", "1971"));
//        albums.add(new Album("A Night at the Opera", "Rock", "1975"));
//        albums.add(new Album("Honky Château", "Rock", "1972"));
//        albums.add(new Album("Space Oddity", "Pop", "1969"));
//        albums.add(new Album("Highway 61 Revisited", "Folk Rock", "1965"));
//
//        artistRepositoryJPA.saveAll(artists);
//        albumRepositoryJPA.saveAll(albums);
//
//        songs.add(new Song("T001", "Imagine", "Pop", 1971, new ArrayList<>(), albums.get(0)));
//        songs.add(new Song("T002", "Bohemian Rhapsody", "Rock", 1975, new ArrayList<>(), albums.get(1)));
//        songs.add(new Song("T003", "Rocket Man", "Rock", 1972, new ArrayList<>(), albums.get(2)));
//        songs.add(new Song("T004", "Space Oddity", "Pop", 1969, new ArrayList<>(), albums.get(3)));
//        songs.add(new Song("T005", "Like a Rolling Stone", "Folk Rock", 1965, new ArrayList<>(), albums.get(4)));
//
//        songRepositoryJPA.saveAll(songs);
//    }
//}

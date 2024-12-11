package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.AlbumService;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/songs")
public class SongController {
    private final SongService songService;
    private final AlbumService albumService;

    public SongController(SongService songService, AlbumService albumService) {
        this.songService = songService;
        this.albumService = albumService;
    }

    @GetMapping
    public String getSongsPage(@RequestParam(required = false) String error,
                               @RequestParam(required = false) Long albumId,
                               Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("error", error);
        }
        if (albumId != null) {
            model.addAttribute("songs", songService.songsByAlbumId(albumId));
        } else {
            model.addAttribute("songs", songService.listSongs());
        }

        model.addAttribute("albums", albumService.findAll());
        return "listSongs";
    }


    @GetMapping("/add")
    public String getAddSongPage(Model model) {
        model.addAttribute("albums", albumService.findAll());
        return "add-song";
    }

    @PostMapping("/add")
    public String saveSong(
            @RequestParam(required = false) Long id,
            @RequestParam String title,
            @RequestParam String trackId,
            @RequestParam String genre,
            @RequestParam int releaseYear,
            @RequestParam Long albumId) {

        Album album = albumService.findAlbumById(albumId);
        Song song;
        if (id != null) {
             song = songService.findById(id);
            song.setTitle(title);
            song.setTrackId(trackId);
            song.setGenre(genre);
            song.setReleaseYear(releaseYear);
            song.setAlbum(album);
        } else {
             song = new Song(trackId, title, genre, releaseYear, new ArrayList<>(), album);
            songService.listSongs().add(song);
        }
        songService.save(song);
        return "redirect:/songs";
    }

    @GetMapping("/edit-form/{id}")
    public String getEditSongForm(@PathVariable Long id, Model model) {
        Song song = songService.findById(id);
        if (song==null){
            return "redirect:/songs?error=SongNotFound";
        }
        model.addAttribute("song", song);
        model.addAttribute("albums", albumService.findAll());
        return "add-song";
    }

    @GetMapping("/delete/{id}")
    public String deleteSong(@PathVariable Long id){
        Song song=songService.findById(id);
        if (song!=null){
            songService.delete(song);
        }
        return "redirect:/songs";
    }

    @PostMapping
    public String submitButton(
            @RequestParam String trackId,
            Model model){
        System.out.println("Selected Track ID: " + trackId);
        return "redirect:/artist/" + trackId;
    }
}

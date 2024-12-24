package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.ArtistService;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/artist")
public class ArtistController {
    private final SongService songService;
    private final ArtistService artistService;

    public ArtistController(SongService songService, ArtistService artistService) {
        this.songService = songService;
        this.artistService = artistService;
    }

    @GetMapping("/{trackId}")
    public String getArtistPage(@PathVariable String trackId,
                                Model model) {
        model.addAttribute("artists", artistService.listArtists());
        model.addAttribute("trackId", trackId);
        return "artistsList";
    }

    @PostMapping()
    public String addArtist(
            @RequestParam String trackId,
            @RequestParam String artistId,
            Model model
    ) {
        Song song = songService.findByTrackId(trackId);
        Artist artist = artistService.ArtistfindById(Long.valueOf(artistId));
        model.addAttribute("song", song);
        model.addAttribute("artist", artist);
        return "redirect:/songDetails?trackId=" + trackId + "&artistId=" + artistId;
    }
}

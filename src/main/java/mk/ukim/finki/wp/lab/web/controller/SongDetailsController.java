package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Review;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.ArtistService;
import mk.ukim.finki.wp.lab.service.SongService;
import mk.ukim.finki.wp.lab.service.impl.ReviewServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/songDetails")
public class SongDetailsController {
    private final SongService songService;
    private final ArtistService artistService;
    private final ReviewServiceImpl reviewService;

    public SongDetailsController(SongService songService, ArtistService artistService, ReviewServiceImpl reviewService) {
        this.songService = songService;
        this.artistService = artistService;
        this.reviewService = reviewService;
    }

    @GetMapping()
    public String getSongDetailsPage(
            @RequestParam String trackId,
            @RequestParam String artistId,
            Model model) {
        Song song = songService.findByTrackId(trackId);
        Artist artist = artistService.ArtistfindById(Long.valueOf(artistId));
        songService.addArtistToSong(artist, song.getId());
        model.addAttribute("song", song);
        return "songDetails";
    }

    @PostMapping()
    public String getReviews(@RequestParam String trackId,
                             @RequestParam String comment,
                             Model model) {
        Song song = songService.findByTrackId(trackId);
        Review review = new Review(comment);
        song.getReviews().add(review);
        review.setSong(song);
        reviewService.saveReview(review);
        model.addAttribute("song", song);
        return "songDetails";
    }
}

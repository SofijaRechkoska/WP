package mk.ukim.finki.wp.lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.ArtistService;
import mk.ukim.finki.wp.lab.service.SongService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "songDetails",urlPatterns = "/songDetailss")
public class SongDetailsServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;
    private final SongService songService;
    private final ArtistService artistService;


    public SongDetailsServlet(SpringTemplateEngine springTemplateEngine, SongService songService, ArtistService artistService) {
        this.springTemplateEngine = springTemplateEngine;
        this.songService = songService;
        this.artistService = artistService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String trackId=req.getParameter("trackId");
        String artistId=req.getParameter("artistId");
        Artist artist=artistService.ArtistfindById(Long.valueOf(artistId));
        Song song=songService.findByTrackId(trackId);
        songService.addArtistToSong(artist,song);

        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);
        WebContext context=new WebContext(webExchange);
        context.setVariable("song",song);
        springTemplateEngine.process("songDetails.html",context,resp.getWriter());
    }
}

package mk.ukim.finki.wp.lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.ArtistService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "artists",urlPatterns = "/artistt")
public class ArtistServlet extends HttpServlet {
    private final ArtistService artistService;
    private SpringTemplateEngine springTemplateEngine;

    public ArtistServlet(ArtistService artistService, SpringTemplateEngine springTemplateEngine) {
        this.artistService = artistService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);
        WebContext context=new WebContext(webExchange);
        String trackId=req.getParameter("trackId");
        context.setVariable("trackId",trackId);
        context.setVariable("artists",artistService.listArtists());
        springTemplateEngine.process("artistsList.html",context,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String trackId=req.getParameter("trackId");
        String artistId=req.getParameter("artistId");
        System.out.println(trackId);
        System.out.println(artistId);
        resp.sendRedirect(req.getContextPath()+"/songDetails?trackId="+trackId+"&artistId="+artistId);

    }
}

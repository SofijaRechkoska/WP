package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.repository.jpa.ArtistRepositoryJPA;
import mk.ukim.finki.wp.lab.service.ArtistService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArtistServiceImpl implements ArtistService {
    private final ArtistRepositoryJPA artistRepository;

    public ArtistServiceImpl(ArtistRepositoryJPA artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public List<Artist> listArtists() {
        return artistRepository.findAll();
    }

    @Override
    public Artist ArtistfindById(Long id) {
        return artistRepository.findById(id).orElse(null);
    }
}

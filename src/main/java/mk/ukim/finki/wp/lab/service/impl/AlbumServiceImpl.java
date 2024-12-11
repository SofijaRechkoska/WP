package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.repository.jpa.AlbumRepositoryJPA;
import mk.ukim.finki.wp.lab.service.AlbumService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumServiceImpl implements AlbumService {
    private final AlbumRepositoryJPA albumRepository;

    public AlbumServiceImpl(AlbumRepositoryJPA albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Album> findAll() {
        return albumRepository.findAll();
    }

    public Album findAlbumById(Long id) {
        return albumRepository.findById(id).orElse(null);

    }

}

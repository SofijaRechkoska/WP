//package mk.ukim.finki.wp.lab.repository;
//
//import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
//import mk.ukim.finki.wp.lab.model.Album;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class AlbumRepository {
//    public List<Album> findAll(){
//        return DataHolder.albums;
//    }
//
//    public Album findAlbumId(Long id) {
//        return DataHolder.albums.stream()
//                .filter(i->i.getId().equals(id)).findFirst().orElse(null);
//    }
//}

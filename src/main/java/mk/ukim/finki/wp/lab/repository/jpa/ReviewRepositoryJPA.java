package mk.ukim.finki.wp.lab.repository.jpa;

import mk.ukim.finki.wp.lab.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepositoryJPA extends JpaRepository<Review,Long> {
}
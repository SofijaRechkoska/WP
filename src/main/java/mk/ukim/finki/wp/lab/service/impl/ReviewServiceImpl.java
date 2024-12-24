package mk.ukim.finki.wp.lab.service.impl;


import mk.ukim.finki.wp.lab.model.Review;
import mk.ukim.finki.wp.lab.repository.jpa.ReviewRepositoryJPA;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl {

    private final ReviewRepositoryJPA reviewRepository;

    public ReviewServiceImpl(ReviewRepositoryJPA reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public void saveReview(Review review) {
        reviewRepository.save(review);
    }
}

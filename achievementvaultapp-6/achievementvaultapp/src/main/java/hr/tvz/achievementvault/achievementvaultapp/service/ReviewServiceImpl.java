package hr.tvz.achievementvault.achievementvaultapp.service;

import hr.tvz.achievementvault.achievementvaultapp.model.Review;
import hr.tvz.achievementvault.achievementvaultapp.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> findByGameId(Long gameId) {
        return reviewRepository.findByGameId(gameId);
    }

    @Override
    public List<Review> findByGameTitle(String title) {
        return reviewRepository.findByGameTitle(title);
    }

    @Override
    public Double findAverageRatingByGameId(Long gameId) {
        return reviewRepository.findAverageRatingByGameId(gameId);
    }
}
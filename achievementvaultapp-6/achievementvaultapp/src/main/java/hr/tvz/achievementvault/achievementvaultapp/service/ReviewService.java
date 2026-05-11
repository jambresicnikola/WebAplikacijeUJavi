package hr.tvz.achievementvault.achievementvaultapp.service;

import hr.tvz.achievementvault.achievementvaultapp.model.Review;

import java.util.List;

public interface ReviewService {
    List<Review> findByGameId(Long gameId);
    List<Review> findByGameTitle(String title);
    Double findAverageRatingByGameId(Long gameId);
}
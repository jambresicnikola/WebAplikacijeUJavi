package hr.tvz.achievementvault.achievementvaultapp.controller;

import hr.tvz.achievementvault.achievementvaultapp.model.Review;
import hr.tvz.achievementvault.achievementvaultapp.service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@CrossOrigin(origins = "http://localhost:5173")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/game/{gameId}")
    public List<Review> getByGameId(@PathVariable Long gameId) {
        return reviewService.findByGameId(gameId);
    }

    @GetMapping("/game/title/{title}")
    public List<Review> getByGameTitle(@PathVariable String title) {
        return reviewService.findByGameTitle(title);
    }

    @GetMapping("/game/{gameId}/average-rating")
    public Double getAverageRating(@PathVariable Long gameId) {
        return reviewService.findAverageRatingByGameId(gameId);
    }
}
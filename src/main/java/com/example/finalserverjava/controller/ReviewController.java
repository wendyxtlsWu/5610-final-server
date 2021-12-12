package com.example.finalserverjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.finalserverjava.model.Review;
import com.example.finalserverjava.service.ReviewService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    @PostMapping("/api/pets/{petId}/reviews")
    public Review createReview(
            @PathVariable("petId") String bid,
            @RequestBody Review newReview) {
        newReview.setPetId(bid);
        return reviewService.createReview(newReview);
    }

    @GetMapping("/api/pets/{petId}/reviews")
    public List<Review> findReviewsForPet(
            @PathVariable("petId") String bid) {
        return reviewService.findReviewsForPet(bid);
    }

    @GetMapping("/api/users/{userId}/reviews")
    public List<Review> findReviewsForUsers(
            @PathVariable("userId") int uid) {
        return reviewService.findReviewsForUser(uid);
    }

    @PutMapping("/api/reviews/{reviewId}")
    public int updateReview(
            @PathVariable("reviewId") int rid,
            @RequestBody Review review
    ) {
        return reviewService.updateReview(rid, review);
    }

    @DeleteMapping("/api/reviews/{reviewId}")
    public int deleteReview(
            @PathVariable("reviewId") int rid
    ) {
        return reviewService.deleteReview(rid);
    }

//    @PostMapping("/api/reviews")
//    public List<Review> findRecentReviews() {
//        return reviewService.findRecentReviews();
//    }

    @GetMapping("/api/reviews")
    public List<Review> findRecentReviews() {
        return reviewService.findRecentReviews();
    }
}

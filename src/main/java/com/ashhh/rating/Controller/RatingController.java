package com.ashhh.rating.Controller;

import com.ashhh.rating.Entity.Rating;
import com.ashhh.rating.Service.RatingService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingService ratingservice;



    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating)
    {

        String rating_id= UUID.randomUUID().toString();
        rating.setRating_id(rating_id);
       Rating ratings= ratingservice.createRating(rating);

//        System.out.println(rating);
//        System.out.println("-----rating id----------"+ ratings.getRating_id());
//        System.out.println("----------rateing-------"+ratings.getRating());
//        System.out.println("hotel id-------------"+ratings.getHotelId());
//
//        System.out.println("user if od-------------"+ratings.getUserId());

        return new ResponseEntity<>(ratings, HttpStatus.CREATED);
    }

    @GetMapping
    private ResponseEntity<List<Rating>> getAllRating()
    {
      return  new ResponseEntity<>(ratingservice.allRating(),HttpStatus.CREATED);
    }

    @GetMapping("/user/{UserId}")
    public ResponseEntity<List<Rating>> getListByRating(@PathVariable String UserId )
    {

        return new ResponseEntity<>(ratingservice.RatingbyUser(UserId),HttpStatus.OK);
    }

    @GetMapping("/hotel/{HotelId}")
    public ResponseEntity<List<Rating>> getListByHotelId(@PathVariable String HotelId )
    {
        return new ResponseEntity<>(ratingservice.allRatingrespectiveHotel(HotelId),HttpStatus.OK);
    }


}

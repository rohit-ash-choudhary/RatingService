package com.ashhh.rating.Service;

import com.ashhh.rating.Entity.Rating;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RatingService {

    //create rating

    public Rating createRating(Rating rating);


    //all rating by user

    public List<Rating>  RatingbyUser(String UserId);


    //get all rating

    public List<Rating> allRating();

    //get rating for hotel

    public List<Rating> allRatingrespectiveHotel(String HotelId);

}

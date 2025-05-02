package com.ashhh.rating.Service.Impl;

import com.ashhh.rating.Entity.Rating;
import com.ashhh.rating.Repository.RatingRepository;
import com.ashhh.rating.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RatingServiceImpl  implements RatingService {

    @Autowired
    private RatingRepository ratingrepository;

    @Override
    public Rating createRating(Rating rating) {
    //   System.out.println( "------hotel id in service layer----------"+rating.getHotelId());
        return ratingrepository.save(rating);
    }

    @Override
    public List<Rating> RatingbyUser(String UserId) {
       return ratingrepository.findByUserId(UserId);
    }

    @Override
    public List<Rating> allRating() {
        return ratingrepository.findAll();
    }

    @Override
    public List<Rating> allRatingrespectiveHotel(String HotelId) {


       return ratingrepository.findByHotelId(HotelId);
    }
}

package com.example.demo.Tweet;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TweetService {

    @Autowired
    TweetRepository tweetRepository;

    List<Tweet> fetchAllTweet(){
        return this.tweetRepository.findAll();
    }

    Optional<Tweet> fetchById(String id){
        return this.tweetRepository.findById(id);
    }

    Tweet saveTweet(Tweet tweet){
        return tweetRepository.save(tweet);
    }
}

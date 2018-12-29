package com.example.demo.Tweet;


import com.example.demo.User.Client;
import com.example.demo.User.UserRepository;
import com.example.demo.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Configurable
public class TweetService {

    @Autowired
    TweetRepository tweetRepository;

    @Autowired
    UserService userService;

    List<Tweet> fetchAllTweet(){
        return this.tweetRepository.findAll();
    }

    Optional<Tweet> fetchById(String id){
        return this.tweetRepository.findById(id);
    }

    Tweet saveTweet(Tweet tweet,String name){
        Client clientResult = userService.fetchByName(name);
        Tweet result = new Tweet(tweet.getTweetMessage(),clientResult);

        return tweetRepository.save(result);
    }
}

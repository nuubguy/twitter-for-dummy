package com.example.demo.Tweet;

import com.example.demo.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tweet")
public class TweetController {

    @Autowired
    TweetService tweetService;

    @Autowired
    UserService userService;

    @GetMapping
    public List<Tweet> fetchSomething(){
        return tweetService.fetchAllTweet();
    }

    @PostMapping
    public Tweet saveUser(@RequestBody Tweet tweet,String userId){
        return tweetService.saveTweet(tweet);
    }


}

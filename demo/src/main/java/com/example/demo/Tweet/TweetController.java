package com.example.demo.Tweet;

import com.example.demo.User.Client;
import com.example.demo.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tweet")
public class TweetController {

    @Autowired
    private TweetService tweetService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<Tweet> fetchSomething(){
        return tweetService.fetchAllTweet();
    }

    @PostMapping("/{username}")
    public ResponseEntity saveTweet(@RequestBody Tweet tweet, @PathVariable String username){
        return new ResponseEntity(tweetService.saveTweet(tweet,username), HttpStatus.ACCEPTED);

    }


}

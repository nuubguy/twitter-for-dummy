package com.example.demo.Follow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/follow")
public class FollowController {

    @Autowired
    private FollowService followService;

    @PostMapping("/{username}/{userfollow}")
    public ResponseEntity saveFollow(@PathVariable String username, @PathVariable String userfollow){
        return new ResponseEntity(followService.followSomeone(username,userfollow), HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity fetchAllFollower(){
        return new ResponseEntity(followService.fetchAll(),HttpStatus.OK);
    }

}

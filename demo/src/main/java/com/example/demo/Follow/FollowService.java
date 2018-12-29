package com.example.demo.Follow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowService {

    @Autowired
    private FollowRepository followRepository;

    Follower followSomeone(String username, String followUsername){
        Follower follow = new Follower(new CompoundKey(username,followUsername));

        return followRepository.save(follow);
    }

    List<Follower> fetchAll(){
        return followRepository.findAll();
    }

}

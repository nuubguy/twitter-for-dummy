package com.example.demo.Tweet;

import com.example.demo.User.Client;

import javax.persistence.*;


@Entity
public class Tweet {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String tweetId;

    @Column
    String tweetMessage;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userId", nullable = false)
    private Client client;

    public Tweet(){}

    public Tweet(String tweetMessage, Client useruserId) {
        this.tweetMessage = tweetMessage;
        this.client = useruserId;
    }

    public String getTweetId() {
        return tweetId;
    }

    public void setTweetId(String tweetId) {
        this.tweetId = tweetId;
    }

    public String getTweetMessage() {
        return tweetMessage;
    }

    public void setTweetMessage(String tweetMessage) {
        this.tweetMessage = tweetMessage;
    }

    

    public Tweet(String tweetMessage) {
        this.tweetMessage = tweetMessage;
    }
}

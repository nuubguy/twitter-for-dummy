package com.example.demo.User;

import com.example.demo.Party.Party;
import com.example.demo.Tweet.Tweet;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.*;

@Entity
public class Client {

    @Id
    private String userId;

    @Column
    @NotNull
    private String name;

    @Column
    private String message;

    @Column
    private LocalDateTime joinDate;


    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "group_detail", joinColumns = {
            @JoinColumn(name = "userId", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "partyid", nullable = false, updatable = false) })
    private Set<Party> party = new HashSet<Party>(0);



    public Client(){}

    public Client(String userId, String name, String message) {
        this.userId = userId;
        this.name = name;
        this.message = message;
        this.joinDate = LocalDateTime.now();
    }

    public Set<Party> getParty() {
        return party;
    }

    public void setParty(Set<Party> party) {
        this.party = party;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDateTime joinDate) {
        this.joinDate = joinDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

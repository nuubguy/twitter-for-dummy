package com.example.demo.Follow;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Follower {

    @Id
    CompoundKey compoundKey;

    public Follower() {
    }

    public Follower(CompoundKey compoundKey) {
        this.compoundKey = compoundKey;
    }

    public CompoundKey getCompoundKey() {
        return compoundKey;
    }

    public void setCompoundKey(CompoundKey compoundKey) {
        this.compoundKey = compoundKey;
    }
}

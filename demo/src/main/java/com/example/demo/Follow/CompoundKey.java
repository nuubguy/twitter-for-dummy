package com.example.demo.Follow;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CompoundKey implements Serializable {


    private String userid;
    private String followid;

    public CompoundKey() {
    }

    public CompoundKey(String userid, String followid) {
        this.userid = userid;
        this.followid = followid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getFollowid() {
        return followid;
    }

    public void setFollowid(String followid) {
        this.followid = followid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompoundKey that = (CompoundKey) o;
        return userid.equals(that.userid) &&
                followid.equals(that.followid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, followid);
    }
}

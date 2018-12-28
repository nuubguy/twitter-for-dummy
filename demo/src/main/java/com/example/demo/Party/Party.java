package com.example.demo.Party;

import com.example.demo.User.Client;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Party {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int partyid;

    @Column
    String partyname;

    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "party")
    private Set<Client> clients = new HashSet<Client>(0);

    public Party() {
    }

    public Party(String partyName) {
        partyname = partyName;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public int getPartyid() {
        return partyid;
    }

    public void setPartyid(int partyid) {
        this.partyid = partyid;
    }

    public String getPartyname() {
        return partyname;
    }

    public void setPartyname(String partyname) {
        this.partyname = partyname;
    }
}

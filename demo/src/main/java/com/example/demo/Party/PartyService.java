package com.example.demo.Party;


import com.example.demo.User.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PartyService {

    @Autowired
    PartyRepository partyRepository;

    List<Party> fetchAll(){
        return partyRepository.findAll();
    }

    Set<Client> fetchAlluserBasedOnGroup(String groupName){
        Party result = fetchByName(groupName);
        return result.getClients();
    }

    Party fetchByName(String name){
        return partyRepository.fetchByGroupName(name);
    }

    Party saveParty(Party party){
        return partyRepository.save(party);
    }
}

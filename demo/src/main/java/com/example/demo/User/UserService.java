package com.example.demo.User;

import com.example.demo.Party.Party;
import com.example.demo.Party.PartyRepository;
import com.example.demo.Party.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Configurable
@Component
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PartyRepository partyRepository;



    Client joinParty(String partyName, String username){
          Party result = partyRepository.fetchByGroupName(partyName);
          Client member = userRepository.fetchByName(username);

        Set<Party> resultParty = member.getParty();
        resultParty.add(result);

        member.setParty(resultParty);

        member = userRepository.save(member);

        return member;
    }

    Set<Party> findAllGroupOnUser(String username){
           return userRepository.fetchByName(username).getParty();
    }

    List<Client> fetchAllUser(){
        return this.userRepository.findAll();
    }

    Optional<Client> fetchById(String id){
        return this.userRepository.findById(id);
    }

    List<Client> fetchByName2(String name){
        List<Client> result =userRepository.fetchByName2(name, PageRequest.of(0,2));
        return result;
    }
    public Client fetchByName(String name){
        Client result =userRepository.fetchByName(name);

        return result;
    }


    public Client saveUser(Client client){
        return userRepository.save(client);
    }
}

package com.example.demo.Party;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/party")
public class PartyController {

    @Autowired
    private PartyService partyService;


    @GetMapping
    public ResponseEntity fetchSomething(){
        return new ResponseEntity(partyService.fetchAll(),HttpStatus.OK) ;
    }

    @GetMapping("/find")
    public ResponseEntity fetchSomethingOnlyOne(@RequestParam(value="groupname") String groupname){
        return new ResponseEntity(partyService.fetchByName(groupname),HttpStatus.OK);
    }

    @GetMapping("/find/{groupname}")
    public ResponseEntity fetchUserBasedOnGroupName(@PathVariable String groupname){
        return new ResponseEntity(partyService.fetchAlluserBasedOnGroup(groupname),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveUser(@RequestBody Party party){
        return new ResponseEntity(partyService.saveParty(party),HttpStatus.ACCEPTED);
    }


}

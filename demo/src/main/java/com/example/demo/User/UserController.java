package com.example.demo.User;


import org.h2.engine.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping
    public List<Client> fetchSomething(){
        return userService.fetchAllUser();
    }

    @GetMapping("/{name}")
    public ResponseEntity fetchByName(@PathVariable String name){
        Client result = userService.fetchByName(name);

        return new ResponseEntity(result,HttpStatus.OK);
    }

    @GetMapping("/find/{name}")
    public ResponseEntity fetchAllGroupBasedOnName(@PathVariable String name){
        return new ResponseEntity(userService.findAllGroupOnUser(name),HttpStatus.OK);
    }

    @PostMapping("/party")
    public ResponseEntity joinParty(@RequestParam(value="partyname") String partyname,
                                    @RequestParam(value="username") String username){
        return new ResponseEntity(userService.joinParty(partyname,username),HttpStatus.ACCEPTED);
    }

    @GetMapping("/test")
    public ResponseEntity test(){
        return new ResponseEntity(userService.fetchByName2("sakura"),HttpStatus.OK);
    }

    @PostMapping
    public Client saveUser(@RequestBody Client client){
        return userService.saveUser(client);
    }


}

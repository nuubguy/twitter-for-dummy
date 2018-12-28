package com.example.demo.User;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Client,String> {


    @Query(value = "SELECT * FROM Client WHERE name = ?1", nativeQuery = true)
    Client fetchByName(String name);

    @Query(value = "SELECT * FROM Client WHERE name = ?1", nativeQuery = true)
    List<Client> fetchByName2(String name, Pageable pageable);


}

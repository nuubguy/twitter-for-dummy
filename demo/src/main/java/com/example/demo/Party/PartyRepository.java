package com.example.demo.Party;

import com.example.demo.User.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyRepository extends JpaRepository<Party,String> {

    @Query(value = "SELECT * FROM Party WHERE partyname = ?1", nativeQuery = true)
    Party fetchByGroupName(String groupName);

}
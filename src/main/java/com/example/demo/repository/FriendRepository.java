package com.example.demo.repository;

import com.example.demo.models.Friends;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendRepository extends CrudRepository<Friends, Long> {

    List<Friends> findFriendsByUserId(long userId);

    Friends findByFriendId(long friendId);

    Boolean existsByFriendId(long friendId);

}

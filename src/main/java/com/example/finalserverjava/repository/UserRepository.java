package com.example.finalserverjava.repository;

import com.example.finalserverjava.model.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    @Query("SELECT user FROM User user WHERE user.username=:username AND user.password=:password")
    public User findUserByCredentials(
//            to bind method parameters to a query via a named parameter
//            pass the value in parameter username(of the function) through @Param annotation to @Query
            @Param("username") String username,
            @Param("password") String password
    );

    @Query("SELECT user from User user WHERE user.userId=:userId")
    public User findUserById(@Param("userId") int uid);

    @Query("SELECT user from User user WHERE user.username=:username")
    public User findUserByUsername(@Param("username") String username);

    @Query(value="SELECT user.id, user.username FROM user ORDER BY user.id DESC LIMIT 10", nativeQuery=true)
    public List<Object[]> findRecentlyJoinedUsers();

    @Query(value="SELECT user FROM User user WHERE user.userId=:userId")
    public User getProfileForUser(@Param("userId") int userId);
}

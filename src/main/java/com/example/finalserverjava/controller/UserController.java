package com.example.finalserverjava.controller;

import com.example.finalserverjava.model.User;
import com.example.finalserverjava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@RestController
@CrossOrigin(origins = {"http://localhost:3000"}, allowCredentials = "true")
public class UserController {
    @Autowired
    UserRepository repository;

    // controller for logout
    @PostMapping("/logout")
    public void logout(HttpSession session) {
        session.invalidate();
    }


    // controller for login
    @PostMapping("/login")
    public User login(HttpSession session,
                      @RequestBody User user,
                      HttpServletResponse res) {
        // fetch the profile of the logged-in user
        User profile = repository.findUserByCredentials(user.getUsername(), user.getPassword());
        // store profile into session
        if (profile != null) {
            session.setAttribute("profile", profile);
            return profile;
        } else { // if no such profile
            res.setStatus(403);
            return null;
        }
    }

    // controller for register
    @PostMapping("/register")
    public User register(HttpSession session,
                         @RequestBody User user,
                         HttpServletResponse res) throws IOException {

        // check if username exists
        if (repository.findUserByUsername(user.getUsername()) != null) {
            // bad request
            // res.sendError(400, "username already exists");
//            System.out.println("username " + user.getUsername() + " already exists");
            res.setStatus(400);
            return null;
        }

        // create a new user with req info
        User newUser = repository.save(user);
        //
        newUser.setPassword(null);
        // store the current user's info into session for future retrieve
        session.setAttribute("profile", newUser);
        return newUser;
    }

    @PostMapping("/profile")
    public User profile(HttpSession session, HttpServletResponse res) {
        User profile = (User) session.getAttribute("profile");
        if (profile != null)
            return profile;
        else {
            res.setStatus(403);
            return null;
        }
    }

    @GetMapping("/profile/{userId}")
    public User getProfileForUser(@PathVariable("userId") int uid) {
        User profile = repository.getProfileForUser(uid);
        profile.setPassword("***");
        return profile;
    }

    @GetMapping("/users")
    public List<Object[]> findRecentlyJoinedUsers() {
        return repository.findRecentlyJoinedUsers();
    }

    @PutMapping("/api/users/{userId}")
    public int updateProfile(
            @PathVariable("userId") int uid,
            @RequestBody User user,
            HttpSession session) {
        User oldUser = repository.findUserById(uid);
        oldUser.setUsername(user.getUsername());
        oldUser.setZipCode(user.getZipCode());
        oldUser.setEmail(user.getEmail());
        repository.save(oldUser);
        session.setAttribute("profile", oldUser);
        return 1;
    }
}

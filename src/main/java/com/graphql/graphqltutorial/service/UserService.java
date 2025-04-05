package com.graphql.graphqltutorial.service;


import com.graphql.graphqltutorial.entity.User;
import com.graphql.graphqltutorial.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // createUser
    public User createUser(User user) {
        return userRepository.save(user);
    }

    //getAllUser
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    //getUserById
    public  User getUserById(Integer id){
        return userRepository.findById(id).orElseThrow(()-> new RuntimeException("User id not exist"));
    }

    //deleteUser
    public boolean deleteUser(Integer id){
        User user=userRepository.findById(id).orElseThrow(()->new RuntimeException("User id not exist,enter existing id to delete"));
        userRepository.delete(user);
        return true;
    }

}

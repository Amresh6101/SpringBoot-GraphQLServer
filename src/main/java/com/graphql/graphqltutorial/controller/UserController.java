package com.graphql.graphqltutorial.controller;

import com.graphql.graphqltutorial.entity.User;
import com.graphql.graphqltutorial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // createUser
    @MutationMapping
    public User createUser(@Argument String name,@Argument String address,@Argument String email,@Argument String password, @Argument String phoneNumber){
        User user1=new User();
        user1.setName(name);
        user1.setAddress(address);
        user1.setEmail(email);
        user1.setPassword(password);
        user1.setPhoneNumber(phoneNumber);

        return userService.createUser(user1);
    }

  //  createUser(name: String, address: String,email: String,password: String,phoneNumber:String): User
    // name must be same from controller and .graphqls me like here createUser if name is different use name inside annotation

    //getAllUsers
    @QueryMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    //getUserById
    // QueryMapping and MutationMapping the alternative hai schemaMapping
    @SchemaMapping(typeName = "Query",field = "getUserById")
    public User getUserById(@Argument Integer id){
        return userService.getUserById(id);
    }

    //deleteUser
    @MutationMapping
    public Boolean deleteUser(@Argument Integer id){
        return userService.deleteUser(id);
    }
}

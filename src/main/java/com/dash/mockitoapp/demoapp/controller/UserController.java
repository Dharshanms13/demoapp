package com.dash.mockitoapp.demoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dash.mockitoapp.demoapp.dto.UserDto;
import com.dash.mockitoapp.demoapp.model.User;
import com.dash.mockitoapp.demoapp.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    List<User> getUsers(){
        return  userService.getAll();
    }

    @PostMapping("/addUser")
    User addUser(@RequestBody UserDto userDto){
        User user = userService.addUser(userDto);
        return user;
    }

    @GetMapping("/getUserById/{id}")
    User getUserById(@PathVariable Long id){
        User user = userService.getUserById(id);
        return user;
    }

    @PutMapping("/updateUser/{id}")
    User updateUser(@PathVariable Long id, @RequestBody UserDto userDto){
        User user = getUserById(id);
        user.setName(userDto.getName());
        user.setAddress(userDto.getAddress());
        userService.updateUser(user);
        return user;
    }

    @DeleteMapping("/deleteUser/{id}")
    User deleteUser(@PathVariable Long id){
        User user = getUserById(id);
        userService.deleteUserById(id);
        return user;
    }

    @GetMapping("/getUsersByAddress/{address}")
    List<User> getUsersByaddress(@PathVariable String address){
        List<User> userList = userService.getUsersByaddress(address);
        return userList;
    }
}

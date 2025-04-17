package com.dash.mockitoapp.demoapp.service;

import java.util.List;

import com.dash.mockitoapp.demoapp.dto.UserDto;
import com.dash.mockitoapp.demoapp.model.User;

public interface UserService {

	List<User> getAll();

	User addUser(UserDto userDto);

	User getUserById(Long id);

    void updateUser(User user);

	void deleteUserById(Long id);

	List<User> getUsersByaddress(String address);

}

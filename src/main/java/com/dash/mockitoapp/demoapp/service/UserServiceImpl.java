package com.dash.mockitoapp.demoapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dash.mockitoapp.demoapp.dto.UserDto;
import com.dash.mockitoapp.demoapp.model.User;
import com.dash.mockitoapp.demoapp.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;

	@Override
	public List<User> getAll() {
		return userRepo.findAll();
	}

	@Override
	public User addUser(UserDto userDto) {
        User user = new User(userDto.getName(), userDto.getAddress());
		userRepo.save(user);
        return user;
	}

	@Override
	public User getUserById(Long id) {
		return userRepo.findById(id).get();
	}

	@Override
	public void updateUser(User user) {
		userRepo.save(user);
	}

	@Override
	public void deleteUserById(Long id) {
		userRepo.deleteById(id);
	}

	@Override
	public List<User> getUsersByaddress(String address) {
		List<User> userList = userRepo.getUsersByaddress(address);
		return userList;
	}

}

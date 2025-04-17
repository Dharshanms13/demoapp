package com.dash.mockitoapp.demoapp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Objects;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.dash.mockitoapp.demoapp.model.User;
import com.dash.mockitoapp.demoapp.repo.UserRepo;
import com.dash.mockitoapp.demoapp.service.UserService;
import com.dash.mockitoapp.demoapp.service.UserServiceImpl;

@SpringBootTest
class DemoappApplicationTests {

	@Mock
	private UserRepo userRepo;

	@InjectMocks
	private UserServiceImpl userServiceImpl;

	// @Test
	// void contextLoads() {
	// }

	@Test
	public void getAllUserTest(){

		List<User> userList = List.of(new User("Rakshith", "Address"), new User("Vivek", "Mysuru"));

		when(userRepo.findAll()).thenReturn(userList);

		assertThat(Objects.nonNull(userServiceImpl.getAll()));
		assertEquals(2, userServiceImpl.getAll().size());
	}

	@Test
	public void getUsersByaddressTest(){
		String address = "Mysuru";
		List<User> userList = List.of(new User("Rakshith", "Address"));

		when(userRepo.getUsersByaddress(address)).thenReturn(userList);

		assertEquals(1, userServiceImpl.getUsersByaddress(address).size());
	}

}

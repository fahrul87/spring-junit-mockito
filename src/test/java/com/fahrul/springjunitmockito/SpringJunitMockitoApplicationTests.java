package com.fahrul.springjunitmockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.fahrul.springjunitmockito.dao.UserRepository;
import com.fahrul.springjunitmockito.model.User;
import com.fahrul.springjunitmockito.service.UserService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringJunitMockitoApplicationTests {
	
	@Autowired
	private UserService service;
	
	@MockBean
	private UserRepository repository;


	@Test
	public void getUsersTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new User(3641, "fahrull", 33, "INA"), new User(3642, "arka", 3, "INA")).collect(Collectors.toList()));
		assertEquals(2, service.getUsers().size());
	}

	@Test
	public void getUserbyAddressTest() {
		String address = "Malang";
		when(repository.findByAddress(address))
				.thenReturn(Stream.of(new User(3641, "fahrull", 33, "INA")).collect(Collectors.toList()));
		assertEquals(1, service.getUserByAddress(address).size());
	}

	@Test
	public void saveUserTest() {
		User user = new User(999, "azriel", 2, "Surabaya");
		when(repository.save(user)).thenReturn(user);
		assertEquals(user, service.addUser(user));
	}

	@Test
	public void deleteUserTest() {
		User user = new User(999, "azriel", 2, "Surabaya");
		service.deleteUser(user);
		verify(repository, times(1)).delete(user);
	}

}

package com.abc.cowin1.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.abc.cowin1.entity.UserEntity;
import com.abc.cowin1.exception.UserNotFoundException;
import com.abc.cowin1.model.User;
import com.abc.cowin1.repository.UserRepository;
import com.abc.cowin1.util.EntityModelUtil;

@SpringBootTest(classes = UserServiceTest.class)
public class UserServiceTest {

	@InjectMocks
	private UserService userService = new UserServiceImpl();

	@Mock
	private UserRepository userRepository;

	@Mock
	private EntityModelUtil entityModelUtil;

	@Before(value = "")
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testSaveUser() {

		UserEntity user = new UserEntity();

		user.setAddress("Bandra");
		user.setAge(23);
		user.setAppointmnetId(12);
		user.setCenterId(69);
		user.setCity("Mumbai");
		user.setDistrict("Mumbai");
		user.setIdproof("7819 5080 9074");
		user.setMobile("7890776545");
		user.setPincode("876609");
		user.setState("Maharashtra");
		user.setUserId(0);
		user.setUserName("Abhishek");

		User user1 = new User();
		user1.setAddress("Bandra");
		user1.setAge(23);
		user1.setAppointmentId(12);
		user1.setCenterId(69);
		user1.setCity("Mumbai");
		user1.setDistrict("Mumbai");
		user1.setIdproof("7819 5080 9074");
		user1.setMobile("7890776545");
		user1.setPincode("876609");
		user1.setState("Maharashtra");
		user1.setUserId(29);
		user1.setUserName("Abhishek");

		when(entityModelUtil.userModelToEntity(user1)).thenReturn(user);
		when(entityModelUtil.userEntityToModel(user)).thenReturn(user1);
		when(userRepository.save(user)).thenReturn(user);

		assertEquals(user1.getAppointmentId(), user.getAppointmentId());

	}

	@Test
	public void testGetUserByIdNotFound() {

		int userId = 200;

		when(userRepository.findById(userId)).thenThrow(UserNotFoundException.class);

		assertThrows(UserNotFoundException.class, () -> userService.getUserById(userId));

	}

	@Test
	public void testGetUserDetails() {

		UserEntity user = new UserEntity();

		user.setAddress("Bandra");
		user.setAge(23);
		user.setAppointmnetId(12);
		user.setCenterId(69);
		user.setCity("Mumbai");
		user.setDistrict("Mumbai");
		user.setIdproof("7819 5080 9074");
		user.setMobile("7890776545");
		user.setPincode("876609");
		user.setState("Maharashtra");
		user.setUserId(29);
		user.setUserName("Abhishek");

		User user1 = new User();
		user1.setAddress("Bandra");
		user1.setAge(23);
		user1.setAppointmentId(12);
		user1.setCenterId(69);
		user1.setCity("Mumbai");
		user1.setDistrict("Mumbai");
		user1.setIdproof("7819 5080 9074");
		user1.setMobile("7890776545");
		user1.setPincode("876609");
		user1.setState("Maharashtra");
		user1.setUserId(29);
		user1.setUserName("Abhishek");

		when(entityModelUtil.userModelToEntity(user1)).thenReturn(user);
		when(entityModelUtil.userEntityToModel(user)).thenReturn(user1);

		Optional<UserEntity> optionalUser = Optional.of(user);
		int userId = 29;

		when(entityModelUtil.userModelToEntity(user1)).thenReturn(user);
		when(entityModelUtil.userEntityToModel(user)).thenReturn(user1);

		when(userRepository.findById(29)).thenReturn(optionalUser);

		User existingUser = userService.getUserDetails(userId);

		assertEquals(user.getAddress(), existingUser.getAddress());

	}

	@Test
	public void testDeleteUser() {

		int userId = 29;

		UserEntity user = new UserEntity();

		user.setAddress("Bandra");
		user.setAge(23);
		user.setAppointmnetId(12);
		user.setCenterId(69);
		user.setCity("Mumbai");
		user.setDistrict("Mumbai");
		user.setIdproof("7819 5080 9074");
		user.setMobile("7890776545");
		user.setPincode("876609");
		user.setState("Maharashtra");
		user.setUserId(29);
		user.setUserName("Abhishek");

		Optional<UserEntity> optional = Optional.of(user);

		when(userRepository.findById(29)).thenReturn(optional);

		userService.deleteUser(user.getUserId());

		verify(userRepository, times(1)).deleteById(userId);
	}

}

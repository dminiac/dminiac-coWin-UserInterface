package com.abc.cowin1.util;

import org.springframework.stereotype.Component;

import com.abc.cowin1.entity.UserEntity;
import com.abc.cowin1.model.User;

@Component
public class EntityModelUtil {

	public UserEntity userModelToEntity(User user) {

		UserEntity userEntity = new UserEntity();
		userEntity.setUserId(user.getUserId());
		userEntity.setUserName(user.getUserName());
		userEntity.setAddress(user.getAddress());
		userEntity.setCity(user.getCity());
		userEntity.setDistrict(user.getDistrict());
		userEntity.setState(user.getState());
		userEntity.setPincode(user.getPincode());
		userEntity.setMobile(user.getMobile());
		userEntity.setAge(user.getAge());
		userEntity.setIdproof(user.getIdproof());
		userEntity.setAppointmnetId(user.getAppointmentId());

		return userEntity;
	}

	public User userEntityToModel(UserEntity userEntity) {

		User user = new User();
		user.setUserId(userEntity.getUserId());
		user.setUserName(userEntity.getUserName());
		user.setAddress(userEntity.getAddress());
		user.setCity(userEntity.getCity());
		user.setDistrict(userEntity.getDistrict());
		user.setState(userEntity.getState());
		user.setPincode(userEntity.getPincode());
		user.setMobile(userEntity.getMobile());
		user.setAge(userEntity.getAge());
		user.setIdproof(userEntity.getIdproof());
		user.setAppointmentId(userEntity.getAppointmentId());

		return user;
	}

}

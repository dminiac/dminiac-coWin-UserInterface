package com.abc.cowin1.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.cowin1.entity.UserEntity;
import com.abc.cowin1.exception.UserNotFoundException;
import com.abc.cowin1.model.Appointment;
import com.abc.cowin1.model.Details;
import com.abc.cowin1.model.User;
import com.abc.cowin1.model.VaccinationCenter;
import com.abc.cowin1.repository.UserRepository;
import com.abc.cowin1.util.EntityModelUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AppointmentService appointmentService;

	@Autowired
	private VaccinationCenterService vaccinationCenterService;
	
	@Autowired
	private EntityModelUtil entityModelUtil;

	@Override
	// Get user by ID
	public Details getUserById(int userId) {
		Optional<UserEntity> optionalUser = userRepository.findById(userId);

		Details details = new Details();

		if (optionalUser.isEmpty()) {
			throw new UserNotFoundException("Sorry ! User is not available with id :" + userId);

		}

		UserEntity userEntity = optionalUser.get();
		details.setUser(entityModelUtil.userEntityToModel(userEntity));
		Appointment appointment = appointmentService.getAppointmentDetails(userEntity.getAppointmentId());
		details.setAppointment(appointment);

		VaccinationCenter vaccinationCenter = vaccinationCenterService.getVaccinationCenterDetails(userId);
		details.setVaccinationCenter(vaccinationCenter);

		return details;
	}

	@Override
	// To add user
	public User addUser(User user) {
		UserEntity userEntity = userRepository.save(entityModelUtil.userModelToEntity(user));
		return entityModelUtil.userEntityToModel(userEntity);
	}

	@Override
	// delete user
	public void deleteUser(int userId) {
		Optional<UserEntity> optionalUserEntity = userRepository.findById(userId);

		if (optionalUserEntity.isPresent()) {

			userRepository.deleteById(userId);
			System.out.println("Deleted the user with Id" + userId);
		} else {

			throw new UserNotFoundException("Sorry! User is not existing with id: " + userId);
		}
	}

	@Override
	// Update user
	public User updateUser(User user) {
		Optional<UserEntity> optionalUserEntity = userRepository.findById(user.getUserId());

		if (optionalUserEntity.isEmpty()) {
			throw new UserNotFoundException("Sorry! User is not existing with id: " + user.getUserId());
		}

		UserEntity updatedUserEntity = userRepository.save(entityModelUtil.userModelToEntity(user));
		System.out.println("Updated the user details");

		return entityModelUtil.userEntityToModel(updatedUserEntity);
	}

	@Override
	// get Appointment details
	public Appointment getAppointmentDetails(int appointmentId) {
		Appointment appointment = appointmentService.getAppointmentDetails(appointmentId);
		return appointment;

	}

	@Override
	// get VaccinationCenter details
	public VaccinationCenter getVaccinationCenterDetails(int vaccinationCenterId) {
		VaccinationCenter vaccinationCenter = vaccinationCenterService.getVaccinationCenterDetails(vaccinationCenterId);
		return vaccinationCenter;
	}

	@Override
	//get User details
	public User getUserDetails(int userId) throws UserNotFoundException {

		Optional<UserEntity> optionalUserEntity = userRepository.findById(userId);
		if (optionalUserEntity.isEmpty()) {
			throw new UserNotFoundException("Sorry User is not found with id" + userId);
		}
		return entityModelUtil.userEntityToModel(optionalUserEntity.get());
	}

}

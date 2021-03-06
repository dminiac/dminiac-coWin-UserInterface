package com.abc.cowin1.service;

import com.abc.cowin1.model.Appointment;
import com.abc.cowin1.model.Details;
import com.abc.cowin1.model.User;
import com.abc.cowin1.model.VaccinationCenter;

public interface UserService {

	public Details getUserById(int userId); // only can view his own details

	public User addUser(User user); // add user

	public void deleteUser(int userId); // delete user

	public User updateUser(User user); // update user
	
	public User getUserDetails(int userId); //get userdetails

	public Appointment getAppointmentDetails(int appointmentId); // get appointmentdetails

	public VaccinationCenter getVaccinationCenterDetails(int vaccinationCenterId); // get VaccinationCenterdetails

}

package com.abc.cowin1.controller;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.cowin1.model.Appointment;
import com.abc.cowin1.model.Details;
import com.abc.cowin1.model.User;
import com.abc.cowin1.model.VaccinationCenter;
import com.abc.cowin1.service.AppointmentService;
import com.abc.cowin1.service.UserService;
import com.abc.cowin1.service.VaccinationCenterService;

@RestController
@RequestMapping("/user")
public class UserController {

//	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private AppointmentService appointmentService;

	@Autowired
	private VaccinationCenterService vaccinationCenterService;

	@GetMapping("/get/{userId}")
	public ResponseEntity<?> fetchProductDetails(@PathVariable("userId") int userId) {
		Details user = userService.getUserById(userId);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		// logger.debug("");
		User newUser = userService.addUser(user);
		ResponseEntity<User> responseEntity = new ResponseEntity<>(newUser, HttpStatus.CREATED);
		return responseEntity;

	}

	@DeleteMapping("/delete/{uid}")
	public ResponseEntity<?> deleteUser(@PathVariable("uid") int userId) {
		userService.deleteUser(userId);
		return new ResponseEntity<>("User Deleted with id: " + userId, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<User> modifyUser(@RequestBody User user) {
		User updatedUser = userService.updateUser(user);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}

	@GetMapping("/getbyappointmentId/{appId}")
	public Appointment fetchAppointmentById(@PathVariable("appId") int appointmentId) {
		Appointment appointment = appointmentService.getAppointmentDetails(appointmentId);
		return appointment;
	}

	@GetMapping("/getbyvaccinationcenterId/{vaccinationCenterId}")
	public VaccinationCenter fetchVaccinationCenterbyId(@PathVariable("vaccinationCenterId") int vaccinationCenterId) {
		VaccinationCenter vaccinationCenter = vaccinationCenterService.getVaccinationCenterDetails(vaccinationCenterId);
		return vaccinationCenter;
	}

	@GetMapping("/getuserdetails/{id}")
	public ResponseEntity<?> fetchUser(@PathVariable("id") int userId) {
		User user = userService.getUserDetails(userId);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

}

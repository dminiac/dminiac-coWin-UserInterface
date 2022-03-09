package com.abc.cowin1.model;

import java.time.LocalDate;

public class Appointment {

	private int appointmentId;

	private String type_of_vaccine;

	private LocalDate date_of_appointment;

	private int centerId;

	private int dose_number;

	private int userId;

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getType_of_vaccine() {
		return type_of_vaccine;
	}

	public void setType_of_vaccine(String type_of_vaccine) {
		this.type_of_vaccine = type_of_vaccine;
	}

	public LocalDate getDate_of_appointment() {
		return date_of_appointment;
	}

	public void setDate_of_appointment(LocalDate date_of_appointment) {
		this.date_of_appointment = date_of_appointment;
	}

	public int getCenterId() {
		return centerId;
	}

	public void setCenterId(int centerId) {
		this.centerId = centerId;
	}

	public int getDose_number() {
		return dose_number;
	}

	public void setDose_number(int dose_number) {
		this.dose_number = dose_number;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}

package com.abc.cowin1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_tbl")
public class UserEntity {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int userId;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "age")
	private int age;

	@Column(name = "mobile", length = 10)
	private String mobile;

	@Column(name = "address")
	private String address;

	@Column(name = "state")
	private String state;

	@Column(name = "district")
	private String district;

	@Column(name = "City")
	private String city;

	@Column(name = "pincode")
	private String pincode;

	@Column(name = "id_proof")
	private String idproof;

	@Column(name = "appointmentId")
	private int appointmentId;

	@Column(name = "centerId")
	private int centerId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getIdproof() {
		return idproof;
	}

	public void setIdproof(String idproof) {
		this.idproof = idproof;
	}

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmnetId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public int getCenterId() {
		return centerId;
	}

	public void setCenterId(int centerId) {
		this.centerId = centerId;
	}

}

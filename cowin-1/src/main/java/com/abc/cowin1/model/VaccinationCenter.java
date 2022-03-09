package com.abc.cowin1.model;

public class VaccinationCenter {

	private int centerId;

	private String centerName;

	private String vState;

	private String vDistrict;

	private int vPincode;

	public int getCenterId() {
		return centerId;
	}

	public void setCenterId(int centerId) {
		this.centerId = centerId;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public String getvState() {
		return vState;
	}

	public void setvState(String vState) {
		this.vState = vState;
	}

	public String getvDistrict() {
		return vDistrict;
	}

	public void setvDistrict(String vDistrict) {
		this.vDistrict = vDistrict;
	}

	public int getvPincode() {
		return vPincode;
	}

	public void setvPincode(int vPincode) {
		this.vPincode = vPincode;
	}

}

package com.abc.cowin1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.abc.cowin1.model.VaccinationCenter;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class VaccinationCenterService {

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "VaccinationCenterServiceFallBack")
	public VaccinationCenter getVaccinationCenterDetails(int centerId) {

		String resourceUrl = "https://localhost:8081/ecom/product/get" + centerId;

		VaccinationCenter VaccinationCenter = restTemplate.getForObject(resourceUrl, VaccinationCenter.class);

		return VaccinationCenter;

	}

	@SuppressWarnings("unused")
	private VaccinationCenter VaccinationCenterServiceFallBack(int centerId) {

		VaccinationCenter vaccinationCenter = new VaccinationCenter();
		vaccinationCenter.setCenterId(centerId);
		vaccinationCenter.setCenterName("");
		vaccinationCenter.setvDistrict("");
		vaccinationCenter.setvPincode(0);
		vaccinationCenter.setvState("");

		System.out.println("VaccinationCenter Service is down!!! fallback route enabled...");
		return vaccinationCenter;

	}

}

package com.CarBooking.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.CarBooking.Entity.CarInfo;
import com.CarBooking.Service.CarInfoService;

@RestController
public class CarInfoController {
	
	@Autowired
	private CarInfoService carInfoService;
	
	@PostMapping("/saveCars")
	public CarInfo saveCars(@RequestBody CarInfo carInfo)
	{
		return carInfoService.saveCars(carInfo);
	}

}

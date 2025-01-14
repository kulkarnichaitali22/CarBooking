package com.CarBooking.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CarBooking.Entity.CarInfo;
import com.CarBooking.Repository.CarInfoRepo;

@Service
public class CarInfoService {
	
	@Autowired
	private CarInfoRepo carInfoRepo;
	
	public CarInfo saveCars(CarInfo carInfo)
	{
		return carInfoRepo.save(carInfo);
	}
	
	

}

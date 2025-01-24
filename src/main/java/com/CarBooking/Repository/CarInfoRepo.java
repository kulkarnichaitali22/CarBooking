package com.CarBooking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CarBooking.Entity.CarInfo;

@Repository
public interface CarInfoRepo extends JpaRepository<CarInfo, Long>{
	
}

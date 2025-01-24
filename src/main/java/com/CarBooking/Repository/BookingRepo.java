package com.CarBooking.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CarBooking.Entity.Booking;
import com.CarBooking.Entity.CarInfo;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Long>{
	
	 List<Booking> findByCarIdAndIsAvailableTrue(CarInfo car);
	 
	 List<Booking> findByCarIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(Long carId, LocalDate startDate, LocalDate endDate);

	 List<Booking> findByCarAndStartDateLessThanEqualAndEndDateGreaterThanEqual(CarInfo car, LocalDate startDate, LocalDate endDate);

}

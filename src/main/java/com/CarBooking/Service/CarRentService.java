package com.CarBooking.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CarBooking.Entity.Booking;
import com.CarBooking.Entity.CarInfo;
import com.CarBooking.Repository.BookingRepo;
import com.CarBooking.Repository.CarInfoRepo;

@Service
public class CarRentService {
	
	@Autowired
	private CarInfoRepo carInfoRepo;
	
	@Autowired
	private BookingRepo bookingRepo;
			
	public boolean checkAvailability(LocalDate date, long carId) 
	{
		CarInfo car = carInfoRepo.findById(carId).orElse(null);
		
		if(car == null)
		{
			return false;
		}
		
		List<Booking> bookings = bookingRepo.findByCarIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(car.getId(), date, date);
        if (bookings.size() == 0) {
            return true;
        } else {
            return false;
        }
		
	}
	
	 public String bookCar(Long carId, LocalDate startDate, LocalDate endDate, String userName, String destination, String email, String userAddress) {
	        
		    boolean startAvailable = checkAvailability(startDate, carId);
	        boolean endAvailable = checkAvailability(endDate, carId);

	        if (startAvailable == false || endAvailable == false) {
	            return "Car is not available for the selected dates.";
	        }

	        CarInfo car = carInfoRepo.findById(carId).orElse(null);
	        if (car == null) {
	            return "Car not found.";
	        }

	        Booking booking = new Booking();
	        booking.setStartDate(startDate);
	        booking.setEndDate(endDate);
	        booking.setUserName(userName);
	        booking.setDestination(destination);
	        booking.setCar(car);
	        booking.setEmail(email);
	        booking.setUserAddress(userAddress);
	        booking.setIsAvailable(false);

	        bookingRepo.save(booking);
	        return "success";
	    }

}

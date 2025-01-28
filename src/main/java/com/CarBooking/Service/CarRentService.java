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
	
	 public String bookCar(Booking booking)
	 {
		    boolean startAvailable = checkAvailability(booking.getStartDate(), booking.getCar().getId());
	        boolean endAvailable = checkAvailability(booking.getEndDate(), booking.getCar().getId());

	        if (startAvailable == false || endAvailable == false) {
	            return "Car is not available for the selected dates.";
	        }

	        CarInfo car = carInfoRepo.findById(booking.getCar().getId()).orElse(null);
	        if (car == null) {
	            return "Car not found.";
	        }
	   
	        bookingRepo.save(booking);
	        return "success";
	    }

}

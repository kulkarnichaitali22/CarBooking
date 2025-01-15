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
	
	   public boolean isCarAvailable(Long carId, LocalDate bookingDate) {
	        List<Booking> bookings = bookingRepo.findByCarId(carId);

	        for (Booking booking : bookings) {
	            if (booking.getBookingDate().isEqual(bookingDate)) {
	                return false; 
	            }
	        }

	        return true; 
	    }

    public String bookCar(Booking booking) {
        if (isCarAvailable(booking.getCarId(), booking.getBookingDate())) {
            Booking book = new Booking();
            book.setCarId(booking.getCarId());
            book.setBookingDate(booking.getBookingDate());
            book.setUserName(booking.getUserName());
            book.setUserAddress(booking.getUserAddress());
            book.setDestination(booking.getDestination());

            bookingRepo.save(book);

            CarInfo car = carInfoRepo.findById(booking.getCarId()).orElseThrow();
            car.setIsAvailable(false);
            car.setModifiedDate(LocalDate.now());
            carInfoRepo.save(car);

            return "Booking successful!";
        } else {
            return "Car is not available for the selected date.";
        }
    }
	

}

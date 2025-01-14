package com.CarBooking.Controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CarBooking.Entity.Booking;
import com.CarBooking.Service.CarRentService;

@RestController
public class CarRentController {
	
	@Autowired
	private CarRentService carRentService;
	
	@GetMapping("/check-availability")
    public String checkAvailability(@RequestParam Long carId, @RequestParam String date) {
        LocalDate bookingDate = LocalDate.parse(date);
        boolean isAvailable = carRentService.isCarAvailable(carId, bookingDate);

        return isAvailable ? "Car is available for the selected date." : "Car is not available for the selected date.";
    }
	
	@PostMapping("/book")
    public String bookCar(@RequestBody Booking booking) {
        return carRentService.bookCar(booking);
    }

}

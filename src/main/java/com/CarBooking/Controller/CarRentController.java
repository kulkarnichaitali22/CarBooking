package com.CarBooking.Controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.CarBooking.Service.CarRentService;
import com.CarBooking.Service.MailService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class CarRentController {
	
	@Autowired
	private CarRentService carRentService;

	@Autowired
	private MailService mailService;
	
	@GetMapping("/check-availability/{date}/{id}")
    public String checkAvailability(@PathVariable("date") LocalDate date, @PathVariable("id") long carId) {
		
        boolean ans = carRentService.checkAvailability(date, carId);
        
        if(ans) 
        {
        	return "Car is Available on : " + date ;
        }
        else
        {
        	return "Car is not Available on : " + date ;
        }
    }
	
	@PostMapping("/bookCar")
	public String bookCar(@RequestParam Long carId, 
            @RequestParam LocalDate startDate, 
            @RequestParam LocalDate endDate, 
            @RequestParam String userName, 
            @RequestParam String destination,
            @RequestParam String email,
            @RequestParam String userAddress)
	{
		String result = carRentService.bookCar(carId, startDate, endDate, userName, destination, email, userAddress);
		
		if(result.equals("success"))
		{
			String sub = "Booking successful";
			String text = "Congratulations!! The car is booked successfully. From date " + startDate + " to " + endDate + ". The journey starts from " + userAddress + " to " + destination + ". Have a happy and safe journey!!";
			mailService.sendMail(email, sub, text);
		}
		
		return result;
	}
	
	
	
	
}

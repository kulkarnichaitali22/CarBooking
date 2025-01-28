package com.CarBooking.Controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.CarBooking.Entity.Booking;
import com.CarBooking.Repository.BookingRepo;
import com.CarBooking.Service.CarRentService;
import com.CarBooking.Service.MailService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class CarRentController implements Runnable {

	@Autowired
	private CarRentService carRentService;

	@Autowired
	private MailService mailService;

	@Autowired
	private BookingRepo bookingRepo;

	@GetMapping("/check-availability/{date}/{id}")
	public String checkAvailability(@PathVariable("date") LocalDate date, @PathVariable("id") long carId) {

		boolean ans = carRentService.checkAvailability(date, carId);

		if (ans) {
			return "Car is Available on : " + date;
		} else {
			return "Car is not Available on : " + date;
		}
	}

	@PostMapping("/bookCar")
	public String bookCar(@RequestBody Booking booking) {
		String result = carRentService.bookCar(booking);

		if (result.equals("success")) {
			String sub = "Booking successful";
			String text = "Congratulations!! The car is booked successfully. From date " + booking.getStartDate()
					+ " to " + booking.getEndDate() + ". The journey starts from " + booking.getUserAddress() + " to " + booking.getDestination()
					+ ". Have a happy and safe journey!!";
			mailService.sendMail(booking.getEmail(), sub, text);
			run();
		}

		return result;
	}

	public void run() {
		Thread t1 = new Thread(() -> {

			try {
				while (true) {

					List<Booking> allBookings = bookingRepo.findAll();
					System.out.println(allBookings);
					List<Booking> colllectedBooking = allBookings.stream()
							.filter(p -> p.getEndDate().isBefore(LocalDate.now()) && p.getMailStatus() == 0)
							.collect(Collectors.toList());

					for (Booking booking : colllectedBooking) {

						String sub = "Booking has ended!!";
						String text = "Your ride has been ended here!! I hope you enjoyed your journey.";
						mailService.sendMail(booking.getEmail(), sub, text);

						booking.setMailStatus(1);
						bookingRepo.save(booking);
					}
					Thread.sleep(2000);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		});
		t1.start();
	}

}

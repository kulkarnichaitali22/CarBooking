package com.CarBooking.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Booking {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private Long carId;

	    private LocalDate bookingDate;

	    private String userName;

	    private String userAddress;

	    private String destination;

		public Booking() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Booking(Long carId, LocalDate bookingDate, String userName, String userAddress, String destination) {
			super();
			this.carId = carId;
			this.bookingDate = bookingDate;
			this.userName = userName;
			this.userAddress = userAddress;
			this.destination = destination;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getCarId() {
			return carId;
		}

		public void setCarId(Long carId) {
			this.carId = carId;
		}

		public LocalDate getBookingDate() {
			return bookingDate;
		}

		public void setBookingDate(LocalDate bookingDate) {
			this.bookingDate = bookingDate;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getUserAddress() {
			return userAddress;
		}

		public void setUserAddress(String userAddress) {
			this.userAddress = userAddress;
		}

		public String getDestination() {
			return destination;
		}

		public void setDestination(String destination) {
			this.destination = destination;
		}
	    
	    

}

package com.CarBooking.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Booking {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;	  
	    private LocalDate startDate;
	    private LocalDate endDate;
	    private String userName;
	    private String userAddress;
	    private String destination;	    
	    private String email;
	    private boolean isAvailable;

	    @ManyToOne
	    @JoinColumn(name = "car_id", nullable = false) 
	    private CarInfo car; 

		public Booking() {
			super();
			// TODO Auto-generated constructor stub
		}
		

		public Booking(Long id,  LocalDate startDate,LocalDate endDate, String userName, String userAddress,
				String destination, String email,boolean isAvailable,  CarInfo car) {
			super();
			this.id = id;
			this.startDate = startDate;
			this.endDate = endDate;
			this.userName = userName;
			this.userAddress = userAddress;
			this.destination = destination;
			this.email = email;
			this.isAvailable = isAvailable;
			this.car = car;
		}


	    public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
		
		public LocalDate getStartDate() {
			return startDate;
		}

		public void setStartDate(LocalDate startDate) {
			this.startDate = startDate;
		}
		
		public LocalDate getEndDate() {
			return endDate;
		}

		public void setEndDate(LocalDate endDate) {
			this.endDate = endDate;
		}
		
		public boolean getIsAvailable() {
			return isAvailable;
		}

		public void setIsAvailable(boolean isAvailable) {
			this.isAvailable = isAvailable;
		}


		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public CarInfo getCar() {
			return car;
		}


		public void setCar(CarInfo car) {
			this.car = car;
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

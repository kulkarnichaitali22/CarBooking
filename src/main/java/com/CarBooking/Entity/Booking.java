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
	    private int mailStatus;

	    @ManyToOne
	    @JoinColumn(name = "car_id", nullable = false) 
	    private CarInfo car; 

}

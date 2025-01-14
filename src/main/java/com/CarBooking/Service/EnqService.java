package com.CarBooking.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CarBooking.Entity.Enquiry;
import com.CarBooking.Repository.EnqRepo;

@Service
public class EnqService {
	
	@Autowired
	private EnqRepo enqRepo;
	
	public String saveEnquiry(Enquiry enq)
	{
		enqRepo.save(enq);
		return "Success!!";
	}

}

package com.CarBooking.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.CarBooking.Entity.Enquiry;
import com.CarBooking.Service.EnqService;

@RestController
public class EnqController {

	@Autowired
	private EnqService enqService;
	
	@PostMapping("/saveEnquiry")
	public Enquiry saveEnquiry(@RequestBody Enquiry enq)
	{
		String result = enqService.saveEnquiry(enq);
		
		if(result.equals("Success!!"))
		{
			return enq;
		}else
		{
			return null;
		}
	}
}

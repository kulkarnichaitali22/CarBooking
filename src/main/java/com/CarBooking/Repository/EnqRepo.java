package com.CarBooking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CarBooking.Entity.Enquiry;

public interface EnqRepo extends JpaRepository<Enquiry, Long>{

}

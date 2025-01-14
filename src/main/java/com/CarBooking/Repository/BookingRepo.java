package com.CarBooking.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CarBooking.Entity.Booking;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Long>{

    List<Booking> findByCarIdAndBookingDate(Long carId, LocalDate bookingDate);

}

/**
 * 
 */
package com.example.finalproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.finalproject.models.Trip;
import com.example.finalproject.models.TripSchedule;

/**
 * @author akbar alzaini
 *
 */
public interface TripScheduleRepository extends JpaRepository<TripSchedule, Long> {
    TripSchedule findByTripDetailAndTripDate(Trip tripDetail, String tripDate);

	List<TripSchedule> findAllByTripDate(String tripDate);
}

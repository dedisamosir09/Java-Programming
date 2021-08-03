/**
 * 
 */
package com.example.finalproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.finalproject.models.Agency;
import com.example.finalproject.models.Stop;
import com.example.finalproject.models.Trip;

/**
 * @author akbar alzaini
 *
 */
public interface TripRepository extends JpaRepository<Trip, Long> {
	List<Trip> findAllBySourceStopAndDestStop(Stop sourceStop,Stop destStop);

	List<Trip> findByAgency(Agency agency);
}

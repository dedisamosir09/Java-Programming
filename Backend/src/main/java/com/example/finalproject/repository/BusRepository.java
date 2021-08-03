/**
 * 
 */
package com.example.finalproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.finalproject.models.Agency;
import com.example.finalproject.models.Bus;

/**
 * @author akbar alzaini
 *
 */
@Repository
public interface BusRepository extends JpaRepository<Bus, Long>{
	Bus findByCode(String busCode);

    Bus findByCodeAndAgency(String busCode, Agency agency);

	List<Bus> findByAgency(Agency agency);
}

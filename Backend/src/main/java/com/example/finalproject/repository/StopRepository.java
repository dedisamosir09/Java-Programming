/**
 * 
 */
package com.example.finalproject.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.finalproject.models.Stop;

/**
 * @author akbar alzaini
 *
 */

@Repository
public interface StopRepository extends JpaRepository<Stop, Long>{
	Stop findByCode(String code);
}

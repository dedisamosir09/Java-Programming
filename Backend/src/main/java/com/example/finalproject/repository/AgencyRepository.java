/**
 * 
 */
package com.example.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.finalproject.models.Agency;
import com.example.finalproject.models.User;

/**
 * @author akbar alzaini
 *
 */
@Repository
public interface AgencyRepository extends JpaRepository<Agency, Long>{
	
	Agency findByCode(String agencyCode);

    Agency findByOwner(User user);

    Agency findByName(String name);
}

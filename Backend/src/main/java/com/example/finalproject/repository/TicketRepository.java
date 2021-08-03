/**
 * 
 */
package com.example.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.finalproject.models.Ticket;

/**
 * @author akbar alzaini
 *
 */
public interface TicketRepository extends JpaRepository<Ticket, Long>{

}

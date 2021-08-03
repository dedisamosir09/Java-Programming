/**
 * 
 */
package com.example.finalproject.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.finalproject.models.Stop;
import com.example.finalproject.repository.StopRepository;

/**
 * @author akbar alzaini
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/stop")
public class StopController {
	@Autowired 
	StopRepository stopRepository;
	
	@GetMapping("/")
	public List<Stop> getAllStop(){
		return stopRepository.findAll();
	}
	
	@PostMapping("/")
	public ResponseEntity<?> addStop(@Valid @RequestBody Stop stop) {
		stopRepository.save(stop);
		return ResponseEntity.ok(stop);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteStop(@PathVariable(value="id")Long id) {
		Stop stop = stopRepository.getOne(id);
		String result = "";
		
		try {
			stopRepository.delete(stop);
			result += "Data Stop : "+stop.getName()+" berhasil di hapus";
		} catch (Exception e) {
			result += "Data Stop dengan id: "+id+" Tidak ditemukan";
		}
		
		return ResponseEntity.ok(result);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Stop> updateStop(@PathVariable(value="id") Long id, @Valid @RequestBody Stop detailStop){
		
		try {
			Stop stop = stopRepository.getOne(id);
			stop.setCode(detailStop.getCode());
			stop.setName(detailStop.getName());
			stop.setDetail(detailStop.getDetail());
			
			Stop updateStop = stopRepository.save(stop);
			
			return ResponseEntity.ok(updateStop);
			
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.notFound().build();
		}
	}
}

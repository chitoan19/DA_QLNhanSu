package com.tttn.quanlynhansu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tttn.quanlynhansu.model.Luong;
import com.tttn.quanlynhansu.repository.LuongRepository;
import com.tttn.quanlynhansu.request.LuongRequest;
import com.tttn.quanlynhansu.response.Response;
import com.tttn.quanlynhansu.service.LuongService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class LuongController {
	@Autowired
	private LuongService luongService;
	
	@Autowired
	private LuongRepository luongRepo;
	
	@PostMapping("/luong")
	public ResponseEntity getAll(@RequestBody LuongRequest request) {
		List<Luong> list = luongService.findAll(request);
		return new ResponseEntity(new Response(null, list, luongService.totalItems), HttpStatus.OK);
	}
	
	@GetMapping("/luong/{id}")
	public ResponseEntity getLuongById(@PathVariable("id") Long id) {
		Luong luong = luongRepo.findById(id).get();
		return new ResponseEntity(new Response(luong, null), HttpStatus.OK);
	}
	
	@PostMapping("/luong/add")
	public ResponseEntity create(@RequestBody Luong luong) {
		Luong newLuong = luongRepo.save(luong);
		return new ResponseEntity(new Response(newLuong, null), HttpStatus.OK);
	}
	
	@PutMapping("/luong/{id}")
	public ResponseEntity update(@RequestBody Luong luong) {
		Luong newLuong = luongRepo.save(luong);
		return new ResponseEntity(new Response(newLuong, null), HttpStatus.OK);
	}
	
}

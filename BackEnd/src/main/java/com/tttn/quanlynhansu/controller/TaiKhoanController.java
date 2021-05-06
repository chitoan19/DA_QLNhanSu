package com.tttn.quanlynhansu.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.tttn.quanlynhansu.model.TaiKhoan;
import com.tttn.quanlynhansu.request.AuthRequest;
import com.tttn.quanlynhansu.response.Response;
import com.tttn.quanlynhansu.service.TaiKhoanService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class TaiKhoanController {
	@Autowired
	private TaiKhoanService tkService;

	@PostMapping("/login")
	public TaiKhoan doLogin(@RequestBody AuthRequest authRequest) {
		TaiKhoan tk = tkService.getTaiKhoan(authRequest.getTen_dang_nhap(), authRequest.getMat_khau());
		return tkService.getTaiKhoan(authRequest.getTen_dang_nhap(), authRequest.getMat_khau());
	}

	@PostMapping("/tai-khoan")
	public ResponseEntity list(@RequestBody AuthRequest authRequest) {
		List<TaiKhoan> list = tkService.findAll(authRequest);
		return new ResponseEntity(new Response(null, list, tkService.totalItems), HttpStatus.OK);
	}

	@DeleteMapping("/tai-khoan/{id}")
	public ResponseEntity delTaiKhoan(@PathVariable("id") Long id) {
		tkService.delTaiKhoan(id);
		List<TaiKhoan> list = tkService.getAllTaiKhoan();
		return new ResponseEntity(new Response(null, list, tkService.totalItems), HttpStatus.OK);
	}

	@PostMapping("/tai-khoan/{id}")
	public ResponseEntity getTaiKhoan(@RequestBody TaiKhoan tk) {
		TaiKhoan selectedTK = tkService.getTaiKhoan(tk.getId());
		return new ResponseEntity(new Response(selectedTK, null, null), HttpStatus.OK);
	}

	@PutMapping("/tai-khoan/{id}")
	public ResponseEntity editNhanVien(@RequestBody TaiKhoan tk) {
		TaiKhoan newTK = tkService.saveTaiKhoan(tk);
		return new ResponseEntity(new Response(newTK, null, null), HttpStatus.OK);
	}
	
	@PostMapping("/tai-khoan/add")
	public ResponseEntity addTaiKhoan(@RequestBody TaiKhoan tk) {
		TaiKhoan newTK = tkService.saveTaiKhoan(tk);
		return new ResponseEntity(new Response(newTK, null, null), HttpStatus.OK);
	}
	
	@GetMapping("/tai-khoan/getall")
	public List<TaiKhoan> getall(){
		return tkService.getAllTaiKhoan();
	}
}

package com.tttn.quanlynhansu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tttn.quanlynhansu.model.DanhGiaNhanVien;
import com.tttn.quanlynhansu.repository.DanhGiaNhanVienRepository;

@Service
public class DanhGiaNhanVienService {
	@Autowired
	private DanhGiaNhanVienRepository repo;
	
	public List<DanhGiaNhanVien> findByNhanVienId(Long id){
		List<DanhGiaNhanVien> list = new ArrayList<DanhGiaNhanVien>();
		for(DanhGiaNhanVien item : repo.findAll()) {
			if(item.getNhan_vien_id() == id) {
				list.add(item);
			}
		}
		return list;
	}
}

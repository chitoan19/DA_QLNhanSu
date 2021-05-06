package com.tttn.quanlynhansu.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tttn.quanlynhansu.model.ThongTinGiaDinh;
import com.tttn.quanlynhansu.repository.ThongTinGiaDinhRepository;

@Service
public class ThongTinGiaDinhService {
	@Autowired
	private ThongTinGiaDinhRepository repo;
	
	public List<ThongTinGiaDinh> findByNhanVienId(Long id){
		List<ThongTinGiaDinh> list = new ArrayList<ThongTinGiaDinh>();
		for(ThongTinGiaDinh item : repo.findAll()) {
			if(item.getNhan_vien_id() == id) {
				list.add(item);
			}
		}
		return list;
	}
}

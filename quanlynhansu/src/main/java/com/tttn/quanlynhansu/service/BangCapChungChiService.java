package com.tttn.quanlynhansu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tttn.quanlynhansu.model.BangCapChungChi;
import com.tttn.quanlynhansu.repository.BangCapChungChiRepository;

@Service
public class BangCapChungChiService {
	@Autowired
	private BangCapChungChiRepository repo;
	
	public List<BangCapChungChi> findByNhanVienId(Long id){
		List<BangCapChungChi> list = new ArrayList<BangCapChungChi>();
		for(BangCapChungChi item : repo.findAll()) {
			if(item.getNhan_vien_id() == id) {
				list.add(item);
			}
		}
		return list;
	}
}

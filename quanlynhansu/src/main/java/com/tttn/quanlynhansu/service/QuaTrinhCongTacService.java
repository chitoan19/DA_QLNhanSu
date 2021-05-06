package com.tttn.quanlynhansu.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tttn.quanlynhansu.model.QuaTrinhCongTac;
import com.tttn.quanlynhansu.repository.QuaTrinhCongTacRepository;

@Service
public class QuaTrinhCongTacService {
	@Autowired
	private QuaTrinhCongTacRepository repo;
	
	public List<QuaTrinhCongTac> findByNhanVienId(Long id){
		List<QuaTrinhCongTac> list = new ArrayList<QuaTrinhCongTac>();
		for(QuaTrinhCongTac item : repo.findAll()) {
			if(item.getNhan_vien_id() == id) {
				list.add(item);
			}
		}
		return list;
	}
}

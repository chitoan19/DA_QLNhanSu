package com.tttn.quanlynhansu.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tttn.quanlynhansu.model.QuaTrinhDaoTao;
import com.tttn.quanlynhansu.repository.QuaTrinhDaoTaoRepository;

@Service
public class QuaTrinhDaoTaoService {
	@Autowired
	private QuaTrinhDaoTaoRepository repo;
	
	public List<QuaTrinhDaoTao> findByNhanVienId(Long id){
		List<QuaTrinhDaoTao> list = new ArrayList<QuaTrinhDaoTao>();
		for(QuaTrinhDaoTao item : repo.findAll()) {
			if(item.getNhan_vien_id() == id) {
				list.add(item);
			}
		}
		return list;
	}
	
}

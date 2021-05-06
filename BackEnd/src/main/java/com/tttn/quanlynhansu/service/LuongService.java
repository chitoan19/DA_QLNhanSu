package com.tttn.quanlynhansu.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tttn.quanlynhansu.model.Luong;
import com.tttn.quanlynhansu.model.NhanVien;
import com.tttn.quanlynhansu.repository.LuongRepository;
import com.tttn.quanlynhansu.request.LuongRequest;

@Service
public class LuongService {
	public static Long totalItems;

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private LuongRepository repo;
	
	public List<Luong> findAll(LuongRequest request){
		Map<String, Object> params = new HashMap<String, Object>();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM luong WHERE 1 = 1");
		if (request.getNhan_vien_id() != null) {
			sql.append(" AND nhan_vien_id =:nhan_vien_id");
			params.put("nhan_vien_id", request.getNhan_vien_id());
		}
		sql.append(" ORDER BY id DESC ");
		Query query = em.createNativeQuery(sql.toString(), Luong.class);

		Set<String> keySet = params.keySet();
		for (String key : keySet) {
			query.setParameter(key, params.get(key));

		}
		totalItems = (long) query.getResultList().size();
		query.setFirstResult((request.getPageNum() - 1) * request.getPageSize());
		query.setMaxResults(request.getPageSize());

		List<Luong> result = query.getResultList();
		return result;
	}
}

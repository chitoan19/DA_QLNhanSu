package com.tttn.quanlynhansu.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tttn.quanlynhansu.model.NhanVien;
import com.tttn.quanlynhansu.repository.NhanVienRepository;
import com.tttn.quanlynhansu.request.NhanVienRequest;

@Service
public class NhanVienService {

	public static Long totalItems;

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private NhanVienRepository nvRepo;

	public List<NhanVien> getAllNhanVien() {
		return nvRepo.findAll();
	}

	public void delNhanVien(long id) {
		nvRepo.deleteById(id);
	}

	public NhanVien saveNhanVien(NhanVien nv) {
		return nvRepo.save(nv);
	}

	public NhanVien getNhanVien(long id) {
		return nvRepo.findById(id).get();
	}

	public List<NhanVien> findAll(NhanVienRequest nvRequest) {
		Map<String, Object> params = new HashMap<String, Object>();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM nhan_vien WHERE 1 = 1");
		if (nvRequest.getId() != null) {
			sql.append(" AND nhan_vien_id !=:id");
			params.put("id", nvRequest.getId());
		}

		if (nvRequest.getHo_ten() != null && !nvRequest.getHo_ten().equals("")) {
			sql.append(" AND ho_ten LIKE  :ho_ten");
			params.put("ho_ten", "%" + nvRequest.getHo_ten() + "%");
		}
		if (nvRequest.getPhong_ban_id() != null) {
			sql.append(" AND phong_ban_id =:phong_ban_id");
			params.put("phong_ban_id", nvRequest.getPhong_ban_id());
		}
		if (nvRequest.getChuc_vu() != null && !nvRequest.getChuc_vu().equals("")) {
			sql.append(" AND chuc_vu =:chuc_vu");
			params.put("chuc_vu", nvRequest.getChuc_vu());
		}
		if (nvRequest.getDia_chi() != null && !nvRequest.getDia_chi().equals("")) {
			sql.append(" AND dia_chi_hien_tai like:dia_chi");
			params.put("dia_chi", "%" + nvRequest.getDia_chi() + "%");
		}
		if (nvRequest.getQue_quan() != null && !nvRequest.getQue_quan().equals("")) {
			sql.append(" AND que_quan like:que_quan");
			params.put("que_quan", "%" + nvRequest.getQue_quan() + "%");
		}

		if (nvRequest.getEmail() != null && !nvRequest.getEmail().equals("")) {
			sql.append(" AND email like:email");
			params.put("email", "%" + nvRequest.getEmail() + "%");
		}
		if (nvRequest.getGioi_tinh() <= 1 && nvRequest.getGioi_tinh() >= 0) {
			sql.append(" AND gioi_tinh =:gioi_tinh");
			params.put("gioi_tinh", nvRequest.getGioi_tinh());
		}
		sql.append(" ORDER BY nhan_vien_id DESC ");
		Query query = em.createNativeQuery(sql.toString(), NhanVien.class);

		Set<String> keySet = params.keySet();
		for (String key : keySet) {
			query.setParameter(key, params.get(key));

		}
		totalItems = (long) query.getResultList().size();
		query.setFirstResult((nvRequest.getPageNum() - 1) * nvRequest.getPageSize());
		query.setMaxResults(nvRequest.getPageSize());

		List<NhanVien> result = query.getResultList();
		return result;
	}

}

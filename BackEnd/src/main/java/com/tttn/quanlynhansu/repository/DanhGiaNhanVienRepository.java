package com.tttn.quanlynhansu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tttn.quanlynhansu.model.DanhGiaNhanVien;

@Repository
public interface DanhGiaNhanVienRepository extends JpaRepository<DanhGiaNhanVien, Long>{
	
}

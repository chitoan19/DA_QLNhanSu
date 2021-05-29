package com.tttn.quanlynhansu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tttn.quanlynhansu.model.TinhLuongThang;


@Repository
public interface TinhLuongThangRepository extends JpaRepository<TinhLuongThang, Long>{
	public List<TinhLuongThang> findAllByThang(int thang);
	public List<TinhLuongThang> findAllByNam(int nam);
}

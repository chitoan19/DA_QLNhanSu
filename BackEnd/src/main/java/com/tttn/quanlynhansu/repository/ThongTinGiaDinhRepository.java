package com.tttn.quanlynhansu.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tttn.quanlynhansu.model.ThongTinGiaDinh;

@Repository
public interface ThongTinGiaDinhRepository extends JpaRepository<ThongTinGiaDinh, Long>{
	
}

package com.tttn.quanlynhansu.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tttn.quanlynhansu.model.BangCapChungChi;

@Repository
public interface BangCapChungChiRepository extends JpaRepository<BangCapChungChi, Long>{
	
}

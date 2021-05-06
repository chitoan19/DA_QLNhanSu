package com.tttn.quanlynhansu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tttn.quanlynhansu.model.PhongBan;

@Repository
public interface PhongBanRepository extends JpaRepository<PhongBan, Long>{

}

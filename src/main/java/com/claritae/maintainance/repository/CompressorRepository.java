package com.claritae.maintainance.repository;

import com.claritae.maintainance.model.equipment.Compressor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompressorRepository extends JpaRepository<Compressor, Integer> {
}

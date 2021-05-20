package com.claritae.maintainance.repository;

import com.claritae.maintainance.model.equipment.Compressor;
import com.claritae.maintainance.model.equipmentrecord.CompressorRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface CompressorRecordRepository extends JpaRepository<CompressorRecord, Integer> {
    List<CompressorRecord> findCompressorRecordsByLocalDate(LocalDate localDateTime);
}

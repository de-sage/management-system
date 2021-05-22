package com.claritae.maintainance.repository;

import com.claritae.maintainance.model.equipmentrecord.CompressorRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CompressorRecordRepository extends JpaRepository<CompressorRecord, Integer> {
    List<CompressorRecord> findCompressorRecordsByLocalDate(LocalDate localDateTime);
    List<CompressorRecord> findCompressorRecordsByCompressorIdOrderByIdDesc(Integer integer);
    List<CompressorRecord> findCompressorRecordsByCreatedBy(String name);
}

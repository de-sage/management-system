package com.claritae.maintainance.service.admin;

import com.claritae.maintainance.model.equipment.Compressor;
import com.claritae.maintainance.model.equipmentrecord.CompressorRecord;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface AdminService {

    List<CompressorRecord> findAllCompressorRecords();
    List<CompressorRecord> findAllCompressorRecordsByCompressorId(Integer id);
    List<CompressorRecord> findAllCompressorRecordsByDate(LocalDate localDateTime);
    List<Compressor> findAllCompressor();
    Compressor create(Compressor compressor);
    Compressor createChecks(Integer CompressorId, CompressorRecord compressorRecord);
}

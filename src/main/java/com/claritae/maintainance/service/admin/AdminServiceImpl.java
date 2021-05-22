package com.claritae.maintainance.service.admin;

import com.claritae.maintainance.model.equipment.Compressor;
import com.claritae.maintainance.model.equipmentrecord.CompressorRecord;
import com.claritae.maintainance.repository.CompressorRecordRepository;
import com.claritae.maintainance.repository.CompressorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AdminServiceImpl implements AdminService {

    @Autowired
    CompressorRecordRepository compressorRecordRepository;

    @Autowired
    CompressorRepository compressorRepository;


    @Override
    public List<CompressorRecord> findAllCompressorRecords() {
        return compressorRecordRepository.findAll();
    }

    @Override
    public List<CompressorRecord> findAllCompressorRecordsByCompressorId(Integer id) {
        Compressor compressor1 = compressorRepository.findById(id).get();
        return compressor1.getCompressorRecords();
    }

    @Override
    public List<CompressorRecord> findAllCompressorRecordsByDate(LocalDate localDateTime) {
        return compressorRecordRepository.findCompressorRecordsByLocalDate(localDateTime);
    }

    @Override
    public List<Compressor> findAllCompressor() {
        return compressorRepository.findAll();
    }

    @Override
    public List<Compressor> findAllCompressorWithBadHealth() {
        return null;
    }

    @Override
    public List<CompressorRecord> findAllChecksPerformedByAnEngineer(String name) {
        return compressorRecordRepository.findCompressorRecordsByCreatedBy(name);
    }

    @Override
    public Compressor create(Compressor compressor) {
        return compressorRepository.save(compressor);
    }

    @Override
    public List<CompressorRecord> createChecks(Integer CompressorId, CompressorRecord compressorRecord) {
        Optional<Compressor> compressor1;
        compressor1 = compressorRepository.findById(CompressorId);
        Compressor compressor12 = compressor1.get();
        compressor12.setHealth(compressorRecord.isHealth());
        compressor12.addRecord(compressorRecord);
        compressorRecord.setCompressor(compressor12);
        compressorRepository.save(compressor12);
        return compressorRecordRepository.findCompressorRecordsByCompressorIdOrderByIdDesc(CompressorId);
    }
}

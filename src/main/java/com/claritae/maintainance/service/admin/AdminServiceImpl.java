package com.claritae.maintainance.service.admin;

import com.claritae.maintainance.model.equipment.Compressor;
import com.claritae.maintainance.model.equipmentrecord.CompressorRecord;
//import com.claritae.maintainance.repository.AirCircuitRepository;
import com.claritae.maintainance.repository.CompressorRecordRepository;
import com.claritae.maintainance.repository.CompressorRepository;
import com.claritae.maintainance.service.admin.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AdminServiceImpl implements AdminService {

    @Autowired
    CompressorRecordRepository compressorRecordRepository;

    @Autowired
    CompressorRepository compressorRepository;

//    @Autowired
//    AirCircuitRepository airCircuitRepository;


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

//    @Override
//    public List<CompressorRecord> findAllRecordsByDate(LocalDateTime localDateTime) {
//        return null;
//    }

    @Override
    public List<Compressor> findAllCompressor() {
        return compressorRepository.findAll();
    }

    @Override
    public Compressor create(Compressor compressor) {
        return compressorRepository.save(compressor);
    }

    @Override
    public Compressor createChecks(Integer CompressorId, CompressorRecord compressorRecord) {
        Optional<Compressor> compressor1;
        compressor1 = compressorRepository.findById(CompressorId);
        Compressor compressor12 = compressor1.get();
        compressor12.setHealth(compressorRecord.isHealth());
        compressor12.addRecord(compressorRecord);
        compressorRecord.setCompressor(compressor12);
        return compressorRepository.save(compressor12);
    }
}

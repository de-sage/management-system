package com.claritae.maintainance.model.equipment;

import com.claritae.maintainance.model.equipment.Compressor;
import com.claritae.maintainance.model.equipmentrecord.CompressorRecord;
import com.claritae.maintainance.repository.CompressorRecordRepository;
import com.claritae.maintainance.repository.CompressorRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.Optional;


@Slf4j
@SpringBootTest
@Transactional
class CompressorTest {

    @Autowired
    CompressorRecordRepository compressorRecordRepository;

    @Autowired
    CompressorRepository compressorRepository;

    Compressor compressor;


    CompressorRecord compressorRecord;

    @Test
    @Rollback(value = false)
    void saveCompressorTest(){
        compressor = new Compressor();
        compressorRecord = new CompressorRecord();
        compressorRecord.setCoolantLevels(true);
        compressorRecord.setLeakTest(true);
        compressorRecord.setDischargeGasTemperature(10.00);
        compressorRecord.setInletGasPressure(10.00);
        compressorRecord.setStage1(100);
        compressorRecord.setStage2(100);
        compressorRecord.setStage3(100);
        compressorRecord.setSuctionPressure(10);
        compressor.addRecord(compressorRecord);
        compressorRecord.setCompressor(compressor);
        compressorRepository.save(compressor);
    }

    @Test
    @Rollback(value = false)
    void saveCompressorCheckRecordTest(){
        Optional<Compressor> compressor1;
        compressor1 = compressorRepository.findById(1);
        Compressor compressor12 = compressor1.get();
        compressorRecord = new CompressorRecord();
        compressorRecord.setCoolantLevels(true);
        compressorRecord.setLeakTest(true);
        compressorRecord.setDischargeGasTemperature(10.00);
        compressorRecord.setInletGasPressure(10.00);
        compressorRecord.setStage1(100);
        compressorRecord.setStage2(100);
        compressorRecord.setStage3(100);
        compressorRecord.setSuctionPressure(10);
        compressor12.addRecord(compressorRecord);
        compressorRecord.setCompressor(compressor12);
        compressorRepository.save(compressor12);
    }
}
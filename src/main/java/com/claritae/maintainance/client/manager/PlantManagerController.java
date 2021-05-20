package com.claritae.maintainance.client.manager;

import com.claritae.maintainance.model.equipment.Compressor;
import com.claritae.maintainance.model.equipmentrecord.CompressorRecord;
import com.claritae.maintainance.repository.CompressorRepository;
import com.claritae.maintainance.service.admin.AdminServiceImpl;
import com.claritae.maintainance.service.equipment.CompressorServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@Slf4j
public class PlantManagerController {

    @Autowired
    private AdminServiceImpl adminService;

    @Autowired
    private CompressorServiceImpl compressorService;

    @Autowired
    private CompressorRepository compressorRepository;



    @GetMapping(path = "/records")
    public List<CompressorRecord>findAll() {
        return adminService.findAllCompressorRecords();
    }

    @GetMapping(path = "/compressor/records/{id}")
    public List<CompressorRecord>findAllCompressorRecordsByCompressor(@Validated @PathVariable int id) {
        return adminService.findAllCompressorRecordsByCompressorId(id);
    }

    @GetMapping(path = "/compressor")
    public List<Compressor>findAllCompressor() {
        return adminService.findAllCompressor();
    }

    @GetMapping(path = "/checks/{date}")
    public List<CompressorRecord>findAllCompressor(@PathVariable("date")
                                                       @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate) {
        return adminService.findAllCompressorRecordsByDate(localDate);
    }


    @PostMapping(path = "/create/compressor")
    public ResponseEntity<?> createCompressor(@Validated @RequestBody Compressor compressor) {
        return ResponseEntity
                .ok(adminService.create(compressor));
    }

    @PostMapping(path = "/create-checks/{Id}")
    public ResponseEntity<?> createCompressorCheckRecord(@Validated @RequestBody  CompressorRecord compressorRecord, @PathVariable int Id) {
        Compressor compressor = compressorService.findById(Id);

        if(compressor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity
                .ok(adminService.createChecks(Id, compressorRecord));
    }
}

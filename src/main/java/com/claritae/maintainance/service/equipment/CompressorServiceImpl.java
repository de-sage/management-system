package com.claritae.maintainance.service.equipment;

import com.claritae.maintainance.model.equipment.Compressor;
import com.claritae.maintainance.repository.CompressorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompressorServiceImpl implements CompressorService{

    @Autowired
    CompressorRepository compressorRepository;

    @Override
    public Compressor findById(Integer compressorId) {
        return compressorRepository.findById(compressorId).orElse(null);
    }
}

package com.claritae.maintainance.model.equipment;

import com.claritae.maintainance.model.equipmentrecord.CompressorRecord;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Compressor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private boolean health = true;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "compressor", cascade = {CascadeType.ALL})
    @ToString.Exclude
    @JsonIgnore
    private List<CompressorRecord> compressorRecords;

    public void addRecord(CompressorRecord compressorRecord){
        if(compressorRecords == null){
            this.compressorRecords = new ArrayList<>();
        }
        this.compressorRecords.add(compressorRecord);
    }

}

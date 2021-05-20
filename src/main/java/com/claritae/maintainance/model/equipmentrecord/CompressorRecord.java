package com.claritae.maintainance.model.equipmentrecord;

import com.claritae.maintainance.audit.Auditable;
import com.claritae.maintainance.model.equipment.Compressor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.FieldNameConstants.Exclude;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class CompressorRecord extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private boolean health = true;

    private double suctionPressure;

    private double stage1;

    private double stage2;

    private double stage3;

    private boolean liquidSeperatorDrained;

    private boolean inletFilter;

    private boolean oilLevelPressure;

    private boolean coolantLevels;

    private boolean tightenedLooseBoltsNuts;

    private double inletGasPressure;

    private double dischargeGasTemperature;

    private boolean leakTest;

    @ManyToOne()
    @JoinColumn(nullable = false)
    @ToString.Exclude
    private Compressor compressor;


    public void setSuctionPressure(double suctionPressure) {
        double baseValue = 8.9;
        if(suctionPressure < baseValue) {
            this.setHealth(false);
        }
        this.suctionPressure = suctionPressure;
    }
}

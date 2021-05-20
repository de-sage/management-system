//package com.claritae.maintainance.model.equipmentrecord;
//
//import com.claritae.maintainance.audit.Auditable;
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.MappedSuperclass;
//
//@MappedSuperclass
//@NoArgsConstructor
//@AllArgsConstructor
//public abstract class  MaintainaceRecord extends Auditable<String> {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    private boolean health;
//
//    public boolean isHealth() {
//        return health;
//    }
//
//    public void setHealth(boolean health) {
//        this.health = health;
//    }
//}

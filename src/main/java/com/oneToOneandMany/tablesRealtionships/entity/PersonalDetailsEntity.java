package com.oneToOneandMany.tablesRealtionships.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="personal_details")
public class PersonalDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;
    @Column
    private String mobileNo;
    @Column
    private  String email;
    @OneToOne( mappedBy= "personalDetailsEntity", fetch = FetchType.EAGER,cascade = CascadeType.ALL )
    private DealersEntity dealersEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DealersEntity getDealersEntity() {
        return dealersEntity;
    }

    public void setDealersEntity(DealersEntity dealersEntity) {
        this.dealersEntity = dealersEntity;
    }
}

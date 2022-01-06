package com.oneToOneandMany.tablesRealtionships.entity;


import javax.persistence.*;

import javax.validation.constraints.NotNull;
import java.util.List;
@Entity
@Table(name="dealers_details")
public class DealersEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column @NotNull
    private String name;
    @Column @NotNull
    private String location;
    @OneToMany(mappedBy = "dealersEntity",fetch = FetchType.EAGER,cascade = CascadeType.ALL )
    private List<CarsEntity> carsEntityList;
//    @OneToOne( mappedBy= "dealersEntity", fetch = FetchType.EAGER,cascade = CascadeType.ALL )
    @OneToOne(cascade = CascadeType.ALL)
    private PersonalDetailsEntity personalDetailsEntity;


    public PersonalDetailsEntity getPersonalDetailsEntity() {
        return personalDetailsEntity;
    }

    public void setPersonalDetailsEntity(PersonalDetailsEntity personalDetailsEntity) {
        this.personalDetailsEntity = personalDetailsEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<CarsEntity> getCarsEntityList() {
        return carsEntityList;
    }

    public void setCarsEntityList(List<CarsEntity> carsEntityList) {
        this.carsEntityList = carsEntityList;
    }
}

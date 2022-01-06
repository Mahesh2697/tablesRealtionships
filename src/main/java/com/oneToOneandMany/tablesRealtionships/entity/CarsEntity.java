package com.oneToOneandMany.tablesRealtionships.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="cars_details")
public class CarsEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column @NotNull
    private String carName;
    @Column @NotNull
    private Double price;
    @Column @NotNull
    private  Long quantity;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private DealersEntity dealersEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public DealersEntity getDealersEntity() {
        return dealersEntity;
    }

    public void setDealersEntity(DealersEntity dealersEntity) {
        this.dealersEntity = dealersEntity;
    }
}

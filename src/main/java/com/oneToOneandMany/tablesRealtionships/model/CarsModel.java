package com.oneToOneandMany.tablesRealtionships.model;

public class CarsModel {
    private Long id;
    private String carName;
    private Double price;
    private  Long quantity;
    private DealersModel dealersModel;

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

    public DealersModel getDealersModel() {
        return dealersModel;
    }

    public void setDealersModel(DealersModel dealersModel) {
        this.dealersModel = dealersModel;
    }
}

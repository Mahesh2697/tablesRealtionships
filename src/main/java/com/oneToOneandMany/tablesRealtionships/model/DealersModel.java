package com.oneToOneandMany.tablesRealtionships.model;

import java.util.List;

public class DealersModel {
    private Long id;
    private String name;
    private String location;
    private List<CarsModel> carsModelList;
    private PersonalDetailsModel personalDetailsModel;

    public PersonalDetailsModel getPersonalDetailsModel() {
        return personalDetailsModel;
    }

    public void setPersonalDetailsModel(PersonalDetailsModel personalDetailsModel) {
        this.personalDetailsModel = personalDetailsModel;
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

    public List<CarsModel> getCarsModelList() {
        return carsModelList;
    }

    public void setCarsModelList(List<CarsModel> carsModelList) {
        this.carsModelList = carsModelList;
    }
}

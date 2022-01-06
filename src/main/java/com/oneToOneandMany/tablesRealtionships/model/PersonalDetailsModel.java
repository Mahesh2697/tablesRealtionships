package com.oneToOneandMany.tablesRealtionships.model;

public class PersonalDetailsModel {
    private Long id;
    private String mobileNo;
    private  String email;
    private DealersModel dealersModel;

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

    public DealersModel getDealersModel() {
        return dealersModel;
    }

    public void setDealersModel(DealersModel dealersModel) {
        this.dealersModel = dealersModel;
    }
}

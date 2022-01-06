package com.oneToOneandMany.tablesRealtionships.service;

import com.oneToOneandMany.tablesRealtionships.entity.CarsEntity;
import com.oneToOneandMany.tablesRealtionships.entity.DealersEntity;
import com.oneToOneandMany.tablesRealtionships.entity.PersonalDetailsEntity;
import com.oneToOneandMany.tablesRealtionships.model.CarsModel;
import com.oneToOneandMany.tablesRealtionships.model.DealersModel;
import com.oneToOneandMany.tablesRealtionships.model.PersonalDetailsModel;
import com.oneToOneandMany.tablesRealtionships.repository.DealersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DealersService {

    @Autowired
    private DealersRepository dealersRepository;

    public List<DealersModel> getALLDealers() {
        List<DealersEntity> dealersEntities = dealersRepository.findAll();
        return dealersEntities.stream().map(a -> getALLDealers(a)).collect(Collectors.toList());
    }
    public DealersModel getById(Long id) {
        Optional<DealersEntity> dealersEntity = dealersRepository.findById(id);
        if(dealersEntity.isPresent()){
            return getALLDealers(dealersEntity.get());

        }
        return null;

    }
    public DealersModel getByNameAndId(String name, Long id) {
        Optional<DealersEntity> dealers = dealersRepository.getByNameAndId(name , id);
        if(dealers.isPresent()){
            return getALLDealers(dealers.get());

        }
        return null;

        }

    public void addDealers(DealersModel dealersModel) {

        DealersEntity dealersEntity = new DealersEntity();
        dealersEntity.setId(dealersModel.getId());
        dealersEntity.setName(dealersModel.getName());
        dealersEntity.setLocation(dealersModel.getLocation());

        List<CarsEntity> carsEntityList = new ArrayList<>();
        dealersModel.getCarsModelList().forEach(p -> {
            CarsEntity carsEntity = new CarsEntity();
            carsEntity.setId(p.getId());
            carsEntity.setCarName(p.getCarName());
            carsEntity.setPrice(p.getPrice());
            carsEntity.setQuantity(p.getQuantity());
            carsEntity.setDealersEntity(dealersEntity);
            dealersEntity.setCarsEntityList(carsEntityList);
            carsEntityList.add(carsEntity);
        });



        PersonalDetailsEntity personalDetailsEntity = new PersonalDetailsEntity();
        personalDetailsEntity.setId(dealersModel.getPersonalDetailsModel().getId());
        personalDetailsEntity.setMobileNo(dealersModel.getPersonalDetailsModel().getMobileNo());
        personalDetailsEntity.setEmail(dealersModel.getPersonalDetailsModel().getEmail());
        personalDetailsEntity.setDealersEntity(dealersEntity);
        dealersEntity.setPersonalDetailsEntity(personalDetailsEntity);

        dealersRepository.save(dealersEntity);

    }


    private DealersModel getALLDealers(DealersEntity dealersEntity) {
        System.out.println(dealersEntity);
        DealersModel dealersModel = new DealersModel();
        dealersModel.setId(dealersEntity.getId());
        dealersModel.setName(dealersEntity.getName());
        dealersModel.setLocation(dealersEntity.getLocation());

        List<CarsModel> carsModelList = new ArrayList<>();
        dealersEntity.getCarsEntityList().forEach(o -> {
            CarsModel carsModel = new CarsModel();
            carsModel.setId(o.getId());
            carsModel.setCarName(o.getCarName());
            carsModel.setPrice(o.getPrice());
            carsModel.setQuantity(o.getQuantity());
            dealersModel.setCarsModelList(carsModelList);
            carsModelList.add(carsModel);
        });

        PersonalDetailsModel personalDetailsModel = new PersonalDetailsModel();
        personalDetailsModel.setId(dealersEntity.getPersonalDetailsEntity().getId());
        personalDetailsModel.setMobileNo(dealersEntity.getPersonalDetailsEntity().getMobileNo());
        personalDetailsModel.setEmail(dealersEntity.getPersonalDetailsEntity().getEmail());
        dealersModel.setPersonalDetailsModel(personalDetailsModel);

        return dealersModel;
    }



}


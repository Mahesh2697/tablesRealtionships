package com.oneToOneandMany.tablesRealtionships.controller;

import com.oneToOneandMany.tablesRealtionships.model.DealersModel;
import com.oneToOneandMany.tablesRealtionships.service.DealersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DealersController {
    @Autowired
    public DealersService dealersService;
    @PostMapping("/add-dealers")
    public  void addDealers(@Valid @RequestBody DealersModel dealersModel){dealersService.addDealers(dealersModel);}

    @GetMapping("/get-all-dealers")
    public List<DealersModel> getAll(){
        return dealersService.getALLDealers();
    }

    @GetMapping("/getById/{id}")
    public DealersModel getById(@PathVariable Long id) {return  dealersService.getById(id);}

    @GetMapping("/getByNameId/{id}/{name}")
    public DealersModel getByNameId(@PathVariable Long id, @PathVariable String name){return  dealersService.getByNameAndId(name,id);}


}

package com.dealership.demo.models.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class DealershipRepository {
    @Autowired
    private final DataSource dataSource;


    public DealershipRepository(DataSource dataSource){
        this.dataSource = dataSource;
    }

    //CRUD functions for dealership
    //getAllDealerships, getDealershipById, createDealership, updateDealership, deleteDealership
}

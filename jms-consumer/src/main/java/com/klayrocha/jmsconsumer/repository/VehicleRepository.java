package com.klayrocha.jmsconsumer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.klayrocha.jmsconsumer.model.VehicleHist;

public interface VehicleRepository extends MongoRepository<VehicleHist, String> {

}

package com.qtechlabs.vehiclemanagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.qtechlabs.vehiclemanagement.entity.Vehicle;
@Repository
public interface VehicleManagementRepository extends CrudRepository<Vehicle , Long>{
	

}

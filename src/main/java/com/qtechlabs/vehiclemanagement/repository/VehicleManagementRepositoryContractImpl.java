//package com.qtechlabs.vehiclemanagement.repository;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import com.qtechlabs.vehiclemanagement.entity.Vehicle;
//
//@Repository
//public class VehicleManagementRepositoryContractImpl implements VehicleManagementRepositoryContract {
//
//	@Autowired
//	private VehicleManagementRepository repository;
//
//	@Override
//	public boolean insertIntoDatabase(Vehicle vehicle) {
//		repository.save(vehicle);
//		return true;
//
//	}
//
//	@Override
//	public Vehicle selectFromDatabase(Long vehicleId) {
//		Optional<Vehicle> vehicleOptional = repository.findById(vehicleId);
//		if (vehicleOptional.isPresent()) {
//			Vehicle vehicle = vehicleOptional.get();
//			return vehicle;
//		}
//		return null;
//	}
//	
//	public Vehicle getAllVehicles () {
//
//	@Override
//	public Vehicle updateIntoDatabase( Vehicle vehicle) {
//		Vehicle veh = repository.save(vehicle);
//		return veh;
//
//	}
//
//	@Override
//	public boolean deleteFromDatabse(Long vehicleId) {
//		repository.deleteById(vehicleId);
//		return true;
//	}
//
//}

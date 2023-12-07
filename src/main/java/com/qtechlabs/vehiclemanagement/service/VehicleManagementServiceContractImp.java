package com.qtechlabs.vehiclemanagement.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qtechlabs.vehiclemanagement.dto.VehicleDTO;
import com.qtechlabs.vehiclemanagement.entity.Vehicle;
import com.qtechlabs.vehiclemanagement.repository.VehicleManagementRepository;

@Service
public class VehicleManagementServiceContractImp implements VehicleManagementServiceContract {
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private VehicleManagementRepository repository;

	@Override
	public boolean createVehicle(VehicleDTO vehicleDTO) {
		Vehicle vehicle = modelMapper.map(vehicleDTO, Vehicle.class);
		repository.save(vehicle);
		return true;

		
	}

	@Override
	public VehicleDTO getVehicle(Long vehicleId) {
		Optional<Vehicle> vehicle = repository.findById(vehicleId);
		VehicleDTO vehicleDTO = modelMapper.map(vehicle, VehicleDTO.class);
		return vehicleDTO;
	}

	@Override
	public VehicleDTO updateVehicle(Long vehicleId, VehicleDTO vehicleDTO) {
		Optional<Vehicle> vehicleFromDatabase = repository.findById(vehicleId);
				if(vehicleFromDatabase.isPresent()) {
		Vehicle vehicle = vehicleFromDatabase.get();
		vehicle.setNoOfTyres(vehicle.getNoOfTyres());
		repository.save(vehicle);
		VehicleDTO newvehicleDTO = modelMapper.map(vehicle, VehicleDTO.class);
		
		return newvehicleDTO;
				}
				return null;

	}
	
	
	public List<VehicleDTO> getAllVehicle (){
		List<VehicleDTO> listOfVehicles = new ArrayList<VehicleDTO>();
		Iterable<Vehicle> vehicles = repository.findAll();	
		
		vehicles.forEach( (vehicle) -> {
			listOfVehicles.add(modelMapper.map(vehicle, VehicleDTO.class)); 
			}
		);
		return listOfVehicles;
	}
		
		
		
	

	@Override
	public boolean deleteVehicle(Long vehicleId) {
		repository.deleteById(vehicleId);
		return true;
	}


}

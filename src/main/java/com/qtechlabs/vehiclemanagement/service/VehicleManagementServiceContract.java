package com.qtechlabs.vehiclemanagement.service;

import com.qtechlabs.vehiclemanagement.dto.VehicleDTO;

public interface VehicleManagementServiceContract {

	public boolean createVehicle(VehicleDTO vehicleDTO);

	public VehicleDTO getVehicle(Long vehicleId);

	public VehicleDTO updateVehicle(Long vehicleId, VehicleDTO vehicleDTO);
	
	public boolean deleteVehicle(Long vehicleId);

}

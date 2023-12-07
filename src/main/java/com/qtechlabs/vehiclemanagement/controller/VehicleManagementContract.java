package com.qtechlabs.vehiclemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qtechlabs.vehiclemanagement.dto.VehicleDTO;
import com.qtechlabs.vehiclemanagement.service.VehicleManagementServiceContractImp;

@RestController
public class VehicleManagementContract {

	@Autowired
	private VehicleManagementServiceContractImp service;

	@CrossOrigin
	@PostMapping("/api/v1/vehicle")
	public ResponseEntity<String> createVehicle(@RequestBody VehicleDTO vehicleDTO) {
		service.createVehicle(vehicleDTO);
		return new ResponseEntity<String>("vehicle created", HttpStatus.CREATED);

	}

	@CrossOrigin
	@GetMapping("/api/v1/vehicle/{vehicleId}")
	public ResponseEntity<VehicleDTO> getVehicle(@PathVariable Long vehicleId) {

		VehicleDTO vehicle = service.getVehicle(vehicleId);
		return new ResponseEntity<>(vehicle, HttpStatus.CREATED);

	}

	@CrossOrigin
	@GetMapping("/api/v1/vehicle/allvehicle")
	public ResponseEntity<List<VehicleDTO>> getAllVehicle() {
		List<VehicleDTO> vehicles = service.getAllVehicle();
		return new ResponseEntity<>(vehicles, HttpStatus.OK);

	}

	@PutMapping("/api/v1/vehicle/{vehicleId}")
	public ResponseEntity<VehicleDTO> updateVehicle(@PathVariable Long vehicleId, @RequestBody VehicleDTO vehicleDTO) {
		VehicleDTO updatedVehicle = service.updateVehicle(vehicleId, vehicleDTO);
		return new ResponseEntity<>(updatedVehicle, HttpStatus.OK);
	}

	@DeleteMapping("/api/v1/vehicle/{vehicleId}")
	public ResponseEntity<String> deleteVehicle(@PathVariable Long vehicleId) {
		boolean deleteVehicle = service.deleteVehicle(vehicleId);
		return new ResponseEntity<String>("deleted", HttpStatus.OK);

	}

}

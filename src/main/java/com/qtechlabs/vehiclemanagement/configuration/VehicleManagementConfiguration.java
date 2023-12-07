package com.qtechlabs.vehiclemanagement.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VehicleManagementConfiguration {
	@Bean
	public ModelMapper getmodelmapper() {
		return new ModelMapper();
	}
}

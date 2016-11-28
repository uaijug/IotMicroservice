package br.com.uaijug.iotmicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.uaijug.iotmicroservice.model.domain.Sensor;
import br.com.uaijug.iotmicroservice.model.domain.SensorTO;
import br.com.uaijug.iotmicroservice.service.SensorService;

@RestController
public class SensorController {

	@Autowired
	private SensorService sensorService;

	@RequestMapping("/temperatures")
	public List<Sensor> temperature() {
		return sensorService.getTemperatures();
	}
	
	@RequestMapping("/sensor")
	public SensorTO getNowTemperature() {
		return sensorService.getSensorInfosByArduino();
	}	
	
	
}

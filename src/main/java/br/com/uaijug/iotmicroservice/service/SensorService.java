package br.com.uaijug.iotmicroservice.service;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.uaijug.iotmicroservice.model.domain.Sensor;
import br.com.uaijug.iotmicroservice.model.domain.SensorTO;
import br.com.uaijug.iotmicroservice.model.repository.SensorRepository;

@Service
public class SensorService {

	private static final Logger log = LoggerFactory.getLogger(SensorService.class);

	@Autowired
	private SensorRepository sensorRepository;

	public SensorTO getSensorInfosByArduino() {
		RestTemplate restTemplate = new RestTemplate();
		SensorTO sensorTO = restTemplate.getForObject("http://192.168.15.188:8083", SensorTO.class);
		
		Sensor sensor = new Sensor();
		sensor.setTemperature(sensorTO.getTemperature());
		sensor.setHumidity(sensorTO.getHumidity());
		
		sensorRepository.save(sensor);
		log.info(sensor.toString());
		return sensorTO;
	}

	public List<Sensor> getTemperatures() {
		getSensorTemperaturesByFile();
		return sensorRepository.findAll();
	}

	private void getSensorTemperaturesByFile() {

		File file = new File("/Users/rogeriofontes/Documents/workspace-uaijug/iotmicroservice/sensor.txt");
		String returnSensor;
		try {
			returnSensor = FileUtils.readFileToString(file);
			log.info("Read in: " + returnSensor);
			List<String> lines = FileUtils.readLines(file);

			Collections.sort(lines);

			for (String line : lines) {
				String[] retult = line.split("\\|");
				String temperature = retult[0];
				String humidity = retult[1];
				String sensorId = retult[3];
				log.info("Temperatura = " +temperature + " | Umidade = " + humidity + " | Id do Sensor = " + sensorId);
				//sensorRepository.save(new Sensor(temperature, humidity));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

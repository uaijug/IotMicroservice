package br.com.uaijug.iotmicroservice.service;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.uaijug.iotmicroservice.model.domain.Sensor;
import br.com.uaijug.iotmicroservice.model.repository.SensorRepository;

@Service
public class SensorService {

	private static final Logger log = LoggerFactory.getLogger(SensorService.class);

	@Autowired
	private SensorRepository sensorRepository;

	public String getActivatedCode(Long id) {
		Sensor sensor = sensorRepository.findOne(id);
		UUID resultId = UUID.randomUUID();
		
		String activatedCode = resultId + sensor.getTemperature() + sensor.getHumidity();
		return activatedCode;
	}

	public List<Sensor> getTemperatures() {
		getSensorTemperatures();
		return sensorRepository.findAll();
	}

	private void getSensorTemperatures() {

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
				log.info("Temperatura = " + retult[0] + " | Umidade = " + retult[1]);
				sensorRepository.save(new Sensor(temperature, humidity));
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

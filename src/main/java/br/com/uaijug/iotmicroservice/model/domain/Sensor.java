package br.com.uaijug.iotmicroservice.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sensor")
public class Sensor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String temperature;
	private String humidity;

	public Sensor(String temperature, String humidity) {
		super();
		this.temperature = temperature;
		this.humidity = humidity;
	}

	public Sensor() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	@Override
	public String toString() {
		return "Sensor [id=" + id + ", temperature=" + temperature + ", humidity=" + humidity + "]";
	}

}

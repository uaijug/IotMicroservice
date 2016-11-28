package br.com.uaijug.iotmicroservice.model.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sensor")
public class Sensor implements Serializable {

	private static final long serialVersionUID = -995699492159002648L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private float temperature;
	private float humidity;
	@Column(name = "sensor_id")
	private int sensorId;
	private Date date;

	public Sensor(float temperature, float humidity, int sensorId, Date date) {
		super();
		this.temperature = temperature;
		this.humidity = humidity;
		this.sensorId = sensorId;
		this.date = date;
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

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public float getHumidity() {
		return humidity;
	}

	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}

	public int getSensorId() {
		return sensorId;
	}

	public void setSensorId(int sensorId) {
		this.sensorId = sensorId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Sensor [id=" + id + ", temperature=" + temperature + ", humidity=" + humidity + "]";
	}

}

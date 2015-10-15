package br.com.uaijug.iotmicroservice.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.uaijug.iotmicroservice.model.domain.Sensor;

public interface SensorRepository extends JpaRepository<Sensor, Long> {

}

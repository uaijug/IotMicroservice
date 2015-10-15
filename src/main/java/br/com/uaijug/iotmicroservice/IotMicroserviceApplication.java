package br.com.uaijug.iotmicroservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.uaijug.iotmicroservice.model.repository.AccountRepository;

@SpringBootApplication
public class IotMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(IotMicroserviceApplication.class, args);
	}

	@Bean
	CommandLineRunner init(final AccountRepository accountRepository) {

		return new CommandLineRunner() {

			@Override
			public void run(String... arg0) throws Exception {
				//accountRepository.save(new Account("root", "root"));
			}

		};

	}

}

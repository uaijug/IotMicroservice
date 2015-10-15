package br.com.uaijug.iotmicroservice.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.uaijug.iotmicroservice.model.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
	Account findByUsername(String username);
}

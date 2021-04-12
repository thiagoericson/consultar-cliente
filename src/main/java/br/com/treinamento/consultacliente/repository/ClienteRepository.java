package br.com.treinamento.consultacliente.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.treinamento.consultacliente.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	Page<Cliente> findAll(Pageable pageable);
	
	Page<Cliente> findByPrimeiroNomeContaining(String primeiroNome, Pageable pageable);
	
}

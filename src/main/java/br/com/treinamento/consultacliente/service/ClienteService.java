package br.com.treinamento.consultacliente.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.treinamento.consultacliente.model.Cliente;
import br.com.treinamento.consultacliente.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Page<Cliente> listAllCliente(String nome, Pageable page) {
		if (nome == null)
			return clienteRepository.findAll(page);
		else
			return clienteRepository.findByPrimeiroNomeContaining(nome, page);
	}

	public Cliente getCliente(Integer id) {
		return clienteRepository.findById(id).get();
	}
}

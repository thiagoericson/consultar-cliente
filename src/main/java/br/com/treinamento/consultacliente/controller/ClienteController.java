package br.com.treinamento.consultacliente.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinamento.consultacliente.model.Cliente;
import br.com.treinamento.consultacliente.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	// GET
	@GetMapping("")
	public Page<Cliente> list(@PageableDefault(page = 0, size = 3) Pageable page, @RequestParam(required = false) String nome) {

		return clienteService.listAllCliente(nome, page);

//		List<Cliente> clientes = clienteService.listAllCliente();
//		if (clientes.isEmpty()) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404
//		}
//		return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK); // 200
	}

	// GET (id)
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> get(@PathVariable Integer id) {
		try {
			Cliente cliente = clienteService.getCliente(id);
			return new ResponseEntity<Cliente>(cliente, HttpStatus.OK); // 200
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND); // 404
		}
	}
}

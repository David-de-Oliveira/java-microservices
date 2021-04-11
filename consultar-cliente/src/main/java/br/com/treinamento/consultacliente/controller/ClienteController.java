package br.com.treinamento.consultacliente.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public ResponseEntity<?> list() {
		List<Cliente> clientes = clienteService.listAllCliente();
		
		if (clientes.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
		
		return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
	}
	
	
	// GET (id)
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> get(@PathVariable Integer id) {
		
		try {
		 Cliente cliente = clienteService.getCliente(id);
		 return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		}
	}
}


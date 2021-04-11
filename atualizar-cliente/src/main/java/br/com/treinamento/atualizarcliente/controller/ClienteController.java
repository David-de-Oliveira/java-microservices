package br.com.treinamento.atualizarcliente.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinamento.atualizarcliente.model.Cliente;
import br.com.treinamento.atualizarcliente.model.Salario;
import br.com.treinamento.atualizarcliente.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;

	
	// POST
	@PostMapping("")
	public ResponseEntity<?> add(@RequestBody Cliente cliente) {
		clienteService.saveCliente(cliente);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	// PUT
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Cliente cliente) {
		try {
		 Cliente clienteAtual = clienteService.getCliente(id);
		 cliente.setId(clienteAtual.getId());
		 clienteService.saveCliente(cliente);
		 return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		}
	}

	// PATCH
	@PatchMapping("/{id}/salario")
	public ResponseEntity<?> updateSalario(@PathVariable Integer id, @RequestBody Salario salario) {
		try {
			 Cliente clienteAtual = clienteService.getCliente(id);
			 clienteAtual.setId(clienteAtual.getId());
			 clienteAtual.setSalario(salario.getSalario());
			 clienteService.saveCliente(clienteAtual);
			 return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		}
	}

	// DELETE
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		try {
		 Cliente cliente = clienteService.getCliente(id);
		 clienteService.deleteCliente(cliente.getId());
		 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		}
	}
	
}

package br.com.treinamento.cadastrarendereco.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinamento.cadastrarendereco.model.Cliente;
import br.com.treinamento.cadastrarendereco.model.Endereco;
import br.com.treinamento.cadastrarendereco.service.ClienteService;
import br.com.treinamento.cadastrarendereco.service.EnderecoService;



@RestController
@RequestMapping("/clientes/{idCliente}/enderecos")
public class EnderecoController {
	
	@Autowired
	EnderecoService enderecoService;
	@Autowired
	ClienteService clienteService;
	
	// POST
	@PostMapping("")
	public ResponseEntity<?> add(@PathVariable Integer idCliente, @RequestBody Endereco endereco) {
		try {
		    Cliente cliente = clienteService.getCliente(idCliente);
		    endereco.setCliente(cliente);
		    enderecoService.saveEndereco(endereco);
		    return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}

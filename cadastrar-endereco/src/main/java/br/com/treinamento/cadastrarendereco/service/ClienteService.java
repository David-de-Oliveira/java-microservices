package br.com.treinamento.cadastrarendereco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.treinamento.cadastrarendereco.model.Cliente;
import br.com.treinamento.cadastrarendereco.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente getCliente(Integer id) {
		return clienteRepository.findById(id).get();
	}

}
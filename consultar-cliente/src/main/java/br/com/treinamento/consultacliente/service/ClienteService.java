package br.com.treinamento.consultacliente.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.treinamento.consultacliente.model.Cliente;
import br.com.treinamento.consultacliente.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> listAllCliente() {
		return clienteRepository.findAll();
	}
	
	public Cliente getCliente(Integer id ) {
		return clienteRepository.findById(id).get();
	}
}

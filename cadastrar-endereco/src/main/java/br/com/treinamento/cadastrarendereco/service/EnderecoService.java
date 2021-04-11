package br.com.treinamento.cadastrarendereco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.treinamento.cadastrarendereco.model.Endereco;
import br.com.treinamento.cadastrarendereco.repository.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public void saveEndereco(Endereco endereco) {
		enderecoRepository.save(endereco);
	}
}

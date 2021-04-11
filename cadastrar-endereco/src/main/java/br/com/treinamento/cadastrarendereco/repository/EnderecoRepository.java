package br.com.treinamento.cadastrarendereco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.treinamento.cadastrarendereco.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}

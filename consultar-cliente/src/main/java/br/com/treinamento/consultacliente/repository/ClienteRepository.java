package br.com.treinamento.consultacliente.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.treinamento.consultacliente.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}

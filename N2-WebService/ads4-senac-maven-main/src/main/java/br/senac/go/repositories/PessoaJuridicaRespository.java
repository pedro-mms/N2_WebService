package br.senac.go.repositories;

import br.senac.go.domain.PessoaJuridica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaJuridicaRespository extends JpaRepository<PessoaJuridica, Integer> {
}

package br.gov.sp.etecsebrae.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.etecsebrae.entity.ServicoEntity;

public interface ServicoRepository extends JpaRepository<ServicoEntity, Integer> {
	default Optional<ServicoEntity> getByServico(String servico) {
		return this.findAll().stream().filter(entity -> servico.equalsIgnoreCase(entity.getServico())).findAny();
	}
}

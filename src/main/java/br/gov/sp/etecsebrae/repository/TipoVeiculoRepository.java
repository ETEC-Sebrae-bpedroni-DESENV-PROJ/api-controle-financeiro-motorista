package br.gov.sp.etecsebrae.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.etecsebrae.entity.TipoVeiculoEntity;

public interface TipoVeiculoRepository extends JpaRepository<TipoVeiculoEntity, Integer> {
	default Optional<TipoVeiculoEntity> getByTipo(String tipo) {
		return this.findAll().stream().filter(entity -> tipo.equalsIgnoreCase(entity.getTipo())).findAny();
	}
}

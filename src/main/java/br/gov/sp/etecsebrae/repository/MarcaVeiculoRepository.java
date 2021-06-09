package br.gov.sp.etecsebrae.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.etecsebrae.entity.MarcaVeiculoEntity;

public interface MarcaVeiculoRepository extends JpaRepository<MarcaVeiculoEntity, Integer> {
	default Optional<MarcaVeiculoEntity> getByMarca(String marca) {
		return this.findAll().stream().filter(entity -> marca.equalsIgnoreCase(entity.getMarca())).findAny();
	}
}

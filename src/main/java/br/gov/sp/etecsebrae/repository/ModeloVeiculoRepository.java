package br.gov.sp.etecsebrae.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.etecsebrae.entity.ModeloVeiculoEntity;

public interface ModeloVeiculoRepository extends JpaRepository<ModeloVeiculoEntity, Integer> {
	default Optional<ModeloVeiculoEntity> getByValues(int idTipo, int idMarca, String modelo) {
		return this
				.findAll().stream().filter(entity -> idTipo == entity.getTipo().getId()
						&& idMarca == entity.getMarca().getId() && modelo.equalsIgnoreCase(entity.getModelo()))
				.findAny();
	}
}

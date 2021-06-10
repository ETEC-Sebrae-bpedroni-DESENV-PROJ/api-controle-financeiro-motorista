package br.gov.sp.etecsebrae.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.sp.etecsebrae.entity.VeiculoEntity;

@Repository
public interface VeiculoRepository extends JpaRepository<VeiculoEntity, Integer> {
	default Optional<VeiculoEntity> getByCondutorAndPlaca(int idCondutor, String placa) {
		return this.findAll().stream().filter(
				entity -> idCondutor == entity.getCondutor().getId() && placa.equalsIgnoreCase(entity.getPlaca()))
				.findAny();
	}
}

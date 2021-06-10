package br.gov.sp.etecsebrae.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.sp.etecsebrae.entity.TipoCombustivelEntity;

@Repository
public interface TipoCombustivelRepository extends JpaRepository<TipoCombustivelEntity, Integer> {
	default Optional<TipoCombustivelEntity> getByTipoCombustivel(String tipoCombustivel) {
		return this.findAll().stream().filter(entity -> tipoCombustivel.equalsIgnoreCase(entity.getTipoCombustivel()))
				.findAny();
	}
}

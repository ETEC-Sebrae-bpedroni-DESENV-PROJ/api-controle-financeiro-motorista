package br.gov.sp.etecsebrae.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.sp.etecsebrae.entity.CondutorEntity;

@Repository
public interface CondutorRepository extends JpaRepository<CondutorEntity, Integer> {
	default Optional<CondutorEntity> getByEmail(String email) {
		return this.findAll().stream().filter(entity -> email.equalsIgnoreCase(entity.getEmail())).findAny();
	}
}

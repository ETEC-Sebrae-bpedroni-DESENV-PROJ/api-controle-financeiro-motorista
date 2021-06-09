package br.gov.sp.etecsebrae.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.etecsebrae.dto.TipoCombustivel;
import br.gov.sp.etecsebrae.entity.TipoCombustivelEntity;
import br.gov.sp.etecsebrae.repository.TipoCombustivelRepository;

@Service
public class TipoCombustivelService {
	@Autowired
	private TipoCombustivelRepository repository;

	public List<TipoCombustivel> getAll() {
		List<TipoCombustivelEntity> list = repository.findAll();
		return fromTo(list);
	}

	public TipoCombustivel getById(int id) {
		TipoCombustivelEntity entity = repository.getById(id);
		return fromTo(entity);
	}

	public TipoCombustivel save(TipoCombustivel dto) {
		TipoCombustivelEntity entity = repository.save(fromTo(dto));
		return fromTo(entity);
	}

	public void delete(TipoCombustivel dto) {
		repository.delete(fromTo(dto));
	}

	private TipoCombustivel fromTo(TipoCombustivelEntity entity) {
		return new TipoCombustivel(entity.getId(), entity.getTipoCombustivel());
	}

	private List<TipoCombustivel> fromTo(List<TipoCombustivelEntity> list) {
		List<TipoCombustivel> dtoList = new ArrayList<TipoCombustivel>();
		for (TipoCombustivelEntity entity : list) {
			dtoList.add(fromTo(entity));
		}
		return dtoList;
	}

	private TipoCombustivelEntity fromTo(TipoCombustivel dto) {
		return new TipoCombustivelEntity(dto.getId(), dto.getTipoCombustivel());
	}
}

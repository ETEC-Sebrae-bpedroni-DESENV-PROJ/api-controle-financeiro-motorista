package br.gov.sp.etecsebrae.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.etecsebrae.dto.TipoCombustivel;
import br.gov.sp.etecsebrae.entity.TipoCombustivelEntity;
import br.gov.sp.etecsebrae.repository.TipoCombustivelRepository;

@Service
public class TipoCombustivelService {
	@Autowired
	private TipoCombustivelRepository repository;

	@Autowired
	VeiculoService veiculoService;

	public List<TipoCombustivel> getAll() {
		List<TipoCombustivelEntity> list = repository.findAll();
		return fromTo(list);
	}

	public TipoCombustivel getById(int id) throws Exception {
		try {
			TipoCombustivelEntity entity = repository.getById(id);
			return fromTo(entity);
		} catch (Exception e) {
			throw new Exception("O tipo do combustível não foi encontrado no sistema.");
		}
	}

	public TipoCombustivel save(TipoCombustivel dto) throws Exception {
		if (dto.getTipoCombustivel() == null || dto.getTipoCombustivel().trim().isEmpty()) {
			throw new Exception("O tipo do combustível não pode estar em branco.");
		}
		Optional<TipoCombustivelEntity> record = repository.getByTipoCombustivel(dto.getTipoCombustivel());
		if (record.isPresent() && record.get().getId() != dto.getId()) {
			throw new Exception("O tipo do combustível fornecido já possui cadastro no sistema.");
		}
		TipoCombustivelEntity entity = repository.save(fromTo(dto));
		return fromTo(entity);
	}

	public void delete(TipoCombustivel dto) {
		repository.delete(fromTo(dto));
	}

	public TipoCombustivel fromTo(TipoCombustivelEntity entity) {
		TipoCombustivel dto = new TipoCombustivel(entity.getId(), entity.getTipoCombustivel());
		dto.setVeiculos(veiculoService.fromTo(entity.getVeiculos()));
		return dto;
	}

	public List<TipoCombustivel> fromTo(List<TipoCombustivelEntity> list) {
		List<TipoCombustivel> dtoList = new ArrayList<TipoCombustivel>();
		for (TipoCombustivelEntity entity : list) {
			dtoList.add(fromTo(entity));
		}
		return dtoList;
	}

	public TipoCombustivelEntity fromTo(TipoCombustivel dto) {
		return new TipoCombustivelEntity(dto.getId(), dto.getTipoCombustivel());
	}
}

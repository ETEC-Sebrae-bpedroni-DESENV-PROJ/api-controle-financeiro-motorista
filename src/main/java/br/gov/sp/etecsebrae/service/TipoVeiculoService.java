package br.gov.sp.etecsebrae.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.etecsebrae.dto.TipoVeiculo;
import br.gov.sp.etecsebrae.entity.TipoVeiculoEntity;
import br.gov.sp.etecsebrae.repository.TipoVeiculoRepository;

@Service
public class TipoVeiculoService {
	@Autowired
	private TipoVeiculoRepository repository;

	@Autowired
	ModeloVeiculoService modeloVeiculoService;

	public List<TipoVeiculo> getAll() {
		List<TipoVeiculoEntity> list = repository.findAll();
		return fromTo(list);
	}

	public TipoVeiculo getById(int id) throws Exception {
		try {
			TipoVeiculoEntity entity = repository.getById(id);
			return fromTo(entity);
		} catch (Exception e) {
			throw new Exception("O tipo do veículo não foi encontrado no sistema.");
		}
	}

	public TipoVeiculo save(TipoVeiculo dto) throws Exception {
		if (dto.getTipo() == null || dto.getTipo().trim().isEmpty()) {
			throw new Exception("O tipo não pode estar em branco.");
		}
		Optional<TipoVeiculoEntity> record = repository.getByTipo(dto.getTipo());
		if (record.isPresent() && record.get().getId() != dto.getId()) {
			throw new Exception("O tipo fornecido já possui cadastro no sistema.");
		}
		TipoVeiculoEntity entity = repository.save(fromTo(dto));
		return fromTo(entity);
	}

	public void delete(TipoVeiculo dto) {
		repository.delete(fromTo(dto));
	}

	public TipoVeiculo fromTo(TipoVeiculoEntity entity) {
		TipoVeiculo dto = new TipoVeiculo(entity.getId(), entity.getTipo());
		dto.setModelos(modeloVeiculoService.fromTo(entity.getModelos()));
		return dto;
	}

	public List<TipoVeiculo> fromTo(List<TipoVeiculoEntity> list) {
		List<TipoVeiculo> dtoList = new ArrayList<TipoVeiculo>();
		for (TipoVeiculoEntity entity : list) {
			dtoList.add(fromTo(entity));
		}
		return dtoList;
	}

	public TipoVeiculoEntity fromTo(TipoVeiculo dto) {
		return new TipoVeiculoEntity(dto.getId(), dto.getTipo());
	}
}

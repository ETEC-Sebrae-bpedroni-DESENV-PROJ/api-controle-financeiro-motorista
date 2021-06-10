package br.gov.sp.etecsebrae.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.etecsebrae.dto.MarcaVeiculo;
import br.gov.sp.etecsebrae.entity.MarcaVeiculoEntity;
import br.gov.sp.etecsebrae.repository.MarcaVeiculoRepository;

@Service
public class MarcaVeiculoService {
	@Autowired
	private MarcaVeiculoRepository repository;

	@Autowired
	ModeloVeiculoService modeloVeiculoService;

	public List<MarcaVeiculo> getAll() {
		List<MarcaVeiculoEntity> list = repository.findAll();
		return fromTo(list);
	}

	public MarcaVeiculo getById(int id) throws Exception {
		try {
			MarcaVeiculoEntity entity = repository.getById(id);
			return fromTo(entity);
		} catch (Exception e) {
			throw new Exception("A marca do veículo não foi encontrada no sistema.");
		}
	}

	public MarcaVeiculo save(MarcaVeiculo dto) throws Exception {
		if (dto.getMarca() == null || dto.getMarca().trim().isEmpty()) {
			throw new Exception("A marca não pode estar em branco.");
		}
		Optional<MarcaVeiculoEntity> record = repository.getByMarca(dto.getMarca());
		if (record.isPresent() && record.get().getId() != dto.getId()) {
			throw new Exception("A marca fornecida já possui cadastro no sistema.");
		}
		MarcaVeiculoEntity entity = repository.save(fromTo(dto));
		return fromTo(entity);
	}

	public void delete(MarcaVeiculo dto) {
		repository.delete(fromTo(dto));
	}

	public MarcaVeiculo fromTo(MarcaVeiculoEntity entity) {
		MarcaVeiculo dto = new MarcaVeiculo(entity.getId(), entity.getMarca());
		dto.setModelos(modeloVeiculoService.fromTo(entity.getModelos()));
		return dto;
	}

	public List<MarcaVeiculo> fromTo(List<MarcaVeiculoEntity> list) {
		List<MarcaVeiculo> dtoList = new ArrayList<MarcaVeiculo>();
		for (MarcaVeiculoEntity entity : list) {
			dtoList.add(fromTo(entity));
		}
		return dtoList;
	}

	public MarcaVeiculoEntity fromTo(MarcaVeiculo dto) {
		return new MarcaVeiculoEntity(dto.getId(), dto.getMarca());
	}
}

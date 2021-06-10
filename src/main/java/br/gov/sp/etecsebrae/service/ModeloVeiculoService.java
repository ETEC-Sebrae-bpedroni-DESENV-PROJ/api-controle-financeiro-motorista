package br.gov.sp.etecsebrae.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.etecsebrae.dto.ModeloVeiculo;
import br.gov.sp.etecsebrae.entity.MarcaVeiculoEntity;
import br.gov.sp.etecsebrae.entity.ModeloVeiculoEntity;
import br.gov.sp.etecsebrae.entity.TipoVeiculoEntity;
import br.gov.sp.etecsebrae.repository.ModeloVeiculoRepository;

@Service
public class ModeloVeiculoService {
	@Autowired
	private ModeloVeiculoRepository repository;

	@Autowired
	private TipoVeiculoService tipoVeiculoService;

	@Autowired
	private MarcaVeiculoService marcaVeiculoService;

	@Autowired
	VeiculoService veiculoService;

	public List<ModeloVeiculo> getAll() {
		List<ModeloVeiculoEntity> list = repository.findAll();
		return fromTo(list);
	}

	public ModeloVeiculo getById(int id) throws Exception {
		try {
			ModeloVeiculoEntity entity = repository.getById(id);
			return fromTo(entity);
		} catch (Exception e) {
			throw new Exception("O modelo do veículo não foi encontrado no sistema.");
		}
	}

	public ModeloVeiculo save(ModeloVeiculo dto) throws Exception {
		if (dto.getModelo() == null || dto.getModelo().trim().isEmpty()) {
			throw new Exception("O modelo não pode estar em branco.");
		}
		Optional<ModeloVeiculoEntity> record = repository.getByValues(dto.getIdTipoVeiculo(), dto.getIdMarcaVeiculo(),
				dto.getModelo());
		if (record.isPresent() && record.get().getId() != dto.getId()) {
			throw new Exception("O modelo fornecido já possui cadastro no sistema.");
		}
		ModeloVeiculoEntity entity = repository.save(fromTo(dto));
		return fromTo(entity);
	}

	public void delete(ModeloVeiculo dto) throws Exception {
		repository.delete(fromTo(dto));
	}

	public ModeloVeiculo fromTo(ModeloVeiculoEntity entity) {
		ModeloVeiculo dto = new ModeloVeiculo(entity.getId(), entity.getTipo().getId(), entity.getMarca().getId(),
				entity.getModelo());
		dto.setTipoVeiculo(tipoVeiculoService.fromTo(entity.getTipo()));
		dto.setMarcaVeiculo(marcaVeiculoService.fromTo(entity.getMarca()));
		dto.setVeiculos(veiculoService.fromTo(entity.getVeiculos()));
		return dto;
	}

	public List<ModeloVeiculo> fromTo(List<ModeloVeiculoEntity> list) {
		List<ModeloVeiculo> dtoList = new ArrayList<ModeloVeiculo>();
		for (ModeloVeiculoEntity entity : list) {
			dtoList.add(fromTo(entity));
		}
		return dtoList;
	}

	public ModeloVeiculoEntity fromTo(ModeloVeiculo dto) throws Exception {
		TipoVeiculoEntity tipoVeiculo = tipoVeiculoService.fromTo(tipoVeiculoService.getById(dto.getIdTipoVeiculo()));
		MarcaVeiculoEntity marcaVeiculo = marcaVeiculoService
				.fromTo(marcaVeiculoService.getById(dto.getIdMarcaVeiculo()));
		return new ModeloVeiculoEntity(dto.getId(), tipoVeiculo, marcaVeiculo, dto.getModelo());
	}
}

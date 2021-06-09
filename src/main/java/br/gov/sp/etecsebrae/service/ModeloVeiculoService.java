package br.gov.sp.etecsebrae.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.etecsebrae.dto.ModeloVeiculo;
import br.gov.sp.etecsebrae.entity.MarcaVeiculoEntity;
import br.gov.sp.etecsebrae.entity.ModeloVeiculoEntity;
import br.gov.sp.etecsebrae.entity.TipoVeiculoEntity;
import br.gov.sp.etecsebrae.repository.MarcaVeiculoRepository;
import br.gov.sp.etecsebrae.repository.ModeloVeiculoRepository;
import br.gov.sp.etecsebrae.repository.TipoVeiculoRepository;

@Service
public class ModeloVeiculoService {
	@Autowired
	private ModeloVeiculoRepository repository;

	@Autowired
	private TipoVeiculoRepository tipoVeiculoRepository;

	@Autowired
	private MarcaVeiculoRepository marcaVeiculoRepository;

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
		if (dto.getModelo().isBlank()) {
			throw new Exception("O modelo não pode estar em branco.");
		}
		var record = repository.getByValues(dto.getIdTipoVeiculo(), dto.getIdMarcaVeiculo(), dto.getModelo());
		if (record.isPresent() && record.get().getId() != dto.getId()) {
			throw new Exception("O modelo fornecido já possui cadastro no sistema.");
		}
		ModeloVeiculoEntity entity = repository.save(fromTo(dto));
		return fromTo(entity);
	}

	public void delete(ModeloVeiculo dto) {
		repository.delete(fromTo(dto));
	}

	private ModeloVeiculo fromTo(ModeloVeiculoEntity entity) {
		return new ModeloVeiculo(entity.getId(), entity.getTipo().getId(), entity.getMarca().getId(),
				entity.getModelo());
	}

	private List<ModeloVeiculo> fromTo(List<ModeloVeiculoEntity> list) {
		List<ModeloVeiculo> dtoList = new ArrayList<ModeloVeiculo>();
		for (ModeloVeiculoEntity entity : list) {
			dtoList.add(fromTo(entity));
		}
		return dtoList;
	}

	private ModeloVeiculoEntity fromTo(ModeloVeiculo dto) {
		TipoVeiculoEntity tipoVeiculo = tipoVeiculoRepository.getById(dto.getIdTipoVeiculo());
		MarcaVeiculoEntity marcaVeiculo = marcaVeiculoRepository.getById(dto.getIdMarcaVeiculo());
		return new ModeloVeiculoEntity(dto.getId(), tipoVeiculo, marcaVeiculo, dto.getModelo());
	}
}

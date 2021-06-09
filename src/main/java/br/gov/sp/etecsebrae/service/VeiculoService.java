package br.gov.sp.etecsebrae.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.etecsebrae.dto.Veiculo;
import br.gov.sp.etecsebrae.entity.CondutorEntity;
import br.gov.sp.etecsebrae.entity.ModeloVeiculoEntity;
import br.gov.sp.etecsebrae.entity.TipoCombustivelEntity;
import br.gov.sp.etecsebrae.entity.VeiculoEntity;
import br.gov.sp.etecsebrae.repository.CondutorRepository;
import br.gov.sp.etecsebrae.repository.ModeloVeiculoRepository;
import br.gov.sp.etecsebrae.repository.TipoCombustivelRepository;
import br.gov.sp.etecsebrae.repository.VeiculoRepository;

@Service
public class VeiculoService {
	@Autowired
	private VeiculoRepository repository;

	@Autowired
	private CondutorRepository condutorRepository;

	@Autowired
	private ModeloVeiculoRepository modeloVeiculoRepository;

	@Autowired
	private TipoCombustivelRepository tipoCombustivelRepository;

	public List<Veiculo> getAll() {
		List<VeiculoEntity> list = repository.findAll();
		return fromTo(list);
	}

	public Veiculo getById(int id) throws Exception {
		try {
			VeiculoEntity entity = repository.getById(id);
			return fromTo(entity);
		} catch (Exception e) {
			throw new Exception("O veículo não foi encontrado no sistema.");
		}
	}

	public Veiculo save(Veiculo dto) throws Exception {
		if (dto.getPlaca().isBlank()) {
			throw new Exception("A placa não pode estar em branco.");
		}
		if (dto.getImagem().isBlank()) {
			throw new Exception("A imagem não pode estar em branco.");
		}
		if (dto.getCor().isBlank()) {
			throw new Exception("A cor não pode estar em branco.");
		}
		var record = repository.getByCondutorAndPlaca(dto.getIdCondutor(), dto.getPlaca());
		if (record.isPresent() && record.get().getId() != dto.getId()) {
			throw new Exception("O veículo fornecido já possui cadastro no sistema.");
		}
		VeiculoEntity entity = repository.save(fromTo(dto));
		return fromTo(entity);
	}

	public void delete(Veiculo dto) {
		repository.delete(fromTo(dto));
	}

	private Veiculo fromTo(VeiculoEntity entity) {
		return new Veiculo(entity.getId(), entity.getCondutor().getId(), entity.getModelo().getId(), entity.getPlaca(),
				entity.getImagem(), entity.getCor(), entity.getAno(), entity.getTipoCombustivel().getId(),
				entity.getMediaKml());
	}

	private List<Veiculo> fromTo(List<VeiculoEntity> list) {
		List<Veiculo> dtoList = new ArrayList<Veiculo>();
		for (VeiculoEntity entity : list) {
			dtoList.add(fromTo(entity));
		}
		return dtoList;
	}

	private VeiculoEntity fromTo(Veiculo dto) {
		CondutorEntity condutor = condutorRepository.getById(dto.getIdCondutor());
		ModeloVeiculoEntity modeloVeiculo = modeloVeiculoRepository.getById(dto.getIdModeloVeiculo());
		TipoCombustivelEntity tipoCombustivel = tipoCombustivelRepository.getById(dto.getIdTipoCombustivel());
		return new VeiculoEntity(dto.getId(), condutor, modeloVeiculo, dto.getPlaca(), dto.getImagem(), dto.getCor(),
				dto.getAno(), tipoCombustivel, dto.getMediaKml());
	}
}

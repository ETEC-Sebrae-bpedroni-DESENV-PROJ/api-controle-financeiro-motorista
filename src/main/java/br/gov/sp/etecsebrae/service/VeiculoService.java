package br.gov.sp.etecsebrae.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.etecsebrae.dto.Veiculo;
import br.gov.sp.etecsebrae.entity.CondutorEntity;
import br.gov.sp.etecsebrae.entity.ModeloVeiculoEntity;
import br.gov.sp.etecsebrae.entity.TipoCombustivelEntity;
import br.gov.sp.etecsebrae.entity.VeiculoEntity;
import br.gov.sp.etecsebrae.repository.VeiculoRepository;

@Service
public class VeiculoService {
	@Autowired
	private VeiculoRepository repository;

	@Autowired
	private CondutorService condutorService;

	@Autowired
	private ModeloVeiculoService modeloVeiculoService;

	@Autowired
	private TipoCombustivelService tipoCombustivelService;

	@Autowired
	LancamentoService lancamentoService;

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
		if (dto.getPlaca() == null || dto.getPlaca().trim().isEmpty()) {
			throw new Exception("A placa não pode estar em branco.");
		}
		if (dto.getCor() == null || dto.getCor().trim().isEmpty()) {
			throw new Exception("A cor não pode estar em branco.");
		}
		Optional<VeiculoEntity> record = repository.getByCondutorAndPlaca(dto.getIdCondutor(), dto.getPlaca());
		if (record.isPresent() && record.get().getId() != dto.getId()) {
			throw new Exception("O veículo fornecido já possui cadastro no sistema.");
		}
		VeiculoEntity entity = repository.save(fromTo(dto));
		return fromTo(entity);
	}

	public void delete(Veiculo dto) throws Exception {
		repository.delete(fromTo(dto));
	}

	public Veiculo fromTo(VeiculoEntity entity) {
		Veiculo dto = new Veiculo(entity.getId(), entity.getCondutor().getId(), entity.getModelo().getId(),
				entity.getPlaca(), entity.getImagem(), entity.getCor(), entity.getAno(),
				entity.getTipoCombustivel().getId(), entity.getMediaKml());
		dto.setCondutor(condutorService.fromTo(entity.getCondutor()));
		dto.setModeloVeiculo(modeloVeiculoService.fromTo(entity.getModelo()));
		dto.setTipoCombustivel(tipoCombustivelService.fromTo(entity.getTipoCombustivel()));
		dto.setLancamentos(lancamentoService.fromTo(entity.getLancamentos()));
		return dto;
	}

	public List<Veiculo> fromTo(List<VeiculoEntity> list) {
		List<Veiculo> dtoList = new ArrayList<Veiculo>();
		for (VeiculoEntity entity : list) {
			dtoList.add(fromTo(entity));
		}
		return dtoList;
	}

	public VeiculoEntity fromTo(Veiculo dto) throws Exception {
		CondutorEntity condutor = condutorService.fromTo(condutorService.getById(dto.getIdCondutor()));
		ModeloVeiculoEntity modeloVeiculo = modeloVeiculoService
				.fromTo(modeloVeiculoService.getById(dto.getIdModeloVeiculo()));
		TipoCombustivelEntity tipoCombustivel = tipoCombustivelService
				.fromTo(tipoCombustivelService.getById(dto.getIdTipoCombustivel()));
		return new VeiculoEntity(dto.getId(), condutor, modeloVeiculo, dto.getPlaca(), dto.getImagem(), dto.getCor(),
				dto.getAno(), tipoCombustivel, dto.getMediaKml());
	}
}

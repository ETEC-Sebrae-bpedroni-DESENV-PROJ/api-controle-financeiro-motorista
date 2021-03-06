package br.gov.sp.etecsebrae.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.etecsebrae.dto.Lancamento;
import br.gov.sp.etecsebrae.entity.CondutorEntity;
import br.gov.sp.etecsebrae.entity.LancamentoEntity;
import br.gov.sp.etecsebrae.entity.ServicoEntity;
import br.gov.sp.etecsebrae.repository.LancamentoRepository;

@Service
public class LancamentoService {
	@Autowired
	private LancamentoRepository repository;

	@Autowired
	private CondutorService condutorService;

	@Autowired
	private ServicoService servicoService;

	public List<Lancamento> getAll() {
		List<LancamentoEntity> list = repository.findAll();
		return fromTo(list);
	}

	public List<Lancamento> getByIdCondutor(int idCondutor) throws Exception {
		try {
			List<LancamentoEntity> list = repository.findAll().stream()
					.filter(p -> p.getCondutor().getId() == idCondutor).collect(Collectors.toList());
			return fromTo(list);
		} catch (Exception e) {
			throw new Exception("Os lançamentos do condutor não foram encontrado no sistema.");
		}
	}

	public Lancamento getById(int id) throws Exception {
		try {
			LancamentoEntity entity = repository.getById(id);
			return fromTo(entity);
		} catch (Exception e) {
			throw new Exception("O lançamento não foi encontrado no sistema.");
		}
	}

	public Lancamento save(Lancamento dto) throws Exception {
		if (dto.getDescricao() == null || dto.getDescricao().trim().isEmpty()) {
			throw new Exception("A descrição não pode estar em branco.");
		}
		LancamentoEntity entity = repository.save(fromTo(dto));
		return fromTo(entity);
	}

	public void delete(Lancamento dto) throws Exception {
		repository.delete(fromTo(dto));
	}

	public Lancamento fromTo(LancamentoEntity entity) {
		Lancamento dto = new Lancamento(entity.getId(), entity.getCondutor().getId(), entity.getServico().getId(),
				entity.getEntrada(), entity.getValor(), entity.getData(), entity.getDescricao(),
				entity.getInfoAdicional());
		dto.setCondutor(condutorService.fromTo(entity.getCondutor()));
		dto.setServico(servicoService.fromTo(entity.getServico()));
		return dto;
	}

	public List<Lancamento> fromTo(List<LancamentoEntity> list) {
		List<Lancamento> dtoList = new ArrayList<Lancamento>();
		for (LancamentoEntity entity : list) {
			dtoList.add(fromTo(entity));
		}
		return dtoList;
	}

	public LancamentoEntity fromTo(Lancamento dto) throws Exception {
		CondutorEntity condutor = condutorService.fromTo(condutorService.getById(dto.getIdCondutor()));
		ServicoEntity servico = servicoService.fromTo(servicoService.getById(dto.getIdServico()));
		return new LancamentoEntity(dto.getId(), condutor, servico, dto.getEntrada(), dto.getValor(), dto.getData(),
				dto.getDescricao(), dto.getInfoAdicional());
	}
}

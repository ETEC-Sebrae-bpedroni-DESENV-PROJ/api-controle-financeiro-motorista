package br.gov.sp.etecsebrae.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.etecsebrae.dto.Lancamento;
import br.gov.sp.etecsebrae.entity.LancamentoEntity;
import br.gov.sp.etecsebrae.entity.ServicoEntity;
import br.gov.sp.etecsebrae.entity.VeiculoEntity;
import br.gov.sp.etecsebrae.repository.LancamentoRepository;
import br.gov.sp.etecsebrae.repository.ServicoRepository;
import br.gov.sp.etecsebrae.repository.VeiculoRepository;

@Service
public class LancamentoService {
	@Autowired
	private LancamentoRepository repository;

	@Autowired
	private VeiculoRepository veiculoRepository;

	@Autowired
	private ServicoRepository servicoRepository;

	public List<Lancamento> getAll() {
		List<LancamentoEntity> list = repository.findAll();
		return fromTo(list);
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

	public void delete(Lancamento dto) {
		repository.delete(fromTo(dto));
	}

	private Lancamento fromTo(LancamentoEntity entity) {
		return new Lancamento(entity.getId(), entity.getVeiculo().getId(), entity.getServico().getId(),
				entity.getValor(), entity.getData(), entity.getDescricao(), entity.getInfoAdicional());
	}

	private List<Lancamento> fromTo(List<LancamentoEntity> list) {
		List<Lancamento> dtoList = new ArrayList<Lancamento>();
		for (LancamentoEntity entity : list) {
			dtoList.add(fromTo(entity));
		}
		return dtoList;
	}

	private LancamentoEntity fromTo(Lancamento dto) {
		VeiculoEntity veiculo = veiculoRepository.getById(dto.getIdVeiculo());
		ServicoEntity servico = servicoRepository.getById(dto.getIdServico());
		return new LancamentoEntity(dto.getId(), veiculo, servico, dto.getValor(), dto.getData(), dto.getDescricao(),
				dto.getInfoAdicional());
	}
}

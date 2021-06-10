package br.gov.sp.etecsebrae.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.etecsebrae.dto.Servico;
import br.gov.sp.etecsebrae.entity.ServicoEntity;
import br.gov.sp.etecsebrae.repository.ServicoRepository;

@Service
public class ServicoService {
	@Autowired
	private ServicoRepository repository;

	public List<Servico> getAll() {
		List<ServicoEntity> list = repository.findAll();
		return fromTo(list);
	}

	public Servico getById(int id) throws Exception {
		try {
			ServicoEntity entity = repository.getById(id);
			return fromTo(entity);
		} catch (Exception e) {
			throw new Exception("O serviço não foi encontrado no sistema.");
		}
	}

	public Servico save(Servico dto) throws Exception {
		if (dto.getServico() == null || dto.getServico().trim().isEmpty()) {
			throw new Exception("O serviço não pode estar em branco.");
		}
		Optional<ServicoEntity> record = repository.getByServico(dto.getServico());
		if (record.isPresent() && record.get().getId() != dto.getId()) {
			throw new Exception("O serviço fornecido já possui cadastro no sistema.");
		}
		ServicoEntity entity = repository.save(fromTo(dto));
		return fromTo(entity);
	}

	public void delete(Servico dto) {
		repository.delete(fromTo(dto));
	}

	public Servico fromTo(ServicoEntity entity) {
		Servico dto = new Servico(entity.getId(), entity.getServico(), entity.getImagem());
		return dto;
	}

	public List<Servico> fromTo(List<ServicoEntity> list) {
		List<Servico> dtoList = new ArrayList<Servico>();
		for (ServicoEntity entity : list) {
			dtoList.add(fromTo(entity));
		}
		return dtoList;
	}

	public ServicoEntity fromTo(Servico dto) {
		return new ServicoEntity(dto.getId(), dto.getServico(), dto.getImagem());
	}
}

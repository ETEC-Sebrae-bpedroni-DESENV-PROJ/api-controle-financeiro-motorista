package br.gov.sp.etecsebrae.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.etecsebrae.dto.Condutor;
import br.gov.sp.etecsebrae.entity.CondutorEntity;
import br.gov.sp.etecsebrae.repository.CondutorRepository;

@Service
public class CondutorService {
	@Autowired
	private CondutorRepository repository;

	public List<Condutor> getAll() {
		List<CondutorEntity> list = repository.findAll();
		return fromTo(list);
	}

	public Condutor getById(int id) throws Exception {
		try {
			CondutorEntity entity = repository.getById(id);
			return fromTo(entity);
		} catch (Exception e) {
			throw new Exception("O condutor não foi encontrado no sistema.");
		}
	}

	public Condutor getByEmail(String email) throws Exception {
		try {
			CondutorEntity entity = repository.getByEmail(email).get();
			return fromTo(entity);
		} catch (Exception e) {
			throw new Exception("O condutor não foi encontrado no sistema.");
		}
	}

	public Condutor save(Condutor dto) throws Exception {
		if (dto.getNome() == null || dto.getNome().trim().isEmpty()) {
			throw new Exception("O nome não pode estar em branco.");
		}
		if (dto.getSobrenome() == null || dto.getSobrenome().trim().isEmpty()) {
			throw new Exception("O sobrenome não pode estar em branco.");
		}
		if (dto.getEmail() == null || dto.getEmail().trim().isEmpty()) {
			throw new Exception("O e-mail não pode estar em branco.");
		}
		if (dto.getSenha() == null || dto.getSenha().trim().isEmpty()) {
			throw new Exception("A senha não pode estar em branco.");
		}
		if (dto.getTelefone() == null || dto.getTelefone().trim().isEmpty()) {
			throw new Exception("O telefone não pode estar em branco.");
		}
		if (dto.getEnderecoCep() == null || dto.getEnderecoCep().trim().isEmpty()) {
			throw new Exception("O CEP do endereço não pode estar em branco.");
		}
		if (dto.getEnderecoLogradouro() == null || dto.getEnderecoLogradouro().trim().isEmpty()) {
			throw new Exception("O logradouro do endereço não pode estar em branco.");
		}
		if (dto.getEnderecoNumero() == null || dto.getEnderecoNumero().trim().isEmpty()) {
			throw new Exception("O número do endereço não pode estar em branco.");
		}
		if (dto.getEnderecoBairro() == null || dto.getEnderecoBairro().trim().isEmpty()) {
			throw new Exception("O bairo do endereço não pode estar em branco.");
		}
		if (dto.getEnderecoCidade() == null || dto.getEnderecoCidade().trim().isEmpty()) {
			throw new Exception("A cidade do endereço não pode estar em branco.");
		}
		if (dto.getEnderecoEstado() == null || dto.getEnderecoEstado().trim().isEmpty()) {
			throw new Exception("O estado do endereço não pode estar em branco.");
		}
		var record = repository.getByEmail(dto.getEmail());
		if (record.isPresent() && record.get().getId() != dto.getId()) {
			throw new Exception("O e-mail fornecido já possui cadastro no sistema.");
		}
		CondutorEntity entity = repository.save(fromTo(dto));
		return fromTo(entity);
	}

	public void delete(Condutor dto) {
		repository.delete(fromTo(dto));
	}

	private Condutor fromTo(CondutorEntity entity) {
		return new Condutor(entity.getId(), entity.getNome(), entity.getSobrenome(), entity.getDataNascimento(),
				entity.getEmail(), entity.getSenha(), entity.getTelefone(), entity.getImagem(), entity.getEnderecoCep(),
				entity.getEnderecoLogradouro(), entity.getEnderecoNumero(), entity.getEnderecoBairro(),
				entity.getEnderecoCidade(), entity.getEnderecoEstado(), entity.getEnderecoComplemento());
	}

	private List<Condutor> fromTo(List<CondutorEntity> list) {
		List<Condutor> dtoList = new ArrayList<Condutor>();
		for (CondutorEntity entity : list) {
			dtoList.add(fromTo(entity));
		}
		return dtoList;
	}

	private CondutorEntity fromTo(Condutor dto) {
		return new CondutorEntity(dto.getId(), dto.getNome(), dto.getSobrenome(), dto.getDataNascimento(),
				dto.getEmail(), dto.getSenha(), dto.getTelefone(), dto.getImagem(), dto.getEnderecoCep(),
				dto.getEnderecoLogradouro(), dto.getEnderecoNumero(), dto.getEnderecoBairro(), dto.getEnderecoCidade(),
				dto.getEnderecoEstado(), dto.getEnderecoComplemento());
	}
}

package com.api.pessoas;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.dados.DadosCadastrais;
import com.api.endereco.Endereco;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("pessoas")
public class PessoasController {

	@Autowired
	private PessoasRepository repository;

	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody DadosCadastrais dados) {
		repository.save(new Pessoa(dados));
	}

	@GetMapping
	public List<ListagemPessoa> listar() {
		return repository.findAll().stream().map(ListagemPessoa::new).toList();

	}

	@PutMapping
	@Transactional
	public void atualizar(@RequestBody DadosCadastrais dados) {
		var pessoa = repository.getReferenceById(dados.id());
		pessoa.atualizarInformacoes(dados);

	}
	@GetMapping("/{id}")
	public Optional<Pessoa> consultar(@PathVariable Long id) {
		return repository.findById(id);
	}
	@GetMapping("/{id}/enderecos")
	public List<Object> consultarEndereco(@PathVariable Long id) {
		var pessoa = repository.getReferenceById(id);
		return Arrays.asList(pessoa.getEndereco(), pessoa.getEndereco2());
	}
	
}

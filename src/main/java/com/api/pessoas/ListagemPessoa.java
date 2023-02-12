package com.api.pessoas;

import com.api.endereco.Endereco;

public record ListagemPessoa(Long id, String nome, String dataNascimento, Endereco endereco) {

	public ListagemPessoa(Pessoa pessoa) {
		this(pessoa.getId(), pessoa.getNome(), pessoa.getDataNascimento(), pessoa.getEndereco());
	}

}

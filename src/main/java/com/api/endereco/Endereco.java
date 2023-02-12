package com.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

	private String logradouro;
	private String cep;
	private String numero;
	private String cidade;
	private Boolean principal;

	public Endereco(DadosEndereco dados) {

		this.logradouro = dados.logradouro();
		this.cep = dados.cep();
		this.cidade = dados.cidade();
		this.numero = dados.numero();
		this.principal = true;
	}

	public void atualizarInformacoes(DadosEndereco dados) {

		if (dados.logradouro() != null) {
			this.logradouro = dados.logradouro();
		}

		if (dados.cep() != null) {
			this.cep = dados.cep();
		}

		if (dados.cidade() != null) {
			this.cidade = dados.cidade();

		}
		if (dados.numero() != null) {
			this.numero = dados.numero();

		}

	}
}

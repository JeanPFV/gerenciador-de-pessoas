package com.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoSecundario {

	private String logradouro2;
	private String bairro2;
	private String cep2;
	private String numero2;
	private String complemento2;
	private String cidade2;
	private String uf2;
	private Boolean principal2;

	public EnderecoSecundario(DadosEnderecoSecundario dados) {

		this.logradouro2 = dados.logradouro2();
		this.bairro2 = dados.bairro2();
		this.cep2 = dados.cep2();
		this.uf2 = dados.uf2();
		this.cidade2 = dados.cidade2();
		this.numero2 = dados.numero2();
		this.complemento2 = dados.complemento2();
		this.principal2 = false;
	}

	public void atualizarInformacoesSecundario(DadosEnderecoSecundario dados) {

		if (dados.logradouro2() != null) {
			this.logradouro2 = dados.logradouro2();
		}
		if (dados.bairro2() != null) {
			this.bairro2 = dados.bairro2();
		}
		if (dados.cep2() != null) {
			this.cep2 = dados.cep2();
		}
		if (dados.uf2() != null) {
			this.uf2 = dados.uf2();
		}
		if (dados.cidade2() != null) {
			this.cidade2 = dados.cidade2();
		}
		if (dados.numero2() != null) {
			this.numero2 = dados.numero2();
		}
		if (dados.complemento2() != null) {
			this.complemento2 = dados.complemento2();
		}
	}

}

package com.api.pessoas;


import com.api.dados.DadosCadastrais;
import com.api.endereco.Endereco;
import com.api.endereco.EnderecoSecundario;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "Pesssoa")
@Table(name = "pessoas")
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nome;

	private String dataNascimento;
	
	@Embedded
	private Endereco endereco;
	
	@Embedded
	private EnderecoSecundario endereco2;

	public Pessoa(DadosCadastrais dados) {
		this.nome = dados.nome();
		this.dataNascimento = dados.dataNascimento();
		this.endereco = new Endereco(dados.endereco());
		this.endereco2 = new EnderecoSecundario(dados.endereco2());
	}

	public void atualizarInformacoes(DadosCadastrais dados) {
		if (dados.nome() != null) {
			this.nome = dados.nome();
		}
		if (dados.dataNascimento() != null) {
			this.dataNascimento = dados.dataNascimento();
		}
		if (dados.endereco() != null) {
			this.endereco.atualizarInformacoes(dados.endereco());
		}
		if (dados.endereco2() != null) {
			this.endereco2.atualizarInformacoesSecundario(dados.endereco2());
		}
	}

}

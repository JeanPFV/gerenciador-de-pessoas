package com.api.endereco;

public record DadosEndereco(
        String logradouro,
        String cep,
        String cidade,
        String numero,
        Boolean principal) {
	
}
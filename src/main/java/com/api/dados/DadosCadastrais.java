package com.api.dados;

import com.api.endereco.*;

public record DadosCadastrais(Long id,String nome, String dataNascimento, DadosEndereco endereco, DadosEnderecoSecundario endereco2) {

}

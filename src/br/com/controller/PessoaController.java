package br.com.controller;

import br.com.dao.Pessoa;
import br.com.enuns.TipoPessoa;

public class PessoaController {

	public Pessoa buscarPorID(int idPessoa){
		Pessoa pessoa = new Pessoa();
		if(idPessoa == 2){
			pessoa.setCodigo(idPessoa);
			pessoa.setNome("otima selecao");
			pessoa.setTipoPessoa(TipoPessoa.FISICA);
			
			return pessoa;
		}else if(idPessoa == 3){
			pessoa.setCodigo(3);
			pessoa.setNome("pessoa 3");
			pessoa.setTipoPessoa(TipoPessoa.JURIDICA);
			
			return pessoa;
		}else{
			return new Pessoa();
		}
	}
}

package br.com.ws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import br.com.controller.PessoaController;
import br.com.dao.Pessoa;

@WebService
public class WsTeste {
	@WebMethod
	public Pessoa buscarPorID(@WebParam int codigoPessoa){
		PessoaController controller = new PessoaController();
		return controller.buscarPorID(codigoPessoa);
	}
	
	@WebMethod
	public List<Pessoa> buscarTodos(){
		return new ArrayList<Pessoa>();
	}

}

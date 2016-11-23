package br.com.gym.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class WsStudy {

	@WebMethod
	public String returnStudy(){
		return "funcionou";
	}
}

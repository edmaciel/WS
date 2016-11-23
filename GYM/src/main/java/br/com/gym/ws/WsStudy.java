package br.com.gym.ws;

import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.apache.commons.codec.binary.Base64;

@WebService
public class WsStudy {
	
	@Resource
	WebServiceContext wsc;
	
	private final String AUTHORIZATION = "Authorization";

	@WebMethod
	public String returnStudy(){
		authenticateSystems();
		return "funcionou";
	}
	
	@SuppressWarnings("rawtypes")
	private void authenticateSystems() {
		 
		MessageContext mctx = wsc.getMessageContext();
		Map http_headers = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
  
		ArrayList list = (ArrayList) http_headers.get(AUTHORIZATION);
		if (list == null || list.size() == 0) {
			throw new RuntimeException("Erro ao executar altenticação, serviço necessita de autenticação BASIC");
		}
  
		String userpass = (String) list.get(0);
		userpass = userpass.substring(5);
		byte[] decode = Base64.decodeBase64(userpass.getBytes());
		String authentication = new String(decode);
  
		String user = null;
		String password = null;
		int index = authentication.indexOf(":");
		if (index > -1) {
			user = authentication.substring(0, index);
			password = authentication.substring(index+1);
		}   
		else {
			throw new RuntimeException("Nao foi possivel decodificar o token de autenticacao!");
		}
		
		String systemUser = "root";
		String systemPassword = "password";
		
		if (user.equals(systemUser) && password.equals(systemPassword)) { 
			System.out.println("============== Autenticacao OK =============");
			return;
		}
		else {
			throw new RuntimeException("Usuario e/ou senha invalidos!");
		}
	}
}

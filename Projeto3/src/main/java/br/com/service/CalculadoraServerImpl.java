package br.com.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

@WebService(name = "CalculadoraServer")
@SOAPBinding(style = Style.RPC)
public class CalculadoraServerImpl {
	
	@Resource
    private WebServiceContext wsctx;
	
	@WebMethod(operationName = "soma")
	public @WebResult(name="resultado") float soma(@WebParam(name = "num1") float num1, 
			@WebParam(name = "num2") float num2) {
		
		MessageContext mctx = wsctx.getMessageContext();
		// Use the request headers to get the details
        Map http_headers = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
        List<String> userList = (List) http_headers.get("Username");
        List<String> passList = (List) http_headers.get("Password");
  
        String username = "";
        String password = "";
  
        if (userList != null) {
            username = userList.get(0);
        }
        if (passList != null) {
            password = passList.get(0);
        }
  
        if (username.equals("StepUser") && password.equals("StepUser")) {
            return num1 + num2;
	    }
		return 0;
	}
	
	@WebMethod(operationName = "subtracao")
	public @WebResult(name="resultado") float subtracao(@WebParam(name = "num1") float num1, float num2) {
	    return num1 - num2;
	}
 
	@WebMethod(operationName = "multiplicacao")
	public @WebResult(name="resultado") float multiplicacao(@WebParam(name = "num1") float num1, float num2) {
	    return num1 * num2;
	}
 
	@WebMethod(operationName = "divisao")
	public @WebResult(name="resultado") float divisao(@WebParam(name = "num1") float num1, float num2) {
	    return num1 / num2;
	}
}

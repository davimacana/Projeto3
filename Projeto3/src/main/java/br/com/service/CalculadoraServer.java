package br.com.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService

public interface CalculadoraServer {

	@WebMethod(operationName = "soma")
	public @WebResult(name="resultado") float soma(@WebParam(name = "num1") float num1, @WebParam(name = "num2") float num2);
	
	@WebMethod(operationName = "subtracao")
	public @WebResult(name="resultado") float subtracao(@WebParam(name = "num1") float num1, float num2);
 
	@WebMethod(operationName = "multiplicacao")
	public @WebResult(name="resultado") float multiplicacao(@WebParam(name = "num1") float num1, float num2);
 
	@WebMethod(operationName = "divisao")
	public @WebResult(name="resultado") float divisao(@WebParam(name = "num1") float num1, float num2);
}

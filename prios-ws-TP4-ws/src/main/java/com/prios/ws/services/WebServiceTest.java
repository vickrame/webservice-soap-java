package com.prios.ws.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * @author vickrame
 *
 */
@WebService(serviceName = "WebServiceTestImpl", portName = "WebServiceTestImpl", wsdlLocation = "META-INF/wsdl/WebServiceTestImpl.wsdl")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED, style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
public interface WebServiceTest {
	
	@WebMethod(operationName = "call")
	String call(@WebParam(name = "param") String param);
}

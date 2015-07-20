package com.prios.ws.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.BindingType;

/**
 * @author vickrame
 *
 */
@Stateless
@LocalBean
@WebService(serviceName = "WebServiceTestImpl", portName = "WebServiceTestImpl", wsdlLocation = "META-INF/wsdl/WebServiceTestImpl.wsdl")
@BindingType(javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_MTOM_BINDING)
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED, style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
public class WebServiceTestImpl implements WebServiceTest {

	@WebMethod
	public String call(@WebParam(name = "param") String param){
		return "Hello " + param;
	}

}

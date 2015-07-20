/**
 * 
 */
package com.prios.ws.services.demo.rcp;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.prios.ws.services.demo.fault.AuthentificationFaultException;
import com.prios.ws.services.demo.fault.FonctionnalFaultException;

/**
 * @author vickrame
 *
 */
@WebService(serviceName="ReservationRPCImplService", portName = "ReservationRPCImplService_V1", wsdlLocation = "META-INF/wsdl/ReservationRPCImplService.wsdl")
//@SOAPBinding(parameterStyle=ParameterStyle.WRAPPED, style=Style.DOCUMENT, use=Use.LITERAL)
public interface ReservationRCP {

	@WebMethod(operationName="estReserveRPC")
	public boolean estReserveRPC(@WebParam(name= "nom") String nomPersonne, @WebParam(name="date") String date) throws FonctionnalFaultException;
	
	@WebMethod(operationName="estReserveAuthentificationRPC")
	public boolean estReserveAuthentificationRPC(@WebParam(name= "nom") String nomPersonne, @WebParam(name="date") String date) throws AuthentificationFaultException, FonctionnalFaultException;

	
}

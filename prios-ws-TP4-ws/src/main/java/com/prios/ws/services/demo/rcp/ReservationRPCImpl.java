package com.prios.ws.services.demo.rcp;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.ws.BindingType;

import com.prios.ws.services.demo.fault.AuthentificationFaultException;
import com.prios.ws.services.demo.fault.FonctionnalFaultException;


@Stateless
@LocalBean

//LIBERTY
//@WebService(serviceName="ReservationRPCImplService", portName = "ReservationRPCImplService_V1", wsdlLocation="META-INF/wsdl/ReservationRPCImplService.wsdl")

//GLASHFISH
@WebService(serviceName="ReservationRPCImplService", portName = "ReservationRPCImplService_V1", wsdlLocation = "META-INF/wsdl/ReservationRPCImplService.wsdl")

@SOAPBinding(style=Style.RPC,use=Use.LITERAL)
//@DeclareRoles({"CONSULT", "WRITE"})
@BindingType(javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
public class ReservationRPCImpl implements ReservationRCP {

	public boolean estReserveRPC(@WebParam(name="nom") String  nomPersonne, @WebParam(name="date") String date)
			throws FonctionnalFaultException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean estReserveAuthentificationRPC(@WebParam(name="nom") String nomPersonne, @WebParam(name="date") String date)
			throws AuthentificationFaultException, FonctionnalFaultException {
		// TODO Auto-generated method stub
		return false;
	}

}

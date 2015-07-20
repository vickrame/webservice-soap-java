/**
 * 
 */
package com.prios.ws.services.demo;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.MTOM;

import com.prios.ws.entity.Personne;
import com.prios.ws.entity.dto.PersonneRequest;
import com.prios.ws.services.demo.fault.AuthentificationFaultException;
import com.prios.ws.services.demo.fault.FonctionnalFaultException;
import com.prios.ws.services.entity.dto.ResponsePersonne;

/**
 * @author vickrame
 *
 */
@MTOM
@WebService
@BindingType(javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_MTOM_BINDING)
@SOAPBinding(parameterStyle=ParameterStyle.WRAPPED, style=Style.DOCUMENT, use=Use.LITERAL)
public interface Reservation {

	@WebMethod
	public boolean estReserve(@WebParam(name= "nom") String nomPersonne,  @WebParam(name="date") String date) throws FonctionnalFaultException;
	
//	@MTOM
	@WebMethod
	public boolean estReserveAuthentification( @WebParam(name= "nom") String nomPersonne,  @WebParam(name="date") String date) throws AuthentificationFaultException, FonctionnalFaultException;

	
	public Personne detailPErsonne( @WebParam(name="id")  String id);
	
	public ResponsePersonne listDetailPErsonne(@WebParam(name="requetes") List<PersonneRequest> requetes) throws AuthentificationFaultException;
	
	
	public Personne test(@WebParam(name="nom") String zz);
}

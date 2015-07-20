/**
 * 
 */
package com.prios.ws.services.demo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.ws.Action;
import javax.xml.ws.BindingType;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.soap.MTOM;

import com.prios.ws.entity.Personne;
import com.prios.ws.entity.dto.PersonneRequest;
import com.prios.ws.services.demo.fault.AuthentificationFaultException;
import com.prios.ws.services.demo.fault.FonctionnalFaultException;
import com.prios.ws.services.entity.dto.ResponsePersonne;
import com.prios.ws.services.util.UtilisateurUtil;
import com.services.ReservationService;

/**
 * @author vickrame
 *
 */
@Stateless
@MTOM
//@WebService(name="ReservationImpl")


// GLASFISH
@WebService(serviceName="ReservationImplService", portName = "ReservationImplService", wsdlLocation = "META-INF/wsdl/ReservationImplService.wsdl")
// LIBERTY
//@WebService(serviceName="ReservationImplService", wsdlLocation="META-INF/wsdl/ReservationImplService.wsdl")

//@BindingType(javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
@BindingType(javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_MTOM_BINDING)
@SOAPBinding(parameterStyle=ParameterStyle.WRAPPED, use=Use.LITERAL, style=Style.DOCUMENT)
//@Addressing(enabled=true, required = true)
//@RolesAllowed({"CONSULT","WRITE"})
public class ReservationImpl implements Reservation {

	@EJB
	private ReservationService reservationService;
//
	@Resource
	private SessionContext sessionContext;

	@Resource
	private WebServiceContext serviceContext;
	

	@WebMethod
	public boolean estReserve(@WebParam(name="nomPersonne") String nomPersonne,  @WebParam(name="date") String date)
			throws FonctionnalFaultException {
		System.out.println("param " + nomPersonne + " ; date " + date);
		boolean controleMetier = reservationService.controleArgument(date);
		System.out.println("controleMetier " + controleMetier);
		if (!controleMetier)
			throw new FonctionnalFaultException();

		return true;
	}

//	@Override
//	@MTOM
	@WebMethod
//	@Action(input="http://toto.fr", output = "http://reposne.fr")
	public boolean estReserveAuthentification( @WebParam(name="nomPersonne") String nomPersonne,  @WebParam(name="date") String date)
			throws AuthentificationFaultException, FonctionnalFaultException {
		// TODO Auto-generated method stub
		return UtilisateurUtil.estConnuAvecDroitLecture(sessionContext);
	}

	@Override
	public Personne detailPErsonne(String id) {
		// TODO Auto-generated method stub
		Personne pers = new Personne();
		pers.setId("123456");
		pers.setNom("NOM");
		pers.setPrenom("PRENOM");

		pers.setPhoto(new DataHandler(new FileDataSource(new File("C:\\Dev\\test.pdf"))));
		
		return pers;
	}
	
	
	@Override
	@WebMethod
	@Action(output="mailto:vickrame.ujoodha@zenika.com")
	public ResponsePersonne listDetailPErsonne(@WebParam(name="requetes") List<PersonneRequest> requetes) throws AuthentificationFaultException {
		// TODO Auto-generated method stub
		 
		System.out.println("taille liste entrant " + requetes.size());
		System.out.println("sessionContext" + sessionContext.getCallerPrincipal() );
		
		 UtilisateurUtil.estConnuAvecDroitLecture(sessionContext);
		List<Personne> listPersonne = new ArrayList<Personne>();
		for(PersonneRequest itemRequete : requetes){
			System.out.println(itemRequete.getId());
			Personne pers = new Personne();
			pers.setId(itemRequete.getId());
			pers.setNom("NOM " + itemRequete.getId());
			pers.setPrenom("PRENOM " + itemRequete.getId());
			pers.setPhoto(new DataHandler(new FileDataSource(new File("C:\\Dev\\test.pdf"))));
			listPersonne.add(pers);
		}
 
		System.out.println("taille liste " + listPersonne.size());
		
		ResponsePersonne reponse = new  ResponsePersonne();
		reponse.setListPersonneReponse(listPersonne);
		reponse.setListRequete(requetes);
		return reponse;
	}
//	/* (non-Javadoc)
//	 * @see com.prios.ws.services.demo.Reservation#estReserve(java.lang.String, java.lang.String)
//	 */
//	public boolean estReserve(@WebParam(name= "nom") String nomPersonne, @WebParam(name="date") String date)
//			throws FonctionnalFaultException {
//		System.out.println("param " + nomPersonne +  " ; date " +date);
//		boolean controleMetier = reservationService.controleArgument(date);
//		System.out.println("controleMetier "+ controleMetier);
//		if(!controleMetier)
//			throw new FonctionnalFaultException();
//		
//		return true;
//	}
//
//	@Override
//	public boolean estReserveAuthentification(@WebParam(name= "nom") String nomPersonne, @WebParam(name="date") String date)
//			throws AuthentificationFaultException, FonctionnalFaultException {
//
//		
//
//		UtilisateurUtil.estConnuAvecDroitLecture(sessionContext);
//		
//		
//		return false;
//	}

	@Override
	public Personne test(String zz) {
		// TODO Auto-generated method stub
		return null;
	}

}

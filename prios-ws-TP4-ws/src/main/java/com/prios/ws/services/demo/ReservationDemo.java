/**
 * 
 */
package com.prios.ws.services.demo;

import java.util.List;

import javax.jws.WebService;

import com.prios.ws.entity.Personne;
import com.prios.ws.entity.dto.PersonneRequest;
import com.prios.ws.services.demo.fault.AuthentificationFaultException;
import com.prios.ws.services.demo.fault.FonctionnalFaultException;
import com.prios.ws.services.entity.dto.ResponsePersonne;

/**
 * @author vickrame
 *
 */
@WebService(serviceName="ReservationDemo", portName="ReservationDemo")
public class ReservationDemo implements Reservation {

	/* (non-Javadoc)
	 * @see com.prios.ws.services.demo.Reservation#estReserve(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean estReserve(String nomPersonne, String date)
			throws FonctionnalFaultException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.prios.ws.services.demo.Reservation#estReserveAuthentification(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean estReserveAuthentification(String nomPersonne, String date)
			throws AuthentificationFaultException, FonctionnalFaultException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.prios.ws.services.demo.Reservation#detailPErsonne(java.lang.String)
	 */
	@Override
	public Personne detailPErsonne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.prios.ws.services.demo.Reservation#listDetailPErsonne(java.util.List)
	 */
	@Override
	public ResponsePersonne listDetailPErsonne(List<PersonneRequest> requetes)
			throws AuthentificationFaultException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.prios.ws.services.demo.Reservation#test(java.lang.String)
	 */
	@Override
	public Personne test(String zz) {
		// TODO Auto-generated method stub
		return null;
	}

}

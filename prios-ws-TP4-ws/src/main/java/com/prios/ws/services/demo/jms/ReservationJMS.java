/**
 * 
 */
package com.prios.ws.services.demo.jms;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.ws.BindingType;

import com.prios.ws.entity.Personne;
import com.prios.ws.entity.dto.PersonneRequest;
import com.prios.ws.services.demo.Reservation;
import com.prios.ws.services.demo.fault.AuthentificationFaultException;
import com.prios.ws.services.demo.fault.FonctionnalFaultException;
import com.prios.ws.services.entity.dto.ResponsePersonne;

/**
 * @author vickrame
 *
 */
@Stateless
@WebService(serviceName="ReservationJMSService" , wsdlLocation="META-INF/wsdl/ReservationJMSService.wsdl")
@SOAPBinding(parameterStyle=ParameterStyle.WRAPPED, style=Style.DOCUMENT, use=Use.LITERAL)
@BindingType(javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
public class ReservationJMS implements Reservation {
	
	@Resource(mappedName = "jms/SimpleConnectionFactory") //= connection factorie's JNDI name
	private ConnectionFactory connectionFactory;

	@Resource(mappedName = "jms/SimpleQueue") //= Queue's JNDI name
	private Queue queue;	

	/* (non-Javadoc)
	 * @see com.prios.ws.services.demo.Reservation#estReserve(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean estReserve(String nomPersonne, String date)
			throws FonctionnalFaultException {


		System.out.println("called putMessage");
		javax.jms.Connection connection;
		try {
			connection = connectionFactory.createConnection();
			javax.jms.Session        session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
			MessageProducer messageProducer = session.createProducer(queue);

			TextMessage message = session.createTextMessage();
			message.setText("Hello, JMS! #"+nomPersonne);
			messageProducer.send(message);			
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;

		
	}

	/* (non-Javadoc)
	 * @see com.prios.ws.services.demo.Reservation#estReserveAuthentification(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean estReserveAuthentification(String nomPersonne,
			String date) throws AuthentificationFaultException,
			FonctionnalFaultException {
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

	@Override
	public ResponsePersonne listDetailPErsonne(List<PersonneRequest> requetes) throws AuthentificationFaultException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Personne test(String zz) {
		// TODO Auto-generated method stub
		return null;
	}

}

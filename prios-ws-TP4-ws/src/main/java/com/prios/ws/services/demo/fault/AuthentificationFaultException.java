/**
 * 
 */
package com.prios.ws.services.demo.fault;

import javax.xml.ws.WebFault;

/**
 * @author vickrame
 *
 */
@WebFault(name="AuthentificationFaultException")
public class AuthentificationFaultException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1406847610575154394L;
	
	private final static String code = "01";
	private final static String messageGeneric = "utilisateur non authorise";


	private GenericFaultException serviceFault;
	
	public void initFault(String message) {
		serviceFault = new GenericFaultException();
		serviceFault.setFaultCode(code);
		serviceFault.setFaultMessage(message);
	}

	public AuthentificationFaultException() {
//		super();
		serviceFault = new GenericFaultException();
		serviceFault.setFaultCode(code);
		serviceFault.setFaultMessage(messageGeneric);
	}	

	public AuthentificationFaultException(String customMessage) {
//		super();
		serviceFault = new GenericFaultException();
		serviceFault.setFaultCode(code);
		serviceFault.setFaultMessage(customMessage);
	}

	/**
	 * @return the serviceFault
	 */
	public GenericFaultException getServiceFault() {
		return serviceFault;
	}

	/**
	 * @param serviceFault the serviceFault to set
	 */
	public void setServiceFault(GenericFaultException serviceFault) {
		this.serviceFault = serviceFault;
	}	
}

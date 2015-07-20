package com.prios.ws.services.demo.fault;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.ws.WebFault;

@WebFault(name="FonctionnalFaultException")
@XmlRootElement
//@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "FonctionnalFaultException", propOrder = {
        "customMessage"
    })
public class FonctionnalFaultException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3868412589703502292L;

	private final static String code = "02";
	private final static String messageGeneric = "les arguments sont incccccccorrects";


	private String customMessage;

//	private GenericFaultException serviceFault;
	
	
	public FonctionnalFaultException(){
//		serviceFault = new GenericFaultException();
//		this.se.setFaultCode(code);
		this.setCustomMessage(messageGeneric);
	}

	@XmlElement(name="kiki")
	public String getCustomMessage() {
		return customMessage;
	}


	public void setCustomMessage(String customMessage) {
		this.customMessage = customMessage;
	}


//	/**
//	 * @return the serviceFault
//	 */
//	public GenericFaultException getServiceFault() {
//		return serviceFault;
//	}
//
//
//	/**
//	 * @param serviceFault the serviceFault to set
//	 */
//	public void setServiceFault(GenericFaultException serviceFault) {
//		this.serviceFault = serviceFault;
//	}
	
	
	
}

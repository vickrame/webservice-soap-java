package com.prios.ws.services.demo.fault;

import java.io.Serializable;

import javax.xml.ws.WebFault;

@WebFault
public class GenericFaultException implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3728238700845333661L;
	
	
	private String faultCode;
	private String faultMessage;
	/**
	 * @return the faultCode
	 */
	public String getFaultCode() {
		return faultCode;
	}
	/**
	 * @param faultCode the faultCode to set
	 */
	public void setFaultCode(String faultCode) {
		this.faultCode = faultCode;
	}
	/**
	 * @return the faultMessage
	 */
	public String getFaultMessage() {
		return faultMessage;
	}
	/**
	 * @param faultMessage the faultMessage to set
	 */
	public void setFaultMessage(String faultMessage) {
		this.faultMessage = faultMessage;
	}
	
	
	public GenericFaultException(String faultCode, String faultMessage) {
//		super();
		this.faultCode = faultCode;
		this.faultMessage = faultMessage;
	}
	public GenericFaultException() {
		// TODO Auto-generated constructor stub
//		super();
	}
	
	
	
}

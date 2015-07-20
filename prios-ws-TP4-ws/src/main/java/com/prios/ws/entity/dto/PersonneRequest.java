/**
 * 
 */
package com.prios.ws.entity.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author vickrame
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="personneRequest")
public class PersonneRequest implements Serializable{

	
	public PersonneRequest() {
	}
	
	
	public PersonneRequest(String id) {
		this.id = id;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -1714355636092237472L;
	private String id;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	
}

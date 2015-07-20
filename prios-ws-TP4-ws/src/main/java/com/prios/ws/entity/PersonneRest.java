/**
 * 
 */
package com.prios.ws.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author vickrame
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonneRest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3500068345822859692L;

	
	private String id;
	
	private String nom;
	
	private String prenom;
	

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

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public PersonneRest() {
	}
	
	
}

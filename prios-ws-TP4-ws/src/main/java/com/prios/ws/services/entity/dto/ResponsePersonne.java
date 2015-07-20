package com.prios.ws.services.entity.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.prios.ws.entity.Personne;
import com.prios.ws.entity.dto.PersonneRequest;

@XmlRootElement(name="reponsePersonne")
public class ResponsePersonne implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -831728797422506412L;
	private List<PersonneRequest> listRequete;
	private List<Personne> listPersonneReponse;
	
	public ResponsePersonne() {
		super();
	}
	/**
	 * @return the listRequete
	 */
	public List<PersonneRequest> getListRequete() {
		return listRequete;
	}
	/**
	 * @param listRequete the listRequete to set
	 */
	public void setListRequete(List<PersonneRequest> listRequete) {
		this.listRequete = listRequete;
	}
	/**
	 * @return the listPersonneReponse
	 */
	public List<Personne> getListPersonneReponse() {
		return listPersonneReponse;
	}
	/**
	 * @param listPersonneReponse the listPersonneReponse to set
	 */
	public void setListPersonneReponse(List<Personne> listPersonneReponse) {
		this.listPersonneReponse = listPersonneReponse;
	}
}

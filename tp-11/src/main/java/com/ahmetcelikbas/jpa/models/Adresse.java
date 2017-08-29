/**
 * 
 */
package com.ahmetcelikbas.jpa.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Adresse")

/**
 * @author keylan
 *
 */
public class Adresse {
	/**
	 * int idAdresse
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idAdresse;
	
	/**
	 * String ligne1
	 */
	@Column
	private String ligne1;
	
	/**
	 * String ligne2
	 */
	@Column
	private String ligne2;
	
	/**
	 * String ville
	 */
	@Column
	private String ville;
	
	/**
	 * String zipCode
	 */
	@Column
	private String zipCode;
	
	/**
	 * String pays
	 */
	@Column
	private String pays;
		

	/**
	 * Client adresseLivraison
	 */
	@OneToOne(mappedBy="adresseLivraison")
	private Client adresseLivraison;
	
	/**
	 * Client adresseFacturation
	 */
	@OneToOne(mappedBy="adresseFacturation")
	private Client adresseFacturation;
		
	/**
	 * Facture facture
	 */
	@OneToOne(mappedBy="adresseLivraison")
	private Facture facture;

	
	/* GETTERS @ SETTERS */
	
	
	/**
	 * @return the ligne1
	 */
	public String getLigne1() {
		return ligne1;
	}

	/**
	 * @param ligne1 the ligne1 to set
	 */
	public void setLigne1(String ligne1) {
		this.ligne1 = ligne1;
	}

	/**
	 * @return the ligne2
	 */
	public String getLigne2() {
		return ligne2;
	}

	/**
	 * @param ligne2 the ligne2 to set
	 */
	public void setLigne2(String ligne2) {
		this.ligne2 = ligne2;
	}

	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * @return the pays
	 */
	public String getPays() {
		return pays;
	}

	/**
	 * @param pays the pays to set
	 */
	public void setPays(String pays) {
		this.pays = pays;
	}

	/**
	 * @return the adresseLivraison
	 */
	public Client getAdresseLivraison() {
		return adresseLivraison;
	}

	/**
	 * @param adresseLivraison the adresseLivraison to set
	 */
	public void setAdresseLivraison(Client adresseLivraison) {
		this.adresseLivraison = adresseLivraison;
	}

	/**
	 * @return the adresseFacturation
	 */
	public Client getAdresseFacturation() {
		return adresseFacturation;
	}

	/**
	 * @param adresseFacturation the adresseFacturation to set
	 */
	public void setAdresseFacturation(Client adresseFacturation) {
		this.adresseFacturation = adresseFacturation;
	}

	/**
	 * @return the idAdresse
	 */
	public int getIdAdresse() {
		return idAdresse;
	}
	
	
	
	
	
	
	
	
}

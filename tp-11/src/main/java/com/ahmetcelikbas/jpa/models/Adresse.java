/**
 * 
 */
package com.ahmetcelikbas.jpa.models;

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
	@SuppressWarnings("unused")
	private String ligne1;
	
	/**
	 * String ligne2
	 */
	@SuppressWarnings("unused")
	private String ligne2;
	
	/**
	 * String ville
	 */
	@SuppressWarnings("unused")
	private String ville;
	
	/**
	 * String zipCode
	 */
	@SuppressWarnings("unused")
	private String zipCode;
	
	/**
	 * String pays
	 */
	@SuppressWarnings("unused")
	private String pays;
		
	/**
	 * Facture facture
	 */
	@OneToOne(mappedBy="adresse")
	private Facture facture;
}

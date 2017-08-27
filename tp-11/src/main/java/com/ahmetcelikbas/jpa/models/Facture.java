/**
 * 
 */
package com.ahmetcelikbas.jpa.models;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Facture")

/**
 * @author keylan
 *
 */
public class Facture {

	/**
	 * int idFacture
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idFacture;
	
	/**
	 * String date
	 */
	@SuppressWarnings("unused")
	private String date;
	
	/**
	 * String status
	 */
	@SuppressWarnings("unused")
	private String status;
	
	/**
	 * double total
	 */
	@SuppressWarnings("unused")
	private double total;
	
	/**
	 * Set<LigneFacture> ligneFacture
	 */
	@OneToMany(mappedBy="facture", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private Set<LigneFacture> ligneFacture;
	
	/**
	 * Client client
	 */
	@ManyToOne
	private Client client;
	

	/**
	 * Adresse adresse
	 */
	@OneToOne
	private Adresse adresse;
}

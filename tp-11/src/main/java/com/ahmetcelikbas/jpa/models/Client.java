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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Client")

/**
 * @author keylan
 *
 */
public class Client {
	/**
	 * int idClient
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idClient;
	
	/**
	 * String nom
	 */
	@SuppressWarnings("unused")
	private String nom;
	
	/**
	 * String prenom
	 */
	@SuppressWarnings("unused")
	private String prenom;
	
	/**
	 * Set<Adresse> adresseLivraison
	 * relation Client_Adresse pour l'adresse de livraison
	 */
	@OneToMany(cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private Set<Adresse> adresseLivraison;
	
	/**
	 * Set<Adresse> adresseFacturation
	 * relation Client_Adresse pour l'adresse de facturation
	 */
	@OneToMany(cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private Set<Adresse> adresseFacturation;
	
	/**
	 * Set<Facture> facture
	 * relation Client_Facture
	 */
	@OneToMany(mappedBy="client", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private Set<Facture> facture;
}

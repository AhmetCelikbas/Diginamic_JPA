/**
 * 
 */
package com.ahmetcelikbas.jpa.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	@Column
	private String nom;
	
	/**
	 * String prenom
	 */
	@Column
	private String prenom;
	
	/**
	 * Adresse adresseLivraison
	 */
	@OneToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private Adresse adresseLivraison;
	
	/**
	 * Adresse adresseFacturation
	 */
	@OneToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private Adresse adresseFacturation;
	
	/**
	 * Set<Facture> facture
	 * relation Client_Facture
	 */
	@OneToMany(mappedBy="client")
	private Set<Facture> facture;

	
	/* GETTERS @ SETTERS */
	
	
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

	/**
	 * @return the adresseLivraison
	 */
	public Adresse getAdresseLivraison() {
		return adresseLivraison;
	}

	/**
	 * @param adresseLivraison the adresseLivraison to set
	 */
	public void setAdresseLivraison(Adresse adresseLivraison) {
		this.adresseLivraison = adresseLivraison;
	}

	/**
	 * @return the adresseFacturation
	 */
	public Adresse getAdresseFacturation() {
		return adresseFacturation;
	}

	/**
	 * @param adresseFacturation the adresseFacturation to set
	 */
	public void setAdresseFacturation(Adresse adresseFacturation) {
		this.adresseFacturation = adresseFacturation;
	}

	/**
	 * @return the idClient
	 */
	public int getIdClient() {
		return idClient;
	}
	
	
	
	
	
	
	
}

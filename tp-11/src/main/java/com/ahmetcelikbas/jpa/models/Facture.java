/**
 * 
 */
package com.ahmetcelikbas.jpa.models;

import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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
	 * Date date
	 */
	@Column
	private Date date;
	
	/**
	 * String status
	 */
	@Column
	private StatusFacture status;
	
	/**
	 * double total
	 */
	@Column
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
	private Adresse adresseLivraison;

	
	/* GETTERS @ SETTERS */	
	
	
	
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the status
	 */
	public StatusFacture getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(StatusFacture status) {
		this.status = status;
	}

	/**
	 * @return the total
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(double total) {
		this.total = total;
	}

	/**
	 * @return the ligneFacture
	 */
	public Set<LigneFacture> getLigneFacture() {
		return ligneFacture;
	}

	/**
	 * @param ligneFacture the ligneFacture to set
	 */
	public void setLigneFacture(Set<LigneFacture> ligneFacture) {
		this.ligneFacture = ligneFacture;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
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
	 * @return the idFacture
	 */
	public int getIdFacture() {
		return idFacture;
	}
	
	
	
}

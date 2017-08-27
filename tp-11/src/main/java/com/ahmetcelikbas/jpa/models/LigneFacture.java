/**
 * 
 */
package com.ahmetcelikbas.jpa.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LigneFacture")

/**
 * @author keylan
 *
 */
public class LigneFacture {
	/**
	 * int idLigneFacture
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idLigneFacture;
	
	/**
	 * int nombreArticle
	 */
	@SuppressWarnings("unused")
	private int nombreArticle;
	
	/**
	 * double total
	 */
	@SuppressWarnings("unused")
	private double total;
	
	/**
	 * Facture facture
	 */
	@ManyToOne
	private Facture facture;
	
	@OneToOne
	private Article article;
}

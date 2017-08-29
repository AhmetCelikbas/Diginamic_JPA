/**
 * 
 */
package com.ahmetcelikbas.jpa.models;

import javax.persistence.Column;
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
	@Column
	private int nombreArticle;
	
	/**
	 * double total
	 */
	@Column
	private double total;
	
	/**
	 * Facture facture
	 */
	@ManyToOne
	private Facture facture;
	
	@OneToOne
	private Article article;

	
	/* GETTERS @ SETTERS */
	
	
	/**
	 * @return the nombreArticle
	 */
	public int getNombreArticle() {
		return nombreArticle;
	}

	/**
	 * @param nombreArticle the nombreArticle to set
	 */
	public void setNombreArticle(int nombreArticle) {
		this.nombreArticle = nombreArticle;
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
	 * @return the facture
	 */
	public Facture getFacture() {
		return facture;
	}

	/**
	 * @param facture the facture to set
	 */
	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	/**
	 * @return the article
	 */
	public Article getArticle() {
		return article;
	}

	/**
	 * @param article the article to set
	 */
	public void setArticle(Article article) {
		this.article = article;
	}

	/**
	 * @return the idLigneFacture
	 */
	public int getIdLigneFacture() {
		return idLigneFacture;
	}
	
	
	
	
	
	
}

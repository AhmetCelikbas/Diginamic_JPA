/**
 * 
 */
package com.ahmetcelikbas.jpa.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Article")

/**
 * @author keylan
 *
 */
public class Article {

	/**
	 * int idArticle
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idArticle;
	
	/**
	 * double prix
	 */
	@Column
	private double prix;
	
	/**
	 * ArticleDescription articleDescription
	 */
	@OneToOne
	private ArticleDescription articleDescription;

	/**
	 * LigneFacture ligneFacture
	 */
	@OneToOne(mappedBy="article", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private LigneFacture ligneFacture;
	
	/* GETTERS @ SETTERS */
	
	/**
	 * @return the prix
	 */
	public double getPrix() {
		return prix;
	}

	/**
	 * @param prix the prix to set
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}

	/**
	 * @return the articleDescription
	 */
	public ArticleDescription getArticleDescription() {
		return articleDescription;
	}

	/**
	 * @param articleDescription the articleDescription to set
	 */
	public void setArticleDescription(ArticleDescription articleDescription) {
		this.articleDescription = articleDescription;
	}

	/**
	 * @return the idArticle
	 */
	public int getIdArticle() {
		return idArticle;
	}	
	
}

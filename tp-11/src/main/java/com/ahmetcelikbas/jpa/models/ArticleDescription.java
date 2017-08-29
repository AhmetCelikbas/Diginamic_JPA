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
@Table(name = "ArticleDescription")

/**
 * @author keylan
 *
 */
public class ArticleDescription {
	/**
	 * int idArticleDescription
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idArticleDescription;
	
	/**
	 * String nom
	 */
	@Column
	private String nom;
	
	/**
	 * String description
	 */
	@Column
	private String description;
	
	/**
	 * Article article
	 */
	@OneToOne(mappedBy="articleDescription")
	private Article article;


	
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}


	/**
	 * @return the idArticleDescription
	 */
	public int getIdArticleDescription() {
		return idArticleDescription;
	}
	
	
	
}

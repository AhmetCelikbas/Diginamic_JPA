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
	@SuppressWarnings("unused")
	private String nom;
	
	/**
	 * String description
	 */
	@SuppressWarnings("unused")
	private String description;
	
	/**
	 * Article article
	 */
	@OneToOne(mappedBy="articleDescription")
	private Article article;
}

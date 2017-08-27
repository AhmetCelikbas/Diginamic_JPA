/**
 * 
 */
package com.ahmetcelikbas.jpa.models;

import javax.persistence.CascadeType;
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
	@SuppressWarnings("unused")
	private double prix;
	
	/**
	 * ArticleDescription articleDescription
	 */
	@OneToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private ArticleDescription articleDescription;
		
}

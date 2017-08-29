package com.ahmetcelikbas.jpa;

import static spark.Spark.get;

import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.ahmetcelikbas.jpa.models.Adresse;
import com.ahmetcelikbas.jpa.models.Article;
import com.ahmetcelikbas.jpa.models.ArticleDescription;
import com.ahmetcelikbas.jpa.models.Client;
import com.ahmetcelikbas.jpa.models.Facture;
import com.ahmetcelikbas.jpa.models.LigneFacture;
import com.ahmetcelikbas.jpa.models.StatusFacture;

import freemarker.template.Configuration;
import freemarker.template.Version;
import spark.ModelAndView;
import spark.servlet.SparkApplication;
import spark.template.freemarker.FreeMarkerEngine;


public class Router implements SparkApplication {

	public void init() {

		/*
		 * TEST
		 */
		get("/", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			
			attributes.put("VAR_NAME", "Hello World!");
			
			
			
			// Ajout d'articles 
			ArticleDescription descriptionChausettes = new ArticleDescription();
			descriptionChausettes.setNom("Caussettes WINI l'ourson");
			descriptionChausettes.setDescription("Chausettes Taille 18, 100% coton; ");
			Database.presist(descriptionChausettes);
			
			Article chausettes = new Article();
			chausettes.setArticleDescription(descriptionChausettes);
			chausettes.setPrix(3.2);
			Database.presist(chausettes);
			
			ArticleDescription descriptonPullPrincesse = new ArticleDescription();
			descriptonPullPrincesse.setNom("Pull Princesse magique");
			descriptonPullPrincesse.setDescription("Pull Taille 7 ans, 100% coton; ");
			Database.presist(descriptonPullPrincesse);
			
			Article pullPrincesse = new Article();
			pullPrincesse.setArticleDescription(descriptonPullPrincesse);
			pullPrincesse.setPrix(7.9);
			Database.presist(pullPrincesse);
			
			// Ajout adresses
			Adresse adresseLivraison = new Adresse();
			adresseLivraison.setLigne1("Batiment louche");
			adresseLivraison.setLigne2("43 Rue perdue");
			adresseLivraison.setVille("BizarreTown");
			adresseLivraison.setZipCode("69000");
			adresseLivraison.setPays("FRANCE");
			Database.presist(adresseLivraison);
			
			Adresse adresseFacturation = new Adresse();
			adresseFacturation.setLigne1("Batiment louche2");
			adresseFacturation.setLigne2("43 Rue perdue2");
			adresseFacturation.setVille("BizarreTown2");
			adresseFacturation.setZipCode("690002");
			adresseFacturation.setPays("FRANCE2");
			Database.presist(adresseFacturation);
			
			// Ajout client
			Client client = new Client();
			client.setNom("Celikbas");
			client.setPrenom("Ahmet");
			client.setAdresseFacturation(Database.find(Adresse.class, adresseFacturation.getIdAdresse()));
			client.setAdresseLivraison(Database.find(Adresse.class, adresseLivraison.getIdAdresse()));
			Database.presist(client);
			
			// Ajout facture
			Facture facture = new Facture();
			facture.setAdresseLivraison(adresseLivraison);
			facture.setDate(Calendar.getInstance().getTime());
			facture.setStatus(StatusFacture.PAYE);
			facture.setClient(Database.find(Client.class, client.getIdClient()));
			
			Database.presist(facture);
			
			facture = Database.find(Facture.class, facture.getIdFacture());
			
			// Ajout ligne facture
			LigneFacture ligneFacture = new LigneFacture();
			ligneFacture.setArticle(Database.find(Article.class, pullPrincesse.getIdArticle()));
			ligneFacture.setNombreArticle(3);
			ligneFacture.setTotal(pullPrincesse.getPrix() * ligneFacture.getNombreArticle());
			ligneFacture.setFacture(facture);
			Database.presist(ligneFacture);
			
			LigneFacture ligneFacture2 = new LigneFacture();
			ligneFacture2.setArticle(Database.find(Article.class, chausettes.getIdArticle()));
			ligneFacture2.setNombreArticle(2);
			ligneFacture2.setTotal(chausettes.getPrix() * ligneFacture2.getNombreArticle());
			ligneFacture2.setFacture(facture);
			Database.presist(ligneFacture2);
			
			Set<LigneFacture> lignesFacture = new HashSet<>();
			lignesFacture.add(Database.find(LigneFacture.class, ligneFacture.getIdLigneFacture()));
			lignesFacture.add(Database.find(LigneFacture.class, ligneFacture2.getIdLigneFacture()));
			
			facture = Database.find(Facture.class, facture.getIdFacture());
			facture.setLigneFacture(lignesFacture);
			Database.presist(facture);
	
			
			return new ModelAndView(attributes, "home.ftl");
		}, getFreeMarkerEngine());
		
		
	}

	private FreeMarkerEngine getFreeMarkerEngine() {
		FreeMarkerEngine engine = new FreeMarkerEngine();
		Configuration configuration = new Configuration(new Version(2, 3, 23));
		configuration.setTemplateUpdateDelayMilliseconds(Long.MAX_VALUE);
		configuration.setClassForTemplateLoading(FreeMarkerEngine.class, "");
		engine.setConfiguration(configuration);
		return engine;
	}

}
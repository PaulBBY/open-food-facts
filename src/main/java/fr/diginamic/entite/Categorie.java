package fr.diginamic.entite;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/** Représente la catégorie, et son modéle relationel */
@Entity
@Table(name="categorie")
public class Categorie {

	/** Id de la catégorie, généré lors de l'insert dans la BDD */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/** Nom de la catégorie */
	@Column(name="NOM_CATEGORIE")
	private String nomCategorie;

	/** Relation vers produit. c.f Produit */
	@OneToMany(mappedBy = "categorie")
	private Set<Produit> produits;
	
	/** Constructeur sans paramètre */
	public Categorie() {
	}
	
	/** Constructeur avec * paramètressauf ID*/
	public Categorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}
	
	/** Méthode to String et Get/Set */
	@Override
	public String toString() {
		return "Categorie [id=" + id + ", nomCategorie=" + nomCategorie + "  ]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomCategorie() {
		return nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	public Set<Produit> getProduits() {
		return produits;
	}

	public void setProduits(Set<Produit> produits) {
		this.produits = produits;
	}


}

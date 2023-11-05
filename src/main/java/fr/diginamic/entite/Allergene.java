package fr.diginamic.entite;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
/* Représente l'allergene, et son modèle relationel */
@Entity
@Table(name="allergenes")
public class Allergene {
	
	/** Id de l'allergene, généré lors de l'insert dans la BDD */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/** Nom de l'allergnee */
	@Column(name="NOM_ALLERGENE")
	private String nomAllergene;
	
	/** Relation vers produit. c.f Produit */
	@ManyToMany(mappedBy = "allergenes")
	private Set<Produit> produits;

	/** Constructeur sans paramètre */
	public Allergene() {
	}
	
	/** Constructeur avec * paramètressauf ID*/
	public Allergene(String nomAllergene) {
		this.nomAllergene = nomAllergene;
	}

	/** Méthode to String et Get/Set */
	@Override
	public String toString() {
		return "Allergene [id=" + id + ", nomAllergene=" + nomAllergene + ", produits=" + produits + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomAllergene() {
		return nomAllergene;
	}

	public void setNomAllergene(String nomAllergene) {
		this.nomAllergene = nomAllergene;
	}

	public Set<Produit> getProduits() {
		return produits;
	}

	public void setProduits(Set<Produit> produits) {
		this.produits = produits;
	}
	
}

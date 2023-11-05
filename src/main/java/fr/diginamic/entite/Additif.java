package fr.diginamic.entite;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
/** Représente l'additif, et son modèle relationel */
@Entity
@Table(name="additifs")
public class Additif {

	/** Id de l'additif, généré lors de l'insert dans la BDD */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/** Nom de l'addifif */
	@Column(name="NOM_ADDITIF")
	private String nomAdditif;
	
	/** Relation vers produit. c.f Produit */
	@ManyToMany(mappedBy = "additifs")
	private Set<Produit> produits;

	/** Constructeur sans paramètre */
	public Additif() {
	}

	/** Constructeur avec * paramètressauf ID*/
	public Additif(String nomAdditif) {
		this.nomAdditif = nomAdditif;
	}

	/** Méthode to String et Get/Set */
	@Override
	public String toString() {
		return "Additif [id=" + id + ", nomAdditif=" + nomAdditif + ", produits=" + produits + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomAdditif() {
		return nomAdditif;
	}

	public void setNomAdditif(String nomAdditif) {
		this.nomAdditif = nomAdditif;
	}

	public Set<Produit> getProduits() {
		return produits;
	}

	public void setProduits(Set<Produit> produits) {
		this.produits = produits;
	}
	
}

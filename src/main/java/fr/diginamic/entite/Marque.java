package fr.diginamic.entite;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**Représente la marque, et son modèle relationel */
@Entity
@Table(name="marque")
public class Marque {
	
	/** Id de la marque, généré lors de l'insert dans la BDD */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/** Nom de la marque */
	@Column(name="NOM_MARQUE")
	private String nomMarque;
	
	/** Relation vers produit. c.f Produit */
	@OneToMany(mappedBy = "marque")
	private Set<Produit> produits;

	/** Constructeur sans paramètre */
	public Marque() {
	}
	
	/** Constructeur avec * paramètressauf ID*/
	public Marque(String nomMarque) {
		this.nomMarque = nomMarque;
	}

	/** Méthode to String et Get/Set */
	@Override
	public String toString() {
		return "Marque [id=" + id + ", nomMarque=" + nomMarque + " ]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomMarque() {
		return nomMarque;
	}

	public void setNomMarque(String nomMarque) {
		this.nomMarque = nomMarque;
	}

	public Set<Produit> getProduits() {
		return produits;
	}

	public void setProduits(Set<Produit> produits) {
		this.produits = produits;
	}
	
}

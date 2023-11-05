package fr.diginamic.entite.element;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.diginamic.entite.Produit;
/**Représente l'ensemble de valeurs de macro éléments, et leur modèle relationel*/
@Entity
@Table(name = "macro_elements")
public class MacroElements {

	/** Id de l'ensemble de macro éléments */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/* Masse en g de graisse, pour 100g de produit */
	@Column(name = "QUANTITE_GRAISSE_POUR_100G")
	private float quantiteGraisse;
	
	/* Masse en g de sucre, pour 100g de produit */
	@Column(name = "QUANTITE_SUCRE_POUR_100G")
	private float quantiteSucre;
	
	/* Masse en g de protéine, pour 100g de produit */
	@Column(name = "QUANTITE_PROTEINE_POUR_100G")
	private float quantiteProteine;

	/** Relation vers produit. c.f Produit */
	@OneToMany(mappedBy = "macroElements")
	private Set<Produit> produits;
	
	/** Constructeur sans paramètre */
	public MacroElements() {
	}

	/** Constructeur avec * paramètressauf ID*/
	public MacroElements(float... valeurs) {
		this.quantiteGraisse = valeurs[0];
		this.quantiteSucre = valeurs[1];
		this.quantiteProteine = valeurs[2];
	}

	/** Méthode to String et Get/Set */
	@Override
	public String toString() {
		return "MacroElement [id=" + id + ", quantiteSucre=" + quantiteSucre + ", quantiteGraisse=" + quantiteGraisse
				+ ", quantiteProteine=" + quantiteProteine + ", produits=" + produits + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getQuantiteSucre() {
		return quantiteSucre;
	}

	public void setQuantiteSucre(float quantiteSucre) {
		this.quantiteSucre = quantiteSucre;
	}

	public float getQuantiteGraisse() {
		return quantiteGraisse;
	}

	public void setQuantiteGraisse(float quantiteGraisse) {
		this.quantiteGraisse = quantiteGraisse;
	}

	public float getQuantiteProteine() {
		return quantiteProteine;
	}

	public void setQuantiteProteine(float quantiteProteine) {
		this.quantiteProteine = quantiteProteine;
	}

	public Set<Produit> getProduits() {
		return produits;
	}

	public void setProduits(Set<Produit> produits) {
		this.produits = produits;
	}
	
}

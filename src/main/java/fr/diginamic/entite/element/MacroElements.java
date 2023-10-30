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

@Entity
@Table(name = "macro_elements")
public class MacroElements {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "QUANTITE_GRAISSE_POUR_100G")
	private float quantiteGraisse;
	@Column(name = "QUANTITE_SUCRE_POUR_100G")
	private float quantiteSucre;
	@Column(name = "QUANTITE_PROTEINE_POUR_100G")
	private float quantiteProteine;

	@OneToMany(mappedBy = "macroElements")
	private Set<Produit> produits;
	
	public MacroElements() {
	}

	

	public MacroElements(float... valeurs) {
		this.quantiteGraisse = valeurs[0];
		this.quantiteSucre = valeurs[1];
		this.quantiteProteine = valeurs[2];
	}



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

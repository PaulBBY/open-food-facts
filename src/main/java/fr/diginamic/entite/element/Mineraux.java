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
@Table(name="mineraux")
public class Mineraux{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="CALCIUM_POUR_100G")
	private float calcium100g;
	@Column(name="MAGNESIUM_POUR_100G")
	private float magnesium100g;
	@Column(name="FER_POUR_100G")
	private float fer100g;
	
	@OneToMany(mappedBy = "mineraux")
	private Set<Produit> produits;

	public Mineraux() {
	}
	
	

	public Mineraux(float...values) {
		this.calcium100g = values[0];
		this.magnesium100g = values[1];
		this.fer100g = values[2];
	}



	@Override
	public String toString() {
		return "Mineraux [id=" + id + ", calclium100g=" + calcium100g + ", magnesium100g=" + magnesium100g
				+ ", fer100g=" + fer100g + ", produits=" + produits + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getCalclium100g() {
		return calcium100g;
	}

	public void setCalclium100g(float calclium100g) {
		this.calcium100g = calclium100g;
	}

	public float getMagnesium100g() {
		return magnesium100g;
	}

	public void setMagnesium100g(float magnesium100g) {
		this.magnesium100g = magnesium100g;
	}

	public float getFer100g() {
		return fer100g;
	}

	public void setFer100g(float fer100g) {
		this.fer100g = fer100g;
	}

	public Set<Produit> getProduits() {
		return produits;
	}

	public void setProduits(Set<Produit> produits) {
		this.produits = produits;
	}


}

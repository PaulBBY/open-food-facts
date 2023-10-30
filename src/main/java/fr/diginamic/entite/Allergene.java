package fr.diginamic.entite;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="allergenes")
public class Allergene {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="NOM_ALLERGENE")
	private String nomAllergene;
	
	@ManyToMany(mappedBy = "allergenes")
	private Set<Produit> produits;

	public Allergene() {
	}

	public Allergene(String nomAllergene) {
		this.nomAllergene = nomAllergene;
	}

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

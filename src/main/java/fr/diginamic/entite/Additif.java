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
@Table(name="additifs")
public class Additif {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="NOM_ADDITIF")
	private String nomAdditif;
	
	@ManyToMany(mappedBy = "additifs")
	private Set<Produit> produits;

	public Additif() {
	}

	
	public Additif(String nomAdditif) {
		this.nomAdditif = nomAdditif;
	}


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

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
@Table(name="vitamines")
public class Vitamines {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="QUANTITE_VIT_A_POUR_100G")
	private float vitA100g;
	@Column(name="QUANTITE_VIT_D_POUR_100G")
	private float vitD100g;
	@Column(name="QUANTITE_VIT_E_POUR_100G")
	private float vitE100g;
	@Column(name="QUANTITE_VIT_K_POUR_100G")
	private float vitK100g;
	@Column(name="QUANTITE_VIT_C_POUR_100G")
	private float vitC100g;
	@Column(name="QUANTITE_VIT_B1_POUR_100G")
	private float vitB1100g;
	@Column(name="QUANTITE_VIT_B2_POUR_100G")
	private float vitB2100g;
	@Column(name="QUANTITE_VIT_PP_POUR_100G")
	private float vitPP100g;
	@Column(name="QUANTITE_VIT_B6_POUR_100G")
	private float vitB6100g;
	@Column(name="QUANTITE_VIT_B9_POUR_100G")
	private float vitB9100g;
	@Column(name="QUANTITE_VIT_B12_POUR_100G")
	private float vitB12100g;
	@Column(name="QUANTITE_BETA_CAROTENE_POUR_100G")
	private float betaCarotene100g;
	
	@OneToMany(mappedBy = "vitamines")
	private Set<Produit> produits;

	public Vitamines() {
	}
	
	public Vitamines(float...values) {
		this.vitA100g = values[0];
		this.vitD100g = values[1];
		this.vitE100g = values[2];
		this.vitK100g = values[3];
		this.vitC100g = values[4];
		this.vitB1100g = values[5];
		this.vitB2100g = values[6];
		this.vitPP100g = values[7];
		this.vitB6100g = values[8];
		this.vitB9100g = values[9];
		this.vitB12100g = values[10];
		this.betaCarotene100g = values[11];
	}
	
	

	@Override
	public String toString() {
		return "Vitamine [id=" + id + ", vitA100g=" + vitA100g + ", vitD100g=" + vitD100g + ", vitE100g=" + vitE100g
				+ ", vitK100g=" + vitK100g + ", vitC100g=" + vitC100g + ", vitB1100g=" + vitB1100g + ", vitB2100g="
				+ vitB2100g + ", vitPP100g=" + vitPP100g + ", vitB6100g=" + vitB6100g + ", vitB12100g=" + vitB12100g
				+ ", betaCarotene100g=" + betaCarotene100g + ", produits=" + produits + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getVitA100g() {
		return vitA100g;
	}

	public void setVitA100g(float vitA100g) {
		this.vitA100g = vitA100g;
	}

	public float getVitD100g() {
		return vitD100g;
	}

	public void setVitD100g(float vitD100g) {
		this.vitD100g = vitD100g;
	}

	public float getVitE100g() {
		return vitE100g;
	}

	public void setVitE100g(float vitE100g) {
		this.vitE100g = vitE100g;
	}

	public float getVitK100g() {
		return vitK100g;
	}

	public void setVitK100g(float vitK100g) {
		this.vitK100g = vitK100g;
	}

	public float getVitC100g() {
		return vitC100g;
	}

	public void setVitC100g(float vitC100g) {
		this.vitC100g = vitC100g;
	}

	public float getVitB1100g() {
		return vitB1100g;
	}

	public void setVitB1100g(float vitB1100g) {
		this.vitB1100g = vitB1100g;
	}

	public float getVitB2100g() {
		return vitB2100g;
	}

	public void setVitB2100g(float vitB2100g) {
		this.vitB2100g = vitB2100g;
	}

	public float getVitPP100g() {
		return vitPP100g;
	}

	public void setVitPP100g(float vitPP100g) {
		this.vitPP100g = vitPP100g;
	}

	public float getVitB6100g() {
		return vitB6100g;
	}

	public void setVitB6100g(float vitB6100g) {
		this.vitB6100g = vitB6100g;
	}

	public float getVitB12100g() {
		return vitB12100g;
	}

	public void setVitB12100g(float vitB12100g) {
		this.vitB12100g = vitB12100g;
	}

	public float getBetaCarotene100g() {
		return betaCarotene100g;
	}

	public void setBetaCarotene100g(float betaCarotene100g) {
		this.betaCarotene100g = betaCarotene100g;
	}

	public Set<Produit> getProduits() {
		return produits;
	}

	public void setProduits(Set<Produit> produits) {
		this.produits = produits;
	}
	
	
}

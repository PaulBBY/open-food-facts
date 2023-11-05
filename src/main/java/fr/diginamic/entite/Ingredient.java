package fr.diginamic.entite;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
/**Représente l'ingrédient, et son modèle relationel */
@Entity
@Table(name="ingredients")
public class Ingredient {
	
	/** Id de l'ingrédient, généré lors de l'insert dans la BDD */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/** Nom du produit */
	@Column(name="NOM_INGREDIENT")
	private String nomIngredient;
	
	/** Relation vers produit. c.f Produit */
	@ManyToMany(mappedBy = "ingredients")
	private Set<Produit> produits;

	/** Constructeur sans paramètre */
	public Ingredient() {
	}
	
	/** Constructeur avec * paramètres sauf ID*/
	public Ingredient(String nomIngredient) {
		this.nomIngredient = nomIngredient;
	}

	/** Méthode to String et Get/Set */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomIngredient() {
		return nomIngredient;
	}

	public void setNomIngredient(String nomIngredient) {
		this.nomIngredient = nomIngredient;
	}





}


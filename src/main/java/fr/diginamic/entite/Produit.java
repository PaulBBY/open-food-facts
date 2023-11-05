package fr.diginamic.entite;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.diginamic.entite.element.MacroElements;
import fr.diginamic.entite.element.Mineraux;
import fr.diginamic.entite.element.Vitamines;
/**Représente le produit, et son modèle relationel */
@Entity
@Table(name="produit")
public class Produit {
	
	/** Id du produit, généré lors de l'insert dans la BDD */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/** Nom du produit */
	@Column(name="NOM_PRODUIT")
	private String nomProduit;
	
	/** Score nutritionnel du produit */
	@Column(name="NUTRITION_GRADE_FR")
	private char nutritionGradeFr;
	
	/** Enérgie pour 100g du produit.
	 * La valeur -1 correspond à une valeur non renseignée dans le fichier d'origine */
	@Column(name="ENERGIE_POUR_100G")
	private float energie100g;
	
	/** Masse de fibres pour 100g du produit.
	 * La valeur -1 correspond à une valeur non renseignée dans le fichier d'origine */
	@Column(name="FIBRES_POUR_100G")
	private float fibres100g;
	
	/**Masse de sel pour 100g de produit.
	 * La valeur -1 correspond à une valeur non renseignée dans le fichier d'origine */
	@Column(name="SEL_POUR_100G")
	private float sel100g;
	
	/**Présence d'huile de palme. 0 non, 1 oui, null non renseigné*/
	@Column(name="PRESENCE_HUILE_DE_PALME")
	private Boolean presenceHuileDePalme;

	/** Relation vers allergenes. Un objet allergene = un allergene.
	 * Un produit a plusieurs allergenes, un allergene est présent dans plusieurs produits*/
	@ManyToMany
	@JoinTable(name="PRODUITS_ALLERGENES",
		joinColumns= @JoinColumn(name="ID_PRODUIT", referencedColumnName = "ID"),
		inverseJoinColumns= @JoinColumn(name="ID_ALLERGENE", referencedColumnName="ID")
	)
	private Set<Allergene> allergenes;
	
	/** Relation vers additifs. Un objet additif = un additif.
	 * Un produit a plusieurs additifs, un additif est présent dans plusieurs produits*/ 
	@ManyToMany
	@JoinTable(name="PRODUITS_ADDITIFS",
		joinColumns= @JoinColumn(name="ID_PRODUIT", referencedColumnName = "ID"),
		inverseJoinColumns= @JoinColumn(name="ID_ATTITIFS", referencedColumnName="ID")
	)
	private Set<Additif> additifs;
	
	/** Relation vers ingrédients. Un objet ingrédient = un ingrédient.
	 * Un produit a plusieurs ingrédients, un ingrédient est présent dans plusieurs produits*/
	@ManyToMany
	@JoinTable(name="PRODUITS_INGREDIENTS",
			joinColumns= @JoinColumn(name="ID_PRODUIT", referencedColumnName = "ID"),
			inverseJoinColumns= @JoinColumn(name="ID_INGREDIENTS", referencedColumnName="ID")
	)
	private Set<Ingredient> ingredients;
	 
	/** Relation vers vitamines. Un objet vitamine = un ensemble de valeurs, pour un ensemble de vitamines c.f Vitamine.
	 * Un produit a une vitamine (objet, donc ensemble de vitamines), plusieurs vitamines (ensemble de vitamines) peuvent se retrouvées dans le même produit. */
	@ManyToOne
	private Vitamines vitamines;
	
	/** Relation vers macroElements. Un objet macroElements = un ensemble de valeurs, pour un ensemble de macroElements c.f MacroElements.
	 * Un produit a un macroElements (objet, donc ensemble de macroElements), plusieurs macroElements (ensemble de macroElements) peuvent se retrouvées dans le même produit. */
	@ManyToOne
	private MacroElements macroElements;
	
	/** Relation vers mineraux. Un objet mineraux = un ensemble de valeurs, pour un ensemble de mineraux c.f Vitamine.
	 * Un produit a un mineraux (objet, donc ensemble de mineraux), plusieurs mineraux (ensemble de mineraux) peuvent se retrouvées dans le même produit. */
	@ManyToOne
	private Mineraux mineraux;

	
	/** Relation vers ingrédients. Un objet ingrédient = un ingrédient.
	 * Un produit a plusieurs ingrédients, un ingrédient est présent dans plusieurs produits*/
	@ManyToOne
	private Marque marque;
	 
	/** Relation vers marque. Un objet marque = une marque.
	 * Un produit a une marque, une marque a plusieurs produits */
	@ManyToOne
	private Categorie categorie;

	/** Constructeur sans paramètre */
	public Produit() {
	}
	
	/** Constructeur avec * paramètres sauf ID*/
	public Produit(String nomProduit, char nutritionGradeFr, float energie100g, float fibres100g, float sel100g,
			Boolean presenceHuileDePalme, Set<Allergene> allergenes, Set<Additif> additifs, Set<Ingredient> ingredients,
			Vitamines vitamines, MacroElements macroElements, Mineraux mineraux, Marque marque, Categorie categorie) {
		this.nomProduit = nomProduit;
		this.nutritionGradeFr = nutritionGradeFr;
		this.energie100g = energie100g;
		this.fibres100g = fibres100g;
		this.sel100g = sel100g;
		this.presenceHuileDePalme = presenceHuileDePalme;
		this.allergenes = allergenes;
		this.additifs = additifs;
		this.ingredients = ingredients;
		this.vitamines = vitamines;
		this.macroElements = macroElements;
		this.mineraux = mineraux;
		this.marque = marque;
		this.categorie = categorie;
	}

	/** Méthode to String et Get/Set */

	@Override
	public String toString() {
		return "Produit [id=" + id + ", nomProduit=" + nomProduit + ", nutritionGradeFr=" + nutritionGradeFr
				+ ", energie100g=" + energie100g + ", fibres100g=" + fibres100g + ", sel100g=" + sel100g
				+ ", presenceHuileDePalme=" + presenceHuileDePalme + ", allergenes=" + allergenes + ", additifs="
				+ additifs + ", ingredients=" + ingredients + ", vitamines=" + vitamines + ", macroElements="
				+ macroElements + ", mineraux=" + mineraux + ", marque=" + marque + ", categorie=" + categorie + "]";
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomProduit() {
		return nomProduit;
	}

	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}

	public char getNutritionGradeFr() {
		return nutritionGradeFr;
	}

	public void setNutritionGradeFr(char nutritionGradeFr) {
		this.nutritionGradeFr = nutritionGradeFr;
	}

	public float getEnergie100g() {
		return energie100g;
	}

	public void setEnergie100g(float energie100g) {
		this.energie100g = energie100g;
	}

	public float getFibres100g() {
		return fibres100g;
	}

	public void setFibres100g(float fibres100g) {
		this.fibres100g = fibres100g;
	}

	public float getSel100g() {
		return sel100g;
	}

	public void setSel100g(float sel100g) {
		this.sel100g = sel100g;
	}

	public Boolean getPresenceHuileDePalme() {
		return presenceHuileDePalme;
	}

	public void setPresenceHuileDePalme(Boolean presenceHuileDePalme) {
		this.presenceHuileDePalme = presenceHuileDePalme;
	}

	public Set<Allergene> getAllergenes() {
		return allergenes;
	}

	public void setAllergenes(Set<Allergene> allergenes) {
		this.allergenes = allergenes;
	}

	public Set<Additif> getAdditifs() {
		return additifs;
	}

	public void setAdditifs(Set<Additif> additifs) {
		this.additifs = additifs;
	}

	public Set<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(Set<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public Vitamines getVitamines() {
		return vitamines;
	}

	public void setVitamines(Vitamines vitamines) {
		this.vitamines = vitamines;
	}

	public MacroElements getMacroElements() {
		return macroElements;
	}

	public void setMacroElements(MacroElements macroElements) {
		this.macroElements = macroElements;
	}

	public Mineraux getMineraux() {
		return mineraux;
	}

	public void setMineraux(Mineraux mineraux) {
		this.mineraux = mineraux;
	}

	public Marque getMarque() {
		return marque;
	}

	public void setMarque(Marque marque) {
		this.marque = marque;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}



}

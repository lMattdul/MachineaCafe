package domaine;

import java.util.Collection;
import domaine.Ingrédient;

public class Boisson {

	// Attributs
	private String nom;
	private double prix;
	// relation d'association unidirectionnelle (de ingrédient vers boisson) et
	// possédant une cardinalité
	private Collection<Ingrédient> mesIngrédients;

	// Constructeur
	public Boisson(String nom, double prix, Collection<Ingrédient> mesIngrédients) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.mesIngrédients = mesIngrédients;
	}
	
	public Boisson(String nom) {
		this.nom = nom;
		this.prix = 0;
		this.mesIngrédients = null;
	}

	// Getters & Setters
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Collection<Ingrédient> getMesIngrédients() {
		return mesIngrédients;
	}

	public void setMesIngrédients(Collection<Ingrédient> mesIngrédients) {
		this.mesIngrédients = mesIngrédients;
	}
}
package domaine;

import java.util.Collection;
import domaine.Ingr�dient;

public class Boisson {

	// Attributs
	private String nom;
	private double prix;
	// relation d'association unidirectionnelle (de ingr�dient vers boisson) et
	// poss�dant une cardinalit�
	private Collection<Ingr�dient> mesIngr�dients;

	// Constructeur
	public Boisson(String nom, double prix, Collection<Ingr�dient> mesIngr�dients) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.mesIngr�dients = mesIngr�dients;
	}
	
	public Boisson(String nom) {
		this.nom = nom;
		this.prix = 0;
		this.mesIngr�dients = null;
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

	public Collection<Ingr�dient> getMesIngr�dients() {
		return mesIngr�dients;
	}

	public void setMesIngr�dients(Collection<Ingr�dient> mesIngr�dients) {
		this.mesIngr�dients = mesIngr�dients;
	}
}
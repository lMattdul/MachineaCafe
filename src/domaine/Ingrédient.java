package domaine;

public class Ingrédient {

	// Attributs
	private String nom;
	private Boolean disponibilité;

	// Constructeur
	public Ingrédient(String nom, Boolean disponibilité) {
		super();
		this.nom = nom;
		this.disponibilité = disponibilité;
	}

	// Getters & Setters
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Boolean getDisponibilité() {
		return disponibilité;
	}

	public void setDisponibilité(Boolean disponibilité) {
		this.disponibilité = disponibilité;
	}

	@Override
	public String toString() {
		return "Ingrédient [nom=" + nom + ", disponibilité=" + disponibilité + "]";
	}
	
	
}

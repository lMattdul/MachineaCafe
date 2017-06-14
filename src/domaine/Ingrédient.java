package domaine;

public class Ingr�dient {

	// Attributs
	private String nom;
	private Boolean disponibilit�;

	// Constructeur
	public Ingr�dient(String nom, Boolean disponibilit�) {
		super();
		this.nom = nom;
		this.disponibilit� = disponibilit�;
	}

	// Getters & Setters
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Boolean getDisponibilit�() {
		return disponibilit�;
	}

	public void setDisponibilit�(Boolean disponibilit�) {
		this.disponibilit� = disponibilit�;
	}

	@Override
	public String toString() {
		return "Ingr�dient [nom=" + nom + ", disponibilit�=" + disponibilit� + "]";
	}
	
	
}

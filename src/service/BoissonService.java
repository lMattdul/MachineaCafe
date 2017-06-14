package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import DAO.EnqueteBoissonDAO;
import DAO.LireIngredients;
import domaine.Boisson;
import domaine.Ingrédient;
import fr.gtm.lamachineacafe.exception.SaisieException;

import java.util.Collection;

public class BoissonService {

	int choix;
	

	// définition d'une map avec les trois boissons disponibles dans la machine
	// à café. La généricité apparait ici dans la création de la map.
	public Map<String, Boisson> getboisson() {

		IngrédientsChocoService mesIngrédientsChoco = new IngrédientsChocoService();
		IngrédientsCaféService mesIngrédientsCafé = new IngrédientsCaféService();
		IngrédientsThéService mesIngrédientsThé = new IngrédientsThéService();
		Map<String, Boisson> monChoix = new HashMap<String, Boisson>();

		Boisson boisson1 = new Boisson("café", 1, mesIngrédientsCafé.getIngrédients());
		Boisson boisson2 = new Boisson("chocolat", 1.5, mesIngrédientsChoco.getIngrédients());
		Boisson boisson3 = new Boisson("thé", 1.25, mesIngrédientsThé.getIngrédients());

		monChoix.put("CAF", boisson1);
		monChoix.put("CHO", boisson2);
		monChoix.put("THE", boisson3);

		return monChoix;
	}

	// création d'une méthode donnant la disponibilité d'une boisson en fonction
	// de ses éléments. Elle met en évidence la relation de dépendance entre les
	// classes BoissonService et Boisson
	public String getDisponibilité(Boisson boisson) {

		Collection<Ingrédient> ingrédientsmaBoisson = boisson.getMesIngrédients();
		String dispo = "indisponible";
		// on utilise la boucle for pour parcourir tout les ingrédients de la
		// liste
		for (Ingrédient ingrédient : ingrédientsmaBoisson) {
			if (ingrédient.getDisponibilité() == false) {
				dispo = "indisponible";
			} else {
				dispo = "disponible";
			}

		}
		return dispo;
	}

	// définition de la méthode permettant le choix de la boisson
	public int choixBoisson(Scanner sc1) throws SaisieException {
		choix = 0;

		// Affichage du choix
		System.out.println("Faites votre choix :");
		System.out.println("1. Café");
		System.out.println("2. Chocolat");
		System.out.println("3. Thé");

		// Choix du client
		choix = sc1.nextInt();

		if (choix != 1 && choix != 2 && choix != 3)
			throw new SaisieException("Faites un choix entre 1,2 et 3.");

		return choix;

	}

	// définition d'une méthode nous donnant toutes les informations disponibles
	// sur la boisson choisie.
	// Elle met également en évidence la relation de dépendance entre les
	// classes BoissonService et Boisson

	public void infoBoisson(Boisson maBoisson) {
		System.out.println("Vous avez choisi : " + maBoisson.getNom());
		// J'ai ajouté un délai de 1 seconde entre chaque information pour ne
		// pas les avoir toutes d'un seul coup.
		try {
			TimeUnit.SECONDS.sleep((long) 1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		System.out.println("Cette boisson est " + getDisponibilité(maBoisson) + ".");
		try {
			TimeUnit.SECONDS.sleep((long) 1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		String dispo = getDisponibilité(maBoisson);
		if ("disponible".equals(dispo)) {
			System.out.println("elle coûte " + maBoisson.getPrix() + " euros.");
			try {
				TimeUnit.SECONDS.sleep((long) 1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			System.out.println("Merci de patienter jusqu'à la fin de la préparation.");
		} else {
			System.out.println("Veuillez choisir une autre boisson.");
		}
	}
	
	public String enqueteBoisson(Scanner sc1) throws SaisieException{
		System.out.println("Voudriez-vous voir une nouvelle boisson proposer par notre machine ?");
		System.out.println("Repondez par oui (O) ou non (N).");
		sc1.nextLine();
		String reponse = sc1.nextLine();
		if(reponse.equals("O") && reponse.equals("N")) 
			throw new SaisieException("Veuillez choisir entre O et N");
		return reponse;
	}
	
	public String choixPresIngr(Scanner sc1) throws SaisieException{
		System.out.println("Voudriez-vous avoir acces a un ingredient par son ID ou a la liste complete ?");
		System.out.println("Repondez par id (ID) ou listeComplete (LC).");
		String reponse = sc1.nextLine();
		if(reponse.equals("ID") && reponse.equals("LC")) 
			throw new SaisieException("Veuillez choisir entre ID et LC");
		return reponse;
	}
	
	public void insertBoisson(Boisson maBoissonProposee){
		EnqueteBoissonDAO enquete = new EnqueteBoissonDAO();
		enquete.sauverEnBase(maBoissonProposee);
	}


	public Ingrédient transfertIDIngr(int ID){
		LireIngredients lecture = new LireIngredients();
		Ingrédient ingredientbyID = lecture.lireEnBase(ID);
		return ingredientbyID;
	}
	
	public List<Ingrédient> transfertListIngr(){
		LireIngredients lecture = new LireIngredients();
		List<Ingrédient> listIngr = lecture.lireTous();
		return listIngr;
	}
}


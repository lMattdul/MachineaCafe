package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import DAO.EnqueteBoissonDAO;
import DAO.LireIngredients;
import domaine.Boisson;
import domaine.Ingr�dient;
import fr.gtm.lamachineacafe.exception.SaisieException;

import java.util.Collection;

public class BoissonService {

	int choix;
	

	// d�finition d'une map avec les trois boissons disponibles dans la machine
	// � caf�. La g�n�ricit� apparait ici dans la cr�ation de la map.
	public Map<String, Boisson> getboisson() {

		Ingr�dientsChocoService mesIngr�dientsChoco = new Ingr�dientsChocoService();
		Ingr�dientsCaf�Service mesIngr�dientsCaf� = new Ingr�dientsCaf�Service();
		Ingr�dientsTh�Service mesIngr�dientsTh� = new Ingr�dientsTh�Service();
		Map<String, Boisson> monChoix = new HashMap<String, Boisson>();

		Boisson boisson1 = new Boisson("caf�", 1, mesIngr�dientsCaf�.getIngr�dients());
		Boisson boisson2 = new Boisson("chocolat", 1.5, mesIngr�dientsChoco.getIngr�dients());
		Boisson boisson3 = new Boisson("th�", 1.25, mesIngr�dientsTh�.getIngr�dients());

		monChoix.put("CAF", boisson1);
		monChoix.put("CHO", boisson2);
		monChoix.put("THE", boisson3);

		return monChoix;
	}

	// cr�ation d'une m�thode donnant la disponibilit� d'une boisson en fonction
	// de ses �l�ments. Elle met en �vidence la relation de d�pendance entre les
	// classes BoissonService et Boisson
	public String getDisponibilit�(Boisson boisson) {

		Collection<Ingr�dient> ingr�dientsmaBoisson = boisson.getMesIngr�dients();
		String dispo = "indisponible";
		// on utilise la boucle for pour parcourir tout les ingr�dients de la
		// liste
		for (Ingr�dient ingr�dient : ingr�dientsmaBoisson) {
			if (ingr�dient.getDisponibilit�() == false) {
				dispo = "indisponible";
			} else {
				dispo = "disponible";
			}

		}
		return dispo;
	}

	// d�finition de la m�thode permettant le choix de la boisson
	public int choixBoisson(Scanner sc1) throws SaisieException {
		choix = 0;

		// Affichage du choix
		System.out.println("Faites votre choix :");
		System.out.println("1. Caf�");
		System.out.println("2. Chocolat");
		System.out.println("3. Th�");

		// Choix du client
		choix = sc1.nextInt();

		if (choix != 1 && choix != 2 && choix != 3)
			throw new SaisieException("Faites un choix entre 1,2 et 3.");

		return choix;

	}

	// d�finition d'une m�thode nous donnant toutes les informations disponibles
	// sur la boisson choisie.
	// Elle met �galement en �vidence la relation de d�pendance entre les
	// classes BoissonService et Boisson

	public void infoBoisson(Boisson maBoisson) {
		System.out.println("Vous avez choisi : " + maBoisson.getNom());
		// J'ai ajout� un d�lai de 1 seconde entre chaque information pour ne
		// pas les avoir toutes d'un seul coup.
		try {
			TimeUnit.SECONDS.sleep((long) 1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		System.out.println("Cette boisson est " + getDisponibilit�(maBoisson) + ".");
		try {
			TimeUnit.SECONDS.sleep((long) 1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		String dispo = getDisponibilit�(maBoisson);
		if ("disponible".equals(dispo)) {
			System.out.println("elle co�te " + maBoisson.getPrix() + " euros.");
			try {
				TimeUnit.SECONDS.sleep((long) 1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			System.out.println("Merci de patienter jusqu'� la fin de la pr�paration.");
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


	public Ingr�dient transfertIDIngr(int ID){
		LireIngredients lecture = new LireIngredients();
		Ingr�dient ingredientbyID = lecture.lireEnBase(ID);
		return ingredientbyID;
	}
	
	public List<Ingr�dient> transfertListIngr(){
		LireIngredients lecture = new LireIngredients();
		List<Ingr�dient> listIngr = lecture.lireTous();
		return listIngr;
	}
}


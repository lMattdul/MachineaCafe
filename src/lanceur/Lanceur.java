package lanceur;

import domaine.Boisson;
import domaine.Ingrédient;
import service.BoissonService;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import fr.gtm.lamachineacafe.exception.*;

public class Lanceur {

	public static void main(String[] args) {
		// TODO

		// Création d'un scanner pour récupéré le choix du client.
		Scanner sc1 = new Scanner(System.in);
		int choix = 0;
		String reponse = "";
		String nomBoisson = "";
		String reponse1 = "";
		
		BoissonService boissonService1;
		Map<String, Boisson> monChoix;

		boissonService1 = new BoissonService();
		monChoix = boissonService1.getboisson();

		// J'ai ajouté une méthode permettant de faire son choix de boisson pour
		// pouvoir y ajouter une exception
		do {
			try {
				choix = boissonService1.choixBoisson(sc1);
			} catch (SaisieException A) {
				System.out.println(A.getMessage());
			}
		} while (choix != 1 && choix != 2 && choix != 3);



		// Réponse machine
		switch (choix) {
		case 1:
			Boisson maBoisson1 = monChoix.get("CAF");
			boissonService1.infoBoisson(maBoisson1);
			break;
		case 2:
			Boisson maBoisson2 = monChoix.get("CHO");
			boissonService1.infoBoisson(maBoisson2);
			break;
		case 3:
			Boisson maBoisson3 = monChoix.get("THE");
			boissonService1.infoBoisson(maBoisson3);
			break;
		}
		
		// Enquête pour introduction de nouvelle boisson
		do {
			try {
				reponse = boissonService1.enqueteBoisson(sc1);
			} catch (SaisieException A) {
				System.out.println(A.getMessage());
			}
		} while (!reponse.equals("N") && !reponse.equals("O"));
		
		if(reponse.equals("N")) {
			System.out.println("Merci, et passez une bonne journee");
		}
		else{
		System.out.println("Veuillez entrer votre proposition :");
		nomBoisson= sc1.nextLine();
		Boisson maBoissonProposee = new Boisson(nomBoisson);
		boissonService1.insertBoisson(maBoissonProposee);
		System.out.println("Votre proposition a bien été prise en compte.");
		System.out.println("Merci de votre participation");
		}
		
		
		//Recuperation du Status des ingrédients ou d'un ingrédients (par ID)
		do{
			try{
				reponse1 = boissonService1.choixPresIngr(sc1);
			}catch (SaisieException B) {
				System.out.println(B.getMessage());
			}
		} while (!reponse1.equals("LC") && !reponse1.equals("ID"));
		
		if(reponse1.equals("ID")) {
		//Recuperation de l'ID
		System.out.println("Choissisez un ingrédient par son identifiant (entre 1 et 5)");
		int id = sc1.nextInt();
		Ingrédient ingredient = boissonService1.transfertIDIngr(id);
		System.out.println(ingredient);
		} else{
		//Récupération de la Liste
		List<Ingrédient> maListe = boissonService1.transfertListIngr();
		System.out.println(maListe);
		}
		
		sc1.close();
	}

}

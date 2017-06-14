package service;

import domaine.Ingr�dient;

public abstract class Ingr�dientsService implements Cr�ationListeIngr�dients {

	// Cr�ation d'une classe abstraite instanciant diff�rents ingr�dient
	// (puisque l'on a pas de base de donn�es) et implementant
	// l'interface Cr�ationListeIngr�dients. La m�thodes est red�finie dans les
	// classes filles qui font r�f�rence chacune a une boisson.

	Ingr�dient eau = new Ingr�dient("Eau", true);
	Ingr�dient choco = new Ingr�dient("Chocolat en poudre", true);
	Ingr�dient lait = new Ingr�dient("Lait en poudre", true);
	Ingr�dient caf� = new Ingr�dient("Caf� en pourdre", true);
	Ingr�dient th� = new Ingr�dient("Th� en poudre", false);

}

package service;

import domaine.Ingrédient;

public abstract class IngrédientsService implements CréationListeIngrédients {

	// Création d'une classe abstraite instanciant différents ingrédient
	// (puisque l'on a pas de base de données) et implementant
	// l'interface CréationListeIngrédients. La méthodes est redéfinie dans les
	// classes filles qui font référence chacune a une boisson.

	Ingrédient eau = new Ingrédient("Eau", true);
	Ingrédient choco = new Ingrédient("Chocolat en poudre", true);
	Ingrédient lait = new Ingrédient("Lait en poudre", true);
	Ingrédient café = new Ingrédient("Café en pourdre", true);
	Ingrédient thé = new Ingrédient("Thé en poudre", false);

}

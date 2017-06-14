package service;

import java.util.Collection;

import domaine.Ingrédient;

public interface CréationListeIngrédients {

	// Création d'une interface qui introduit la méthode getIngrédient servant à
	// créé des listes d'ingrédients.

	public Collection<Ingrédient> getIngrédients();
}

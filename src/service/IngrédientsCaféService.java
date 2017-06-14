package service;

import java.util.ArrayList;
import java.util.Collection;

import domaine.Ingrédient;

public class IngrédientsCaféService extends IngrédientsService {

	public Collection<Ingrédient> getIngrédients() {
		Collection<Ingrédient> ingrédientsCafé = new ArrayList<Ingrédient>();
		ingrédientsCafé.add(eau);
		ingrédientsCafé.add(café);
		return ingrédientsCafé;
	}
}
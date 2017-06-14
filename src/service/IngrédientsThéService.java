package service;

import java.util.ArrayList;
import java.util.Collection;

import domaine.Ingrédient;

public class IngrédientsThéService extends IngrédientsService {

	public Collection<Ingrédient> getIngrédients() {
		Collection<Ingrédient> ingrédientsThé = new ArrayList<Ingrédient>();
		ingrédientsThé.add(eau);
		ingrédientsThé.add(thé);
		return ingrédientsThé;
	}
}
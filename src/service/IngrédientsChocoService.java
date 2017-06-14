package service;

import java.util.ArrayList;
import java.util.Collection;

import domaine.Ingrédient;

public class IngrédientsChocoService extends IngrédientsService {

	public Collection<Ingrédient> getIngrédients() {
		Collection<Ingrédient> ingrédientsChoco = new ArrayList<Ingrédient>();
		ingrédientsChoco.add(eau);
		ingrédientsChoco.add(choco);
		ingrédientsChoco.add(lait);
		return ingrédientsChoco;
	}
}

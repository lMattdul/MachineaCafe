package service;

import java.util.ArrayList;
import java.util.Collection;

import domaine.Ingr�dient;

public class Ingr�dientsChocoService extends Ingr�dientsService {

	public Collection<Ingr�dient> getIngr�dients() {
		Collection<Ingr�dient> ingr�dientsChoco = new ArrayList<Ingr�dient>();
		ingr�dientsChoco.add(eau);
		ingr�dientsChoco.add(choco);
		ingr�dientsChoco.add(lait);
		return ingr�dientsChoco;
	}
}

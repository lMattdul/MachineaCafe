package service;

import java.util.ArrayList;
import java.util.Collection;

import domaine.Ingr�dient;

public class Ingr�dientsTh�Service extends Ingr�dientsService {

	public Collection<Ingr�dient> getIngr�dients() {
		Collection<Ingr�dient> ingr�dientsTh� = new ArrayList<Ingr�dient>();
		ingr�dientsTh�.add(eau);
		ingr�dientsTh�.add(th�);
		return ingr�dientsTh�;
	}
}
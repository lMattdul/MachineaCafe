package service;

import java.util.ArrayList;
import java.util.Collection;

import domaine.Ingr�dient;

public class Ingr�dientsCaf�Service extends Ingr�dientsService {

	public Collection<Ingr�dient> getIngr�dients() {
		Collection<Ingr�dient> ingr�dientsCaf� = new ArrayList<Ingr�dient>();
		ingr�dientsCaf�.add(eau);
		ingr�dientsCaf�.add(caf�);
		return ingr�dientsCaf�;
	}
}
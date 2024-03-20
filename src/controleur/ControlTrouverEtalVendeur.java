package controleur;

import villagegaulois.Etal;
import villagegaulois.Village;
import personnages.Gaulois; //Ajouté

public class ControlTrouverEtalVendeur {
	private Village village;

	public ControlTrouverEtalVendeur(Village village) {
		this.village = village;
	}

	public Etal trouverEtalVendeur(String nomVendeur) {
		//TODO a completer
		Etal etal = null;
		Gaulois gauloisVendeur = village.trouverHabitant(nomVendeur);
		if(gauloisVendeur!=null) {
			etal = village.rechercherEtal(gauloisVendeur);
		}
		
		return etal;
	}
}
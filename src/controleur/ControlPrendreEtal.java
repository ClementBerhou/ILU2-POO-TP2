package controleur;

import villagegaulois.Village;

import personnages.Gaulois; //Ajouté

public class ControlPrendreEtal {
	private Village village;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlPrendreEtal(ControlVerifierIdentite controlVerifierIdentite,
			Village village) {
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.village = village;
	}

	public boolean resteEtals() {
		//TODO a completer, attention le retour ne dit pas etre false :-)
		if(village.rechercherEtalVide()==true) {
			return true;
		}
		
		return false;
	}

	public int prendreEtal(String nomVendeur, String produit, int nbProduit) {
		//TODO a completer
		Gaulois gauloisVendeur = village.trouverHabitant(nomVendeur);
		int numeroEtal = village.installerVendeur(gauloisVendeur, produit, nbProduit);
		numeroEtal++; 
		return numeroEtal;
	}

	public boolean verifierIdentite(String nomVendeur) {
		//TODO a completer, attention le retour ne dit pas etre false :-)
		
		if(controlVerifierIdentite.verifierIdentite(nomVendeur)==true) {
			return true;
		}
		
		return false;
	}
}
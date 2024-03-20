package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		//TODO a completer
		
		if(controlLibererEtal.isVendeur(nomVendeur)==false) 
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui ! \n");
		else {
			String[] donneesEtalBoundary = new String[5];
			donneesEtalBoundary = controlLibererEtal.libererEtal(nomVendeur);
			/*
			String etalOccupe = donneesEtalBoundary[0];
			Boolean etalOcc = Boolean.valueOf(etalOccupe);
			if(etalOcc==false) {
				
			}*/
			String quantiteVendu = donneesEtalBoundary[4];
			String quantiteInitial = donneesEtalBoundary[3];
			String produit = donneesEtalBoundary[2];
			String nomVendeurBoundary = donneesEtalBoundary[1];
			System.out.println("Vous avez vendu "+quantiteVendu+" sur"+quantiteInitial+" "+produit+".\n");
			System.out.println("Au revoir "+nomVendeurBoundary+" passez une bonne journée.");
		}
	}

}
package controleur;

import villagegaulois.Etal;

public class ControlLibererEtal {
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	public ControlLibererEtal(ControlTrouverEtalVendeur controlTrouverEtalVendeur) {
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	/**
	 * 
	 * @param produit
	 * @return donneesEtal est un tableau de chaine contenant
	 * 		[0] : un boolean indiquant si l'�tal est occup�
	 * 		[1] : nom du vendeur
	 * 		[2] : produit vendu
	 * 		[3] : quantit� de produit � vendre au d�but du march�
	 * 		[4] : quantit� de produit vendu
	 */
	public String[] libererEtal(String nomVendeur) {
		String[] donneesEtal = new String[5];
        Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
        if (isVendeur(nomVendeur))
        	donneesEtal = etal.etatEtal();
        
		return donneesEtal;
	}

	public boolean isVendeur(String nomVendeur) {
		return (controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur) != null);
	}

}
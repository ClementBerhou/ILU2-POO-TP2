package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;
import controleur.ControlVerifierIdentite;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		StringBuilder chaine = new StringBuilder();
		if(!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			chaine.append("Je suis d�sol� ");
			chaine.append(nomVendeur);
			chaine.append(" mais il faut �tre un habitant de notre village pour commencer ici.\n");
			System.out.println(chaine);
		} else {
			chaine.append("Bonjour ");
			chaine.append(nomVendeur);
			chaine.append(" je vais regarder si je peux vous trouver un �tal.\n");
			System.out.println(chaine);
			if(!controlPrendreEtal.resteEtals()) {
				chaine.append("D�sol�" + nomVendeur + "je n'ai plus d'�tal qui ne soit pas d�ja occup�\n");
				System.out.println(chaine);
			} else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		StringBuilder chaine = new StringBuilder();
		chaine.append("C'est parfait il me reste un �tal pour vous !\n");
		chaine.append("Il me faudrait quelques renseignements :\n");
		chaine.append("Quels produits souhaitez vous vendre?\n");
		System.out.println(chaine);
		String produit = scan.next();
		int nbProduit = Clavier.entrerEntier("Combien souhaitez-vous en vendre?\n");
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if (numeroEtal != -1) {
			System.out.println("Le vendeur " + nomVendeur + " s'est install� � l'�tal n� " + numeroEtal + ".\n");
		}
	}
}
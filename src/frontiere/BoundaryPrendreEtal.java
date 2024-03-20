package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}
	
	public String entrerClavierProduit() {
		Scanner sc = new Scanner(System.in);
		String produit= sc.next();
		return produit;
	}
	public int entrerNbProduit() {
		Scanner sc = new Scanner(System.in);
		int nbProduit = sc.nextInt();
		return nbProduit;
	}

	public void prendreEtal(String nomVendeur) {
		//TODO a completer
		//debut modif
		if(controlPrendreEtal.verifierIdentite(nomVendeur)==false) {
			System.out.println("Je suis désolée "+nomVendeur+" mais il faut être un habitant de notre village pour commercer ici. \n");
		}
		else {
			System.out.println("Bonjour "+nomVendeur+" ,je vais regarder si je peux vous trouver un étal. \n");
			if(controlPrendreEtal.resteEtals()==false) {
				System.out.println("Désolée "+nomVendeur+" je n'ai plus d'étal qui ne soit pas déjà occupé. \n");
			}
			else {
				installerVendeur(nomVendeur);	
			}
		}
		//fin modif
	}

	private void installerVendeur(String nomVendeur) { 
		//TODO a completer
		System.out.println("C'est parfait, il me reste un étal pour vous ! \n");
		System.out.println("Il me faudrait quelques renseignements : \n");
		System.out.println("Quel produit souhaitez-vous vendre ? \n");
		String Produit = entrerClavierProduit();
		System.out.println("Combien souhaitez-vous en vendre ? \n");
		int nbProduit = entrerNbProduit();
		int numEtal =controlPrendreEtal.prendreEtal(nomVendeur, Produit, nbProduit);
		if(numEtal !=-1) {
			numEtal+=1; //Sinon on est à l'étal 0 ):
			System.out.println("Le vendeur "+nomVendeur+" s'est installé à l'étal n° "+numEtal+"\n");
		}
	}
}
package frontiere;

import controleur.ControlEmmenager;
import java.util.Scanner;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}
	
	//ma modif
	public int entrerForceClavier() {
		Scanner sc = new Scanner(System.in);
		int force = sc.nextInt();
		return force;
	}
	public int entrerForcePotionMin() {
		Scanner sc = new Scanner(System.in);
		int forceMin = sc.nextInt();
		return forceMin;
	}
	public int entrerForcePotionMax() {
		Scanner sc = new Scanner(System.in);
		int forceMax = sc.nextInt();
		return forceMax;
	}
	//fin modif

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					//TODO a completer
					System.out.println("Bienvenu villageois"+nomVisiteur+"\n");
					System.out.println("Quelle est votre force ? \n");
					controlEmmenager.ajouterGaulois(nomVisiteur,entrerForceClavier());
					break;

				default:
					System.out.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}
	
	

	private void emmenagerDruide(String nomVisiteur) {
		//TODO a completer
		System.out.println("Bienvenu druide "+nomVisiteur+"\n");
		System.out.println("Quelle est votre force ? \n");
		int forceDruide = entrerForceClavier();
		int effetPotionMin;
		int effetPotionMax;
		do {
			System.out.println("Quelle est la force de la potion la plus faible que vous produisez ? \n");
			effetPotionMin = entrerForcePotionMin();
			System.out.println("Quelle est la force de la potion la plus forte que vous produisez ? \n");
			effetPotionMax = entrerForcePotionMax();
			if(effetPotionMin>effetPotionMax) {
				System.out.println("Attention Druide, vous vous êtes trompé entre le minimum et le maximum");
			}
		}while(effetPotionMax<effetPotionMin);
		controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, effetPotionMin , effetPotionMax);
		
		
	}
}
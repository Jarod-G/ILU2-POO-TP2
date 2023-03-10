package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if(controlAcheterProduit.isHabitant(nomAcheteur)) {
			System.out.println("Quelle produit voulez-vous acheter ?");
			String produit = scan.next();
			String[] listeVendeur = controlAcheterProduit.listeVendeur(produit);
			System.out.println("Chez quel commerçant voulez-vous acheter des fleurs ?");
			for (int i = 0; i < listeVendeur.length; i++) {
				System.out.println((i+1) + " - " + listeVendeur[i]);
			}
			int vendeurChoisi = scan.nextInt();
			if(1 <= vendeurChoisi &&  vendeurChoisi <= listeVendeur.length) {
				System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + listeVendeur[vendeurChoisi - 1]);
				System.out.println("Bonjour" + nomAcheteur);
				System.out.println("Combien de fleurs voulez-vous acheter ?");
				int nbProduit = scan.nextInt();
				if(0<nbProduit && nbProduit <= ) //finir
				System.out.println(nomAcheteur + " a acheté " + nbProduit + " de " + produit + " à " + listeVendeur[vendeurChoisi - 1] + ".");
			}
		}else {
			System.out.println("Vous n'êtes pas un habitant du village, vous ne pouvez pas acheter de produits ici.");
		}
		
	}
}

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
			System.out.println("Chez quel commerçant voulez-vous acheter le produit ?");
			int i = 0;
			int nbVendeur = 0;
			while(listeVendeur[i] != null) {
				System.out.println((i+1) + " - " + listeVendeur[i]);
				nbVendeur++;
				i++;
			}
			if(nbVendeur >= 1) {
				int vendeurChoisi = scan.nextInt();
				if(1 <= vendeurChoisi &&  vendeurChoisi <= nbVendeur) {
					System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + listeVendeur[vendeurChoisi - 1]);
					System.out.println("Bonjour " + nomAcheteur);
					System.out.println("Combien de fleurs voulez-vous acheter ?");
					int nbProduit = scan.nextInt();
					if(0<=nbProduit){
						int quantiteVendue = controlAcheterProduit.acheterProduitVendeur(listeVendeur[vendeurChoisi - 1], nbProduit);
						System.out.println(nomAcheteur + " a acheté " + quantiteVendue + " de " + produit + " à " + listeVendeur[vendeurChoisi - 1] + ".");
						
					}else {
						System.out.println("Nombre négatif incorrecte, entrée un nombre positif ou 0.");
					}
				}else {
					System.out.println("Ce vendeur n'existe pas.");
				}
			}else {
				System.out.println("Aucun marchand ne vend ce produit.");
			}
		}else {
			System.out.println("Vous n'êtes pas un habitant du village, vous ne pouvez pas acheter de produits ici.");
		}
		
	}
}

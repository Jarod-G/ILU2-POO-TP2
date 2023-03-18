package controleur;

import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}
	
	public boolean isHabitant(String nomAcheteur) {
		if(controlVerifierIdentite.verifierIdentite(nomAcheteur)) {
			return true;
		}
		return false;
	}
	
	
	public String[] listeVendeur(String produit) {
		String[] infosMarche = village.donnerEtatMarche();
		String[] vendeurListe = new String[5];;
		int k = 0;
		for (int i = 0; i < infosMarche.length; i+=3) {
			String vendeur = infosMarche[i];
			Etal produitVendeur = controlTrouverEtalVendeur.trouverEtalVendeur(vendeur);
			if(produitVendeur.contientProduit(produit)) {
				vendeurListe[k] = vendeur;
				k++;
			}
		}
		return vendeurListe;
	}
	
	
	public int acheterProduitVendeur(String nomVendeur, int quantite) {
		Etal vendeur = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		int quantiteAcheter = 0;
		if(vendeur != null) {
			quantiteAcheter = vendeur.acheterProduit(quantite);
		}
		
		return quantiteAcheter;
	}
	
}

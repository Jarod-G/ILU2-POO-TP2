package controleur;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ControlTrouverEtalVendeurTest {
	
	private Village village;
	private Gaulois obelix;
	private Chef abraracourcix;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		
		obelix = new Gaulois("Obelix", 10);
		village.ajouterHabitant(obelix);
		village.installerVendeur(obelix, "fleurs", 10);
		
		
	}
	
	
	@Test
	void testControlTrouverEtalVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		assertNotNull(controlTrouverEtalVendeur, "Constructeur ne renvoie pas null");
	}
	
	@Test
	void testTrouverEtalVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		assertEquals(controlTrouverEtalVendeur.trouverEtalVendeur(obelix.getNom()).getVendeur(), obelix);
		assertNull(controlTrouverEtalVendeur.trouverEtalVendeur("Astérix"));
	}
	

}

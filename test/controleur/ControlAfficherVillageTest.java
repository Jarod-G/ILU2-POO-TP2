package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherVillageTest {

	private Village village;
	private Gaulois obelix;
	private Druide machix;
	private Chef abraracourcix;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		
		obelix = new Gaulois("Obelix",10);
		machix = new Druide("Machix",10,5,10);
		village.ajouterHabitant(obelix);
		village.ajouterHabitant(machix);

	}
	
	
	@Test
	void testControlAfficherVillage() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertNotNull(controlAfficherVillage, "Constructeur ne renvoie pas null");
	}
	
	@Test
	void testDonnerNomsVillageois() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);

		assertTrue(controlAfficherVillage.donnerNomsVillageois()[0] == "Obelix");
		assertTrue(controlAfficherVillage.donnerNomsVillageois()[1] == "Machix"); // FINIR ICI
	}

}

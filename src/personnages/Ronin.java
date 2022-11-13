package personnages;

public class Ronin extends Humain {
	private int honneur = 1;
		
	public Ronin(String nom, String boisson, int argent) {
		super(nom, boisson, argent);
	}

	public void donner(Commercant commercant) {
		int sommeDonnee = getArgent()/10;
		parler( commercant.getNom() +" prend ces " + sommeDonnee + " sous.");
		commercant.recevoir(sommeDonnee);
		perdreArgent(sommeDonnee);
	}
}

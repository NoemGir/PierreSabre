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
	
	public void provoquer(Yakuza adversaire) {
		parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand!");
		if (honneur*2 >= adversaire.getReputation()) {
			parler("Je t'ai eu petit yakusa!");
			gagnerArgent(adversaire.perdre());
			honneur++;
		} else {
			parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse ont en pris un coup.");
			adversaire.gagner(getArgent());
			perdreArgent(getArgent());
			honneur--;
		}
	}
}

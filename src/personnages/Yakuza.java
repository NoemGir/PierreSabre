package personnages;

public class Yakuza extends Humain {
	private String clan;
	private int reputation = 0;

	public Yakuza(String nom, String boisson, int argent, String clan) {
		super(nom, boisson, argent);
		this.clan = clan;
	}
	
	public void extorquer(Commercant victime) {
		parler("Tiens, tiends, ne serait-ce pas un faible marchand qui passe par la ?");
		parler(victime.getNom() + ", si tu tiens a la vie donne moi ta bourse !");
		int argentGagne = victime.seFaireExtorquer();
		gagnerArgent(argentGagne);
		parler("J'ai piqué les " + argentGagne + " sous de " + victime.getNom() + ", ce qui me fait " + getArgent() + " sous dans ma poche. Hehe");
		
	}
}

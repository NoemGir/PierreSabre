package personnages;

public class Yakuza extends Humain {
	private String clan;
	private int reputation = 0;

	public Yakuza(String nom, String boisson, int argent, String clan) {
		super(nom, boisson, argent);
		this.clan = clan;
	}
	
	
	public int getReputation() {
		return reputation;
	}

	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Mon clan est celui de " + clan);
	}
	
	public void extorquer(Commercant victime) {
		parler("Tiens, tiends, ne serait-ce pas un faible marchand qui passe par la ?");
		parler(victime.getNom() + ", si tu tiens a la vie donne moi ta bourse !");
		int argentGagne = victime.seFaireExtorquer();
		gagnerArgent(argentGagne);
		parler("J'ai pique les " + argentGagne + " sous de " + victime.getNom() + ", ce qui me fait " + getArgent() + " sous dans ma poche. Hehe");
		
	}
	
	public void gagner(int gain) {
		gagnerArgent(gain);
		reputation++;
		parler("Ce ronin pensait vraiment battre " + getNom() + " du " + clan + " ? Je l'ai dépuillé de ses " + gain + " sous.");
	}
	
	public int perdre() {
		int argentPerdu = getArgent();
		perdreArgent(argentPerdu);
		reputation --;
		parler("J’ai perdu mon duel et mes " + argentPerdu + " sous, snif... J'ai déshonoré le " + clan + ".");
		return(argentPerdu);
	}
}

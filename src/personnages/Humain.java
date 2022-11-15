package personnages;

public class Humain {
	private String nom;
	private String boisson;
	private int argent;
	protected int nbConnaissance;
	protected Humain[] memoire = new Humain[30];
	
	public Humain(String nom, String boisson, int argent) {
		this.nom = nom;
		this.boisson = boisson;
		this.argent = argent;
	}

	protected String getNom() {
		return nom;
	}
	
	protected int getArgent() {
		return argent;
	}
	
	protected void parler(String texte) {
		System.out.println("(" + nom + ") - " + texte);
	}
	
	public void direBonjour() {
		parler("Bonjour ! je m'appelle " + nom + " et j'aime boire du " + boisson + ".");
	}
	
	public void boire() {
		parler("Mmmm, un bon verre de " + boisson + " ! GLOUPS !");
	}
	
	public void acheter(String bien, int prix) {
		if (argent >= prix) {
			parler(" J'ai " + argent + " sous en poche. Je vais pouvoir m'offrir " + bien + " a " + prix + "sous.");
			perdreArgent(prix);
		}
		else {
			parler("je n'ai plus que " + argent + " sous en poche. Je ne peux meme pas m'offrir " + bien + " a " + prix + " sous.");
		}
	}
	
	public void perdreArgent(int perte) {
		argent -= perte;
	}
	
	public void gagnerArgent(int gain) {
		argent += gain;
	}
	
	public void faireConnaissanceAvec(Humain autreHumain) {
		direBonjour();
		autreHumain.repondre(this);
		memoriser(autreHumain);
	}
	
	public void repondre(Humain Humain1) {
		direBonjour();
		memoriser(Humain1);
	}
	
	public void memoriser(Humain nouvelHumain) {
		if (nbConnaissance < 30) {
			memoire[nbConnaissance] = nouvelHumain;
			nbConnaissance ++;
		}
		else {
			for (int i = 0; i<nbConnaissance-1; i++) {
				memoire[i]=memoire[i+1];
			}
			memoire[29]=nouvelHumain;
		}
	}
	
	public void listerConnaissance() {
		if (nbConnaissance >=1) {
			String texte = new String();
			for (int i=0; i<nbConnaissance; i++) {
				texte += memoire[i].getNom() + ", ";
			}
			parler("Je connais beaucoup de monde dont : " + texte);
		}
	}
}

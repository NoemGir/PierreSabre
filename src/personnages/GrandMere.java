package personnages;

import java.util.Random;

public class GrandMere extends Humain {
	private Humain[] memoire = new Humain[5];
	private TypeHumain[] type = TypeHumain.values();

	public GrandMere(String nom, int argent) {
		super(nom, "tisane", argent);
	}
	
	private enum TypeHumain{
		HABITANT("Habitant"),
		GRANDMERE("Grand-mere"),
		RONIN("Ronin"),
		COMMERCANT("Commercant"),
		YAKUZA("Yakuza"),
		TRAITRE("Traitre"),
		SAMOURAI("Samurai");
		
		private String nom;
		
		private TypeHumain( String nom ) {
			this.nom = nom;
			}

		public String getNom() {
			return nom;
		}

	}

	
	@Override
	public void memoriser(Humain nouvelHumain) {
		if (nbConnaissance < 5) {
			memoire[nbConnaissance] = nouvelHumain;
			nbConnaissance ++;
		}
		else {
			parler("Oh ma tête ! Je ne peux plus retenir le nom d'une personne supplémentaire ");
		}
	}
	
	public String humainHasard() {
		Random rand = new Random();
		int i = rand.nextInt(type.length);
		return type[i].getNom();
	}
	
	public void ragoter() {
		for (int i = 0; i < memoire.length; i++) {
			if (memoire[i] instanceof Traitre) {
				parler("Je sais que " + memoire[i].getNom() + " est un traitre. Petit chenapan !");
			}
			else {
				parler("Je crois que " + memoire[i].getNom() + " est un " + humainHasard());
			}
		}
	}
}

package personnages;

import java.util.Random;

public class Traitre extends Samourai {
	private int niveauTraitrise = 0;

	public Traitre(String seigneur, String nom, String boisson, int argent) {
		super(seigneur, nom, boisson, argent);
	}
	
	@Override
	public void direBonjour() {
		super.direBonjour(); 
		parler("Mais je suis un traitre et mon niveau de traitrise est : " + niveauTraitrise + ". Chut !");
	}
	
	public void ranconner(Commercant commercant) {
		if (niveauTraitrise<3) {
			int argentCommercant = commercant.getArgent();
			int argentRanconner = argentCommercant*2/10;
			commercant.perdreArgent(argentRanconner);
			gagnerArgent(argentRanconner);
			niveauTraitrise++;
			parler("Si tu veux ma protection contre les Yakuzas, il va falloir payer ! Donne moi " + argentRanconner + " sous ou gare a toi !");
			commercant.parler("Tout de suite grand " + getNom() + ".");
		}
		else {
			parler("Mince je ne peux plus ranconner personne sinon un samourai risque de me demasquer !");
		}
	}
	
	public void faireLeGentil() {
		if (nbConnaissance < 1) {
			parler ("Je ne peux faire ami ami avec personne car je ne connais personne ! Snif");
		}
		else {
			Random rand = new Random();
			int pif = rand.nextInt(nbConnaissance);
			int don = getArgent()*1/20;
			String nomAmi = memoire[pif].getNom();
			parler("Il faut absolument remonter ma cote de confiance. Je vais faire ami ami avec " + nomAmi + ".");
			parler("- Bonjour l'ami ! Je voudrais vous aider en vous donnant "+  don + " sous.");
			memoire[pif].gagnerArgent(don);
			perdreArgent(don);
			String nom = getNom();
			memoire[pif].parler("Merci " + nom + ". Vous �tes quelqu'un de bien.");
			if (niveauTraitrise > 1) {
				niveauTraitrise--;
			}
		}
	}

}

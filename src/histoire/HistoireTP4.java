package histoire;
import personnages.Humain;
import personnages.Ronin;
import personnages.Commercant;
import personnages.Yakuza;

public class HistoireTP4 {

	public static void main(String[] args) {
		Humain prof = new Humain("Prof", "Kombucha", 54 );
		prof.direBonjour();
		prof.acheter("une boisson", 12);
		prof.boire();
		prof.acheter("un jeu", 2);
		prof.acheter("un kimono", 50);
		
		Commercant marco = new Commercant("Marco", 20);
		marco.direBonjour();
		marco.seFaireExtorquer();
		marco.recevoir(15);
		marco.boire();
		
		Commercant marco2 = new Commercant("Marco Le Second", 15);
		Yakuza yaku = new Yakuza("Yaku Le Noir", "du Wisky", 30, "Clan de la Mort" );
		yaku.direBonjour();
		yaku.extorquer(marco2);
		
		Ronin roro = new Ronin("Roro", "shoshu", 60);
		roro.direBonjour();
		roro.donner(marco);
	}

}

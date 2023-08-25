package puissance4;

import java.util.Scanner;

public class ProPrincipal{
	public static void main(String[] args) {
		
		int lar;
		int hau;
		int nbPAA;
		int colonne ;

		Scanner lectureClavier = new Scanner(System.in);
		
		do {
			System.out.println("Saisir le largeur de grille !!!");
			lar = lectureClavier.nextInt();
		} while(lar < 2);
		
		do {
			System.out.println("Saisir le hauteur de grille !!!");
			hau = lectureClavier.nextInt();
		} while(hau < 2);
		
		do {
			System.out.println("Saisir le nombre de pion à aligner !!!");
			nbPAA = lectureClavier.nextInt();
		} while(nbPAA < 2);
		
		Partie une_partie = new Partie(lar, hau,nbPAA, 1);
		System.out.println(une_partie.afficher());
		while (une_partie.partieFinie() == false) {
			System.out.println("Joueur"+ une_partie.getJoueur()+" , saisir numéro de colonne !!!");
			colonne = lectureClavier.nextInt();
			une_partie.jouer(colonne);
			System.out.println(une_partie.afficher());
			
		}
		if (une_partie.gagne() == true && une_partie.getJoueur() == 2)	{
			System.out.println("Bravo joueur "+ (une_partie.getJoueur()-1));
		}
		else {
			if (une_partie.gagne() == true && une_partie.getJoueur() == 1) {
				System.out.println("Bravo joueur "+ (1 + une_partie.getJoueur()));
			}
			else {
				System.out.println("La grille est pleine. Personne n'a gagné !!!! ");
			}
		}
		lectureClavier.close();
	}
	
}

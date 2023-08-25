package puissance4;

import java.util.HashMap;

public class Grille {
	private int largeur = 7;
	private int hauteur = 6;
	private HashMap<Coordonnees, Case> cases;
	
	public Grille() {
		cases = new HashMap<Coordonnees, Case>();
		for (int i = 0; i < largeur; i++) {
			for (int j = 0; j < hauteur; j++) {
				Coordonnees coord = new Coordonnees() ;
				coord.setI(i);
				coord.setJ(j);
				Case caseVide = new CaseVide();
				cases.put(coord, caseVide);
			}
		}
	}
	
	public Grille(int l, int h) {
		hauteur = h;
		largeur = l;
		cases = new HashMap<Coordonnees, Case>();
		

		for (int i = 0; i < l; i++) {
			for (int j = 0; j < h; j++) {
				Coordonnees coord = new Coordonnees() ;
				coord.setI(i);
				coord.setJ(j);
				CaseVide caseVide = new CaseVide();
				cases.put(coord, caseVide);
			}
		}
	}
	// Il reste à décorer la grille
	public String afficher() {
		Coordonnees coord = new Coordonnees() ;
		String affichage = "" ;
		
		affichage = affichage + "    " ;
		for (int i = 0 ; i<largeur ; i++) {
			affichage = affichage + i + "--" ;
		}
		affichage = affichage + "-\n" ;
		
		
		for (int j = 0; j < hauteur; j++) {
			affichage = affichage + j + "|";
			for (int i = 0; i < largeur; i++) {
				coord.setI(i);
				coord.setJ(j);
				if (cases.get(coord) instanceof CaseVide) {
					affichage = affichage + "   " ;
				}
				else {
					if (cases.get(coord) instanceof CaseJaune) {
						affichage = affichage + " x " ;
					}
					else {
						if (cases.get(coord) instanceof CaseRouge) 
						affichage = affichage + " o " ;
					}
				}
			}
			affichage = affichage + "|\n" ;
		}
		return affichage;
	}
	
	public void setCase(int i, int j, Case c) {
		Coordonnees coord = new Coordonnees();
		coord.setI(i);
		coord.setJ(j);
		cases.remove(coord);
		cases.put(coord, c);
	}
	
	public Case getCase(int i, int j) {
		Coordonnees coord = new Coordonnees();
		coord.setI(i);
		coord.setJ(j);
		return cases.get(coord);
	}
	
	public boolean pleine() {
		boolean res = true;
		Coordonnees coord = new Coordonnees();
		
		for (int i = 0; i < largeur;i++) {
			for (int j = 0; j < hauteur;j++) {
				coord.setI(i);
				coord.setJ(j);
				if (cases.get(coord) instanceof CaseVide) {
					res = false ;
				}
			}
		}
		return res;
	}
}

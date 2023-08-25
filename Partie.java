package puissance4;

public class Partie{
	private int largeur = 7;
	private int hauteur = 6;
	private int nbPionsAAligner = 4;
	private Grille g;
	private int joueur = 1;
	
	public Partie() {
		g = new Grille(largeur, hauteur);
	}
	
	public Partie(int l, int h,int nPAA, int player) {
		largeur = l;
		hauteur = h;
		nbPionsAAligner = nPAA;
		joueur = player;
		g = new Grille(l,h);
	}

	public String afficher() {
		String affichage = g.afficher() ;
		return affichage;
	}

	public boolean ligneDroite(int i, int j) {
		int compteur = 1;
		
		if (g.getCase(i, j) instanceof CaseJaune) {
			for (int k = 1 ; k<nbPionsAAligner ; k++) {
				if (g.getCase(i+k, j) instanceof CaseJaune)
					compteur++ ;
			}
		}
		else {
			if (g.getCase(i, j) instanceof CaseRouge) {
				for (int k = 1 ; k<nbPionsAAligner ; k++) {
					if (g.getCase(i+k, j) instanceof CaseRouge)
						compteur++ ;
				}
			}
		}
		return compteur == nbPionsAAligner ;
	}
	
	public boolean ligneBas(int i, int j) {
		int compteur = 1;

		if (g.getCase(i, j) instanceof CaseJaune) {
			for (int k = 1 ; k<nbPionsAAligner ; k++) {
				if (g.getCase(i, j+k) instanceof CaseJaune)
					compteur++ ;
			}
		}
		else {
			if (g.getCase(i, j) instanceof CaseRouge) {
				for (int k = 1 ; k<nbPionsAAligner ; k++) {
					if (g.getCase(i, j+k) instanceof CaseRouge)
						compteur++ ;
				}
			}
		}
		return compteur == nbPionsAAligner ;
		
	}
	
	public boolean ligneBasDroite(int i, int j) {
		int compteur = 1;

		if (g.getCase(i, j) instanceof CaseJaune) {
			for (int k = 1 ; k<nbPionsAAligner ; k++) {
				if (g.getCase(i+k, j+k) instanceof CaseJaune)
					compteur++ ;
			}
		}
		else {
			if (g.getCase(i, j) instanceof CaseRouge) {
				for (int k = 1 ; k<nbPionsAAligner ; k++) {
					if (g.getCase(i+k, j+k) instanceof CaseRouge)
						compteur++ ;
				}
			}
		}
		return compteur == nbPionsAAligner ;
	}
	
	public boolean ligneBasGauche(int i, int j) {
		int compteur = 1;

		if (g.getCase(i, j) instanceof CaseJaune) {
			for (int k = 1 ; k<nbPionsAAligner ; k++) {
				if (g.getCase(i-k, j+k) instanceof CaseJaune)
					compteur++ ;
			}
		}
		else {
			if (g.getCase(i, j) instanceof CaseRouge) {
				for (int k = 1 ; k<nbPionsAAligner ; k++) {
					if (g.getCase(i-k, j+k) instanceof CaseRouge)
						compteur++ ;
				}
			}
		}
		return compteur == nbPionsAAligner ;
	}

	
	public boolean gagne() {
		boolean res = false;
		for (int i = 0; i<largeur ; i ++) {
			for (int j = 0; j<hauteur; j++) {
				if (ligneDroite(i,j) == true || ligneBas(i,j) == true || ligneBasDroite(i,j) == true || ligneBasGauche(i,j) == true) {
					res = true;
				}
			}
		}
		return res;
	}
	
	public boolean partieFinie() {
		boolean res = false;
		if (g.pleine() == true || gagne()== true) {
			res = true;
		}
		return res;
	}
	
	public boolean coupPossible(int colonne) {
		boolean res = false;
		
		if (g.getCase(colonne, 0) instanceof CaseVide) {
			res = true;
		}
		return res;
	}
	
	public void jouer(int colonne) {
		if (coupPossible(colonne)) {
			CaseJaune cj = new CaseJaune() ;
			CaseRouge cr = new CaseRouge();
			
			if (joueur==1) {
				int j = 0 ;
				while(g.getCase(colonne, j) instanceof CaseVide) {
					j++ ;// trouver à quelle ligne il faut mettre le pion du joueur
				}
				g.setCase(colonne, j-1, cj);
				joueur = 2 ;
			}
			else {
				int j = 0 ;
				while(g.getCase(colonne, j) instanceof CaseVide) {
					j++ ;// trouver à quelle ligne il faut mettre le pion du joueur
				}
				g.setCase(colonne, j-1, cr);
				joueur = 1 ;
			}
		}
	}
	
	public int getJoueur() {
		return joueur;
	}
}

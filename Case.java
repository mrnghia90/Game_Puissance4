package puissance4;

public abstract class Case {
	private Coordonnees p;
	
	// Constructeurs
	public Case() {
		
	}
	
	public Case(int cor_i, int cor_j) {
		p.setI(cor_i);
		p.setJ(cor_j);
	}
	
	// Accesseurs
	public int getI() {
		return p.getI();
	}
	
	public int getJ() {
		return p.getJ();
	}
	
}

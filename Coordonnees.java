package puissance4;

public  class Coordonnees {
	private int i = 0;
	private int j = 0;
	
	// 2 constructeurs
	public Coordonnees () {
		
	}
	
	public Coordonnees (int cor_i, int cor_j) {
		i = cor_i;
		j = cor_j;
	}
	
	// Mutateurs et accesseurs
	public int getJ() {
		return j;
	}

	public int getI() {
		return i;
	}
	
	public void setJ(int j) {
		this.j = j;
	}

	public void setI(int i) {
		this.i = i;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false ;
		else
		{
			if (o instanceof Coordonnees) {
				return (i == ((Coordonnees)o).i) && (j == ((Coordonnees)o).j);
			}
			else {
				return false;
			}
				
		}
	}
	
	
	@Override
	public int hashCode() {
		return i + j;
	}	
	
}

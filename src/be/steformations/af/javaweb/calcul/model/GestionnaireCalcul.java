package be.steformations.af.javaweb.calcul.model;

public class GestionnaireCalcul {
	
	private java.util.Random random = new java.util.Random();
	private final int niveauDeDifficulte;
	
	public GestionnaireCalcul(int niveauDeDifficulte) {
		super();
		this.niveauDeDifficulte = niveauDeDifficulte;
	}
	public Calcul genererCalcul() {
		Calcul c = new Calcul();
		
		int i = this.random.nextInt(50) + 1;
		int j = this.random.nextInt(50) + 1;
		int o = this.random.nextInt(4) +1;
		
		switch (o) {
		case 1:
			c.setOperation(Operation.ADDITION);
			c.setOperandeGauche(i);
			c.setOperandeDroite(j);
			c.setResultat(i+j);
			break;
			
		case 2:
			c.setOperation(Operation.SOUSTRACTION);
			if(j > i){
				int k = i ;
				i = j;
				j = k ;
				
			}
			
			c.setOperandeGauche(i);
			c.setOperandeDroite(j);
			c.setResultat(i-j);
			break;
		case 3:
		c.setOperation(Operation.MULTIPLICATION);
		c.setOperandeGauche(i);
		c.setOperandeDroite(j);
		c.setResultat(i*j);
	break;
		default:
			c.setOperation(Operation.DIVISION);
			c.setOperandeGauche(i*j);
			c.setOperandeDroite(i);
			c.setResultat(j);
			break;
		}
		return c;
		
	}
	
	public void verifierSolution(Calcul calcul, int proposition) {
		calcul.setResolu(calcul.getResultat() == proposition);
	}
}

package be.steformations.af.javaweb.calcul.model;

public class Calcul implements java.io.Serializable {

	private Operation operation;
	private int operandeGauche;
	private int operandeDroite;
	private int resultat;
	
	private boolean resolu;

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	public int getOperandeGauche() {
		return operandeGauche;
	}

	public void setOperandeGauche(int operandeGauche) {
		this.operandeGauche = operandeGauche;
	}

	public int getOperandeDroite() {
		return operandeDroite;
	}

	public void setOperandeDroite(int operandeDroite) {
		this.operandeDroite = operandeDroite;
	}

	public int getResultat() {
		return resultat;
	}

	public void setResultat(int resultat) {
		this.resultat = resultat;
	}

	public boolean isResolu() {
		return resolu;
	}

	public void setResolu(boolean resolu) {
		this.resolu = resolu;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + operandeDroite;
		result = prime * result + operandeGauche;
		result = prime * result + ((operation == null) ? 0 : operation.hashCode());
		result = prime * result + (resolu ? 1231 : 1237);
		result = prime * result + resultat;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Calcul other = (Calcul) obj;
		if (operandeDroite != other.operandeDroite)
			return false;
		if (operandeGauche != other.operandeGauche)
			return false;
		if (operation != other.operation)
			return false;
		if (resolu != other.resolu)
			return false;
		if (resultat != other.resultat)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Calcul [operation=" + operation + ", operandeGauche=" + operandeGauche + ", operandeDroite="
				+ operandeDroite + ", resultat=" + resultat + ", resolu=" + resolu + "]";
	}
	
	
}

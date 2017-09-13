package be.steformations.af.javaweb.calcul.model;

public enum Operation {

	ADDITION("+"),SOUSTRACTION("-"),MULTIPLICATION("*"),DIVISION("/");
	
	private String signe;

	private Operation(String signe) {
		this.signe = signe;
	}
	
	public String getSigne(){
		return signe;
	}
}

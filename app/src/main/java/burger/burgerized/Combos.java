package burger.burgerized;//product

public class Combos implements comboParts{

	private String comboBurger;
	private String combosides1;
	private String combosides2;
	private String combosides3;
	
	public void setSelectedBurger(String selectedBurger) {
		comboBurger = selectedBurger;
	}
	
	public String getSelectedBurger(){ 
		return comboBurger; 
	}

	public void setSides1(String sides1){
		combosides1 = sides1;
	}
	
	public String getSides1(){ 
		return combosides1; 
	}

	public void setSides2(String sides2) {
		
		combosides2 = sides2;
		
	}
	
	public String getSides2(){ 
		return combosides2; 
	}

	public void setSides3(String sides3) {
		combosides3 = sides3;
		
	}
	
	public String getSides3(){ 
		return combosides3; 
	}	

}
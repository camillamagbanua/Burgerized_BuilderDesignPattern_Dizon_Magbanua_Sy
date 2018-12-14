package burger.burgerized;//director

public class ComboAssembler {
	
	private ComboBuilder comboBuilder;
	
	
	public ComboAssembler(ComboBuilder comboBuilder){
		
		this.comboBuilder = comboBuilder;
		
	}
	
	
	public Combos getCombo(){
		
		return this.comboBuilder.getCombo();
		
	}
	
	// Execute the methods specific to the RobotBuilder 
	// that implements RobotBuilder (OldRobotBuilder)
	
	public void makeCombo() {
		
		this.comboBuilder.buildSelectedBurger();
		this.comboBuilder.buildSides1();
		this.comboBuilder.buildSides2();
		this.comboBuilder.buildSides3();
		
	}
	
}
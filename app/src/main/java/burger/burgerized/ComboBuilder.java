package burger.burgerized;//builder

public interface ComboBuilder {
	
	public void buildSelectedBurger();
	
	public void buildSides1();
	
	public void buildSides2();
	
	public void buildSides3();
	
	public Combos getCombo();
	
}
package calculate;

enum CalculatorVariable {
	
	MEMORY("mr"), RESULT("res");
	
	private String name;
	private double value;
	
	public double getValue() {
		return value;
	}


	public void setValue(double value) {
		this.value = value;
	}

	CalculatorVariable(String name) {
		this.name = name;
		this.value = 0;
	}
	
	static CalculatorVariable findByName(String variableName) {
		for (CalculatorVariable variable : values()) {
			if (variable.name.compareToIgnoreCase(variableName)== 0) {
				return variable;
			}
		}
		return null;
	}
}
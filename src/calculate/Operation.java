package calculate;

public enum Operation {
	PLUS("+", 2) {
		double calculate(double... parameters) {
			return parameters[0] + parameters[1];
		}
	},
	DIVIDE("/", 2) {
		double calculate(double... parameters) throws CalculatorException {
			double a = parameters[0], b = parameters[1];
			if (b == 0 && a == 0) {
				throw new CalculatorException("ноль на ноль делить НЕЛЬЗЯ!!");
			}
			return a / b;
		}
	},
	LN("ln", 1) {
		double calculate(double... parameters) throws CalculatorException {
			double a = parameters[0];
			if (a < 0) {
				throw new CalculatorException("логарифм из отрицательного числа извлекать НЕЛЬЗЯ!!");
			}
			return Math.log(a);
		}
	},
	POWER("**", 1) {
		double calculate(double... parameters) {
			return parameters[0] * parameters[0];
		}
	},
	LOG("log", 2) {
		double calculate(double... parameters) throws CalculatorException {
			double a = parameters[0], b = parameters[1];
			if (a <= 0) {
				throw new CalculatorException("Основание логарифма должно быть больше нуля!!!");
			}
			return LN.calculate(a) / LN.calculate(b);
		}
	},
	MULTIPLY("*", 2) {
		double calculate(double... parameters) throws CalculatorException {
			double a = parameters[0], b = parameters[1];
			return a * b;
		}
	},
	MINUS("-", 2) {
		double calculate(double... parameters) throws CalculatorException {
			return parameters[0] - parameters[1];
		}
	},
	SQRT("sqrt", 1) {
		double calculate(double... parameters) throws CalculatorException {
			double a = parameters[0];
			if (a < 0) {
				throw new CalculatorException("Не может быть отрицательный корень!!!");
			}
			return Math.sqrt(a);
		}
	},
	CQRT("cqrt", 1) {
		double calculate(double... parameters) {
			return Math.cbrt(parameters[0]);
		}
	},
	INV("inv", 1) {
		double calculate(double... parameters) {
			return 1 / parameters[0];
		}
	},
	MR ("mr", 0){
		double calculate (double...parameters) {
			return CalculatorVariable.MEMORY.getValue();
		}
	},
	RES ("res", 0){
		double calculate (double...parameters) {
			return CalculatorVariable.RESULT.getValue();
		}
	},
	MS ("ms",1) {
		double calculate (double...parameters) throws CalculatorException {
			CalculatorVariable.MEMORY.setValue(parameters[0]);		
			return MR.calculate();
		}
	},
	MC ("mc",0){
		double calculate (double...parameters) throws CalculatorException {
			return MS.calculate(0);
		}
	};
	public static Operation findBySign(String operationSign) {
		for (Operation operation : values()) {
			if (operation.operationSign.compareToIgnoreCase(operationSign) == 0) {
				return operation;
			}
		}
		return null;
	}

	abstract double calculate(double... parametrs) throws CalculatorException;

	String operationSign;
	int operandsCount;

	private Operation(String operationSign, int operandsCount) {
		this.operationSign = operationSign;
		this.operandsCount = operandsCount;

	}
}
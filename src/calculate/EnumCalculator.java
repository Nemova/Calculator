package calculate;

import java.util.Scanner;

class EnumCalculator {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (true) {
			try {
				String operationSign = in.next();
				Operation operation = Operation.findBySign(operationSign);
				if (operation == null) {
					throw new CalculatorException("Неккоректная операция!");
				}
				String[] operands = new String[operation.operandsCount];
				for (int i = 0; i < operands.length; ++i) {
					operands[i] = in.next();

				}
				double[] parameters = new double[operation.operandsCount];
				for (int i = 0; i < parameters.length; ++i) {
					String operand = operands[i];
					CalculatorVariable variable = CalculatorVariable.findByName(operand);

					if (variable != null) {
						parameters[i] = variable.getValue();
					} else {
						try {
							parameters[i] = Double.parseDouble(operand);
						} catch (NumberFormatException e) {
							throw new CalculatorException("incorrect операнд: " + operand + " !");
						}
					}
				}

				double res = operation.calculate(parameters);
				CalculatorVariable.RESULT.setValue(res);
				System.out.println(res);
			} catch (CalculatorException e) {
				System.out.println("Накосячил!!! " + e.getLocalizedMessage());
			}
		}
	}
}
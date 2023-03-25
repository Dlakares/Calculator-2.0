package module;

import java.util.Stack;

import static util.InputUtil.getMathExpression;

public class Calculator {
    public static double evaluate() {
        Stack<Double> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        String expression = getMathExpression();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c)) {
                StringBuilder operandBuilder = new StringBuilder();
                operandBuilder.append(c);
                while (i + 1 < expression.length() && Character.isDigit(expression.charAt(i + 1))) {
                    operandBuilder.append(expression.charAt(i + 1));
                    i++;
                }
                double operand = Double.parseDouble(operandBuilder.toString());
                operandStack.push(operand);
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!operatorStack.isEmpty() && getOperatorPriority(c) <= getOperatorPriority(operatorStack.peek())) {
                    double rightOperand = operandStack.pop();
                    double leftOperand = operandStack.pop();
                    char operator = operatorStack.pop();
                    double result = applyOperator(leftOperand, rightOperand, operator);
                    operandStack.push(result);
                }
                operatorStack.push(c);
            }
        }

        while (!operatorStack.isEmpty()) {
            double rightOperand = operandStack.pop();
            double leftOperand = operandStack.pop();
            char operator = operatorStack.pop();
            double result = applyOperator(leftOperand, rightOperand, operator);
            operandStack.push(result);
        }

        return operandStack.pop();
    }

    private static int getOperatorPriority(char operator) {
        return switch (operator) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> throw new IllegalArgumentException("Некорректный оператор");
        };
    }

    private static double applyOperator(double leftNumber, double rightNumber, char operator) {
        return switch (operator) {
            case '+' -> leftNumber + rightNumber;
            case '-' -> leftNumber - rightNumber;
            case '*' -> leftNumber * rightNumber;
            case '/' -> leftNumber / rightNumber;
            default -> throw new IllegalArgumentException("Некорректный оператор");
        };
    }
}

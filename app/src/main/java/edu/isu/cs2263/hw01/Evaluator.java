package edu.isu.cs2263.hw01;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Queues;

import java.util.List;
import java.util.Queue;

/**
 * Evaluates a given mathematical expression. Expression must be of the form of numbers separated by operators with spaces between the operators and numbers.
 * Additionally, there should always be one more number than operator.
 *
 * @author Isaac D Griffith
 * @version 1.1.0
 */
public class Evaluator {

    private static final List<String> OPS = ImmutableList.of("+", "-", "/", "*");

    private Queue<String> ops;
    private List<String> numbers;

    /**
     * Evaluates the given mathematical expression string, and returns the value as a string
     * @param expr Expression to be evaluated
     * @return Result of the expression
     * @throws ImproperlyFormattedExpressionException thrown if the expression is improperly formatted.
     */
    public String evaluate(String expr) throws ImproperlyFormattedExpressionException {
        extract(expr);
        process();
        return numbers.get(0);
    }

    /**
     * Extracts numbers and operators from the expression String
     *
     * @param expr Expression string
     * @throws ImproperlyFormattedExpressionException thrown if the expression contains too many operators or too many numbers
     */
    public void extract(String expr) throws ImproperlyFormattedExpressionException {
        String[] comps = expr.split("\\s");
        numbers = Lists.newArrayList();
        ops = Queues.newArrayDeque();

        if (ops.size() > numbers.size())
            throw new ImproperlyFormattedExpressionException("Too many operators for the amount of numbers!");
        if (ops.size() < numbers.size() - 1)
            throw new ImproperlyFormattedExpressionException("Too few operators for the number of numbers!");

        for (String comp : comps) {
            if (OPS.contains(comp))
                ops.offer(comp);
            else
                numbers.add(comp);
        }
    }

    /**
     * Processes the expression and derives the result.
     *
     * @throws ImproperlyFormattedExpressionException thrown if an unknown operator is used or numbers are not separated from operatos by a space.
     */
    public void process() throws ImproperlyFormattedExpressionException {
        try {
            while (!ops.isEmpty()) {
                String operator = ops.poll();
                String left = numbers.get(0);
                String right = numbers.get(1);
                String result = "";
                switch (operator) {
                    case "+":
                        result = String.valueOf(Double.parseDouble(left) + Double.parseDouble(right));
                        break;
                    case "-":
                        result = String.valueOf(Double.parseDouble(left) - Double.parseDouble(right));
                        break;
                    case "/":
                        result = String.valueOf(Double.parseDouble(left) / Double.parseDouble(right));
                        break;
                    case "*":
                        result = String.valueOf(Double.parseDouble(left) * Double.parseDouble(right));
                        break;
                    default:
                        throw new ImproperlyFormattedExpressionException("Only the following operators are allowed: +,-,/,*");
                }
                numbers.remove(1);
                numbers.set(0, result);
            }
        } catch (NumberFormatException ex) {
            throw new ImproperlyFormattedExpressionException("Only numbers and operators are allowed, and there needs to be a space between the numbers and operators.");
        }
    }
}

package StacksAndQueues;

import javafx.util.Pair;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import static java.lang.System.out;

interface token {
    boolean isOperator();
}

class tokenOperator implements token {
    char mValue;

    public tokenOperator() {
        mValue = 0;
    }

    public tokenOperator(char d) {
        mValue = d;
    }

    public void setValue(char d) {
        mValue = d;
    }

    char getValue() {
        return mValue;
    }

    public boolean isOperator() {
        return true;
    }
}

class tokenOperand implements token {
    double mValue;

    public tokenOperand(double d) {
        mValue = d;
    }

    double getValue() {
        return mValue;
    }

    public boolean isOperator() {
        return false;
    }
}

class ExpressionEvaluator {
    static boolean isOperator(char temp) {
        return temp == '+' || temp == '-' || temp == '*' || temp == '/';
    }

    // Returns true if op1 has higher/equal precedence compared to op2
    static boolean preced(char op1, char op2) {
        if (op1 == '*' || op1 == '/') {
            return true;
        }

        if (op1 == '+' || op1 == '-') {
            if (op2 == '+' || op2 == '-') {
                return true;
            }
        }

        return false;
    }

    static boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    public static Pair<Double, Integer> strToDouble(String s, int i) {
        int len = s.length();
        if (i >= len) {
            return null;
        }

        StringBuilder temp = new StringBuilder();
        while (i < len && (s.charAt(i) == ' ' || s.charAt(i) == '\t')) {
            ++i;
        }

        if (i >= len) {
            return null;
        }

        if (s.charAt(i) == '-') {
            temp.append('-');
            ++i;
        }

        for (; i < len; ++i) {
            char ch = s.charAt(i);
            if (ch != '.' && !isDigit(ch)) {
                break;
            }

            temp.append(ch);
        }

        return new Pair<>(Double.parseDouble(temp.toString()), i);

    }

    static List<token> convertToPostfix(String expr) {
        List<token> postFix = new ArrayList<>();

        Stack<Character> operators = new Stack<>();
        int len = expr.length();
        for (int i = 0; i < len; ) {
            char ch = expr.charAt(i);
            if (ch == ' ' || ch == '\t') {
                ++i;
                continue;
            }

            if (isOperator(ch)) {
                while (!operators.empty() && preced(operators.peek(), ch)) {
                    postFix.add(new tokenOperator(operators.peek()));
                    operators.pop();
                }
                operators.push(ch);
                ++i;
            } else {
                Pair<Double, Integer> p = strToDouble(expr, i);
                i = p.getValue();
                postFix.add(new tokenOperand(p.getKey()));
            }
        }

        while (!operators.empty()) {
            postFix.add(new tokenOperator(operators.peek()));
            operators.pop();
        }

        return postFix;
    }

    public static double evaluate(List<token> postFix) {
        Stack<Double> operands = new Stack<>();
        for (token x : postFix) {
            if (x.isOperator()) {
                double val2 = operands.peek();
                operands.pop();
                double val1 = operands.peek();
                operands.pop();

                char op = ((tokenOperator) x).getValue();
                if (op == '+') {
                    operands.push(val1 + val2);
                } else if (op == '-') {
                    operands.push(val1 - val2);
                } else if (op == '*') {
                    operands.push(val1 * val2);
                } else if (op == '/') {
                    operands.push(val1 / val2);
                }

            } else {
                double val = ((tokenOperand) x).getValue();
                operands.push(val);
            }
        }

        if (operands.empty()) {
            return 0;
        }

        return operands.peek();
    }

    static double evaluate(String expr) {
        return evaluate(convertToPostfix(expr));
    }
}

class ExpressionEvaluation {
    static String generateExpression(int nOperators) {
        char[] ops = new char[]{'+', '/', '*', '-'};
        StringBuilder expression = new StringBuilder();

        Random rnd = new Random();
        double d = rnd.nextInt(100);

        expression.append(d);
        for (int i = 0; i < nOperators; ++i) {
            char c = ops[rnd.nextInt(4)];
            d = rnd.nextInt(100);
            if (c == '/' && d == 0) d = d + 1;
            expression.append(c);
            expression.append(d);
        }

        return expression.toString();
    }

    public static void test(String expression) {
        ScriptEngineManager engineManager = new ScriptEngineManager();
        ScriptEngine engine = engineManager.getEngineByName("JavaScript");
        double resultLib = 0;

        try {
            resultLib = Double.parseDouble(engine.eval(expression).toString());
        } catch (Exception ex) {
            out.println("****" + ex.toString());
        }

        double result = ExpressionEvaluator.evaluate(expression);
        out.println("Expression = " + expression + ", Result = " + result);

        if (Math.abs(result - resultLib) > 0.0000000000001) {
            out.println("Reverse Polish implementation failed for " + expression);
            out.println("Expected = " + resultLib);
            out.println("Actual = " + result);
        }
    }

    public static void main(String[] args) {
        test("3");
        test("          4   ");
        test("  3    +  2.45    /8");
        test(generateExpression(6));
        out.println("Completed!");
    }
}
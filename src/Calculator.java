import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Calculator {

    private int firstOperand;
    private int secondOperand;
    private char operation;
    private int result;
    String expression;

    public void start() {
        try {
            checkExpression();
        } catch (Exception e) {
            e.printStackTrace();
        }
        calculate(firstOperand, secondOperand, operation);
        System.out.println(result);
    }

    public void calculate(int firstOperand, int secondOperand, char operation) {

        switch (operation) {
            case '+':
                result = firstOperand + secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '*':
                result = firstOperand * secondOperand;
                break;
            case '/':
                result = firstOperand / secondOperand;
                break;
        }
    }


    public void checkExpression() throws Exception {
// считали введенную строку м присволили ее значение expression
        Scanner scanner = new Scanner(System.in);
        expression = scanner.nextLine();
        expression = expression.replace(" ", "");
        String[] s = null;


        if (expression.contains("+") && !(expression.contains("-") || expression.contains("*") || expression.contains("/"))) {
//            подсчитали количество символа "+"
            int count = 0;
            for (int i = 0; i < expression.length(); i++) {
                if (expression.substring(i).equals("+")) {
                    count++;
                }
            }
//            и если количество символа "+" равно 1
            if (count == 1) {
                //        создали массив на основе введеного выражения разделив его по знаку операции
                s = expression.split("\\+");
                //        узнали индекс в выражении знака операции
                int indexOfOperation = expression.indexOf("+");
                //        вывели в консоль номер или индекс знака операции
                System.out.println(indexOfOperation);
                //        присвоили и вывели в консоль знак операции
                operation = expression.charAt(indexOfOperation);
                System.out.println(operation);
                //        вывели в консоль массив строк с нашими операндами
                System.out.println(Arrays.toString(s));
            } else
                throw new Exception(" формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");

        } else if (expression.contains("-") && !(expression.contains("+") || expression.contains("*") || expression.contains("/"))) {
            //            подсчитали количество символа "-"
            int count = 0;
            for (int i = 0; i < expression.length(); i++) {
                if (expression.substring(i).equals("-")) {
                    count++;
                }
            }
//            и если количество символа "-" равно 1
            if (count == 1) {
                //        создали массив на основе введеного выражения разделив его по знаку операции
                s = expression.split("-");
                //        узнали индекс в выражении знака операции
                int indexOfOperation = expression.indexOf("-");
                //        вывели в консоль номер или индекс знака операции
                System.out.println(indexOfOperation);
                //        присвоили и вывели в консоль знак операции
                operation = expression.charAt(indexOfOperation);
                System.out.println(operation);
                //        вывеоли в консоль массив строк с нашими операндами
                System.out.println(Arrays.toString(s));
            } else
                throw new Exception(" формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");

        } else if (expression.contains("*") && !(expression.contains("-") || expression.contains("+") || expression.contains("/"))) {
            //            подсчитали количество символа "*"
            int count = 0;
            for (int i = 0; i < expression.length(); i++) {
                if (expression.substring(i).equals("*")) {
                    count++;
                }
            }
//            и если количество символа "*" равно 1
            if (count == 1) {
                //        создали массив на основе введеного выражения разделив его по знаку операции
                s = expression.split("\\*");
                //        узнали индекс в выражении знака операции
                int indexOfOperation = expression.indexOf("*");
                //        вывели в консоль номер или индекс знака операции
                System.out.println(indexOfOperation);
                //        присвоили и вывели в консоль знак операции
                operation = expression.charAt(indexOfOperation);
                System.out.println(operation);
                //        вывеоли в консоль массив строк с нашими операндами
                System.out.println(Arrays.toString(s));
            } else
                throw new Exception(" формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");


        } else if (expression.contains("/") && !(expression.contains("-") || expression.contains("+") || expression.contains("*"))) {
            //            подсчитали количество символа "/"
            int count = 0;
            for (int i = 0; i < expression.length(); i++) {
                if (expression.substring(i).equals("*")) {
                    count++;
                }
            }
//            и если количество символа "/" равно 1
            if (count == 1) {
                //        создали массив на основе введеного выражения разделив его по знаку операции
                s = expression.split("/");
                //        узнали индекс в выражении знака операции
                int indexOfOperation = expression.indexOf("/");
                //        вывели в консоль номер или индекс знака операции
                System.out.println(indexOfOperation);
                //        присвоили и вывели в консоль знак операции
                operation = expression.charAt(indexOfOperation);
                System.out.println(operation);
                //        вывеоли в консоль массив строк с нашими операндами
                System.out.println(Arrays.toString(s));
            }else throw new Exception(" формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }

        firstOperand = Integer.parseInt(s[0]);
        secondOperand = Integer.parseInt(s[1]);

    }
}

import java.util.Arrays;
import java.util.Scanner;

public class Calculator {

    String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
            "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX",
            "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX",
            "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX",
            "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX",
            "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX",
            "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX",
            "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX",
            "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX",
            "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

    private int firstOperand;
    private int secondOperand;
    private int result;

    private char operation;
    private String[] arrayOfOperands = null;

    void start() {
        try {
            operationFormat();
        } catch (Exception e) {
            e.printStackTrace();
        }
        convertToOperands(arrayOfOperands);
        calculate(firstOperand, secondOperand, operation);
        System.out.println(result);
    }

    private void calculate(int firstOperand, int secondOperand, char operation) {

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


    private void operationFormat() throws Exception {
// считали введенную строку м присволили ее значение expression
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        expression = expression.replace(" ", "");

        if (expression.contains("+") && !(expression.contains("-") || expression.contains("*") || expression.contains("/"))) {
//            подсчитали количество символа "+"
            int count = 0;
            for (int i = 0; i < expression.length(); i++) {
                if (Character.toString(expression.charAt(i)).equals("+")) {
                    count++;
                }
            }

            //            и если количество символа "+" равно 1
            if (count == 1) {
                //        создали массив на основе введеного выражения разделив его по знаку операции
                arrayOfOperands = expression.split("\\+");
                //        узнали индекс в выражении знака операции
                int indexOfOperation = expression.indexOf("+");
                //        присвоили знак операции
                operation = expression.charAt(indexOfOperation);
            } else
                throw new Exception(" формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");


        } else if (expression.contains("-") && !(expression.contains("+") || expression.contains("*") || expression.contains("/"))) {
            //            подсчитали количество символа "-"
            int count = 0;
            for (int i = 0; i < expression.length(); i++) {
                if (Character.toString(expression.charAt(i)).equals("-")) {
                    count++;
                }
            }
//            и если количество символа "-" равно 1
            if (count == 1) {
                //        создали массив на основе введеного выражения разделив его по знаку операции
                arrayOfOperands = expression.split("-");
                //        узнали индекс в выражении знака операции
                int indexOfOperation = expression.indexOf("-");
                //        присвоили знак операции
                operation = expression.charAt(indexOfOperation);
            } else
                throw new Exception(" формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");

        } else if (expression.contains("*") && !(expression.contains("-") || expression.contains("+") || expression.contains("/"))) {
            //            подсчитали количество символа "*"
            int count = 0;
            for (int i = 0; i < expression.length(); i++) {

                if (Character.toString(expression.charAt(i)).equals("*")) {
                    count++;
                }
            }
//            и если количество символа "*" равно 1
            if (count == 1) {
                //        создали массив на основе введеного выражения разделив его по знаку операции
                arrayOfOperands = expression.split("\\*");
                //        узнали индекс в выражении знака операции
                int indexOfOperation = expression.indexOf("*");
                //        присвоили знак операции
                operation = expression.charAt(indexOfOperation);
            } else
                throw new Exception(" формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");


        } else if (expression.contains("/") && !(expression.contains("-") || expression.contains("+") || expression.contains("*"))) {
            //            подсчитали количество символа "/"
            int count = 0;
            for (int i = 0; i < expression.length(); i++) {
                if (Character.toString(expression.charAt(i)).equals("*")) {
                    count++;
                }
            }
//            и если количество символа "/" равно 1
            if (count == 1) {
                //        создали массив на основе введеного выражения разделив его по знаку операции
                arrayOfOperands = expression.split("/");
                //        узнали индекс в выражении знака операции
                int indexOfOperation = expression.indexOf("/");
                //        присвоили знак операции
                operation = expression.charAt(indexOfOperation);
            } else
                throw new Exception(" формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }

//        firstOperand = Integer.parseInt(arrayOfOperands[0]);
//        secondOperand = Integer.parseInt(arrayOfOperands[1]);

    }

    private void convertToOperands(String[] array) {

        boolean romanFirst = false;
        boolean romanSecond = false;

        String first = array[0];
        String second = array[1];


        for (int i = 0; i < roman.length; i++) {
            if (first.equals(roman[i])) {
                romanFirst = true;
                firstOperand = i + 1;
            }
            if (second.equals(roman[i])) {
                romanSecond = true;
                secondOperand = i + 1;
            }
        }
        if (romanFirst == false && romanSecond == false) {
            try {
                firstOperand = Integer.parseInt(first);
                secondOperand = Integer.parseInt(second);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        } else if (romanFirst == false || romanSecond == false) {
            try {
                throw new Exception("Один из операндов не соответствует римским цифрам");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}

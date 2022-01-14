import java.util.Arrays;
import java.util.Scanner;

class Calculator {
    //    Это массив римских чисел до ста (100)
    private String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
            "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX",
            "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX",
            "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX",
            "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX",
            "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX",
            "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX",
            "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX",
            "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX",
            "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
    // первый операнд
    private int firstOperand;
    //    второй операнд
    private int secondOperand;
    //    символ оператора
    private char operation;
    //    операнды в массиве
    private String[] arrayOfOperands = null;
    //    переменная boolean говорит операнды римские да или нет
    private boolean operandsIsRoman;


    void start() throws Exception {
        try {
            operationFormat();
        } catch (Exception e) {
            e.printStackTrace();
        }
        convertToOperands(arrayOfOperands);

        if (firstOperand <= 10 && firstOperand >= 1 && secondOperand >= 1 && secondOperand <= 10) {
            calculate(firstOperand, secondOperand, operation);
        } else {
            throw new Exception("Калькулятор принимает числа от 1 до 10");
        }
    }

    private void operationFormat() throws Exception {
// считали введенную строку м присволили ее значение expression
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
//        удалиляем все пробелы в строке
        expression = expression.replace(" ", "");
//        System.out.println(expression.matches("([IVX0-9])+([+\\-*/])([IVX0-9])+"));
//        [+\-*/]
//      проверка на правильность ввода с помощью регулярок и просвоение значения операнду
        if (expression.matches("([IVX0-9])+([+\\-*/])([IVX0-9])+")) {
            arrayOfOperands = expression.split("[+\\-*/]");
            if (expression.matches("([IVX0-9])+([+])([IVX0-9])+")) {
                operation = expression.charAt(expression.indexOf("+"));
            } else if (expression.matches("([IVX0-9])+([-])([IVX0-9])+")) {
                operation = expression.charAt(expression.indexOf("+"));
            } else if (expression.matches("([IVX0-9])+([*])([IVX0-9])+")) {
                operation = expression.charAt(expression.indexOf("*"));
            } else if (expression.matches("([IVX0-9])+([/])([IVX0-9])+")) {
                operation = expression.charAt(expression.indexOf("/"));
            }
        }else throw new Exception("строка не является математической операцией");
    }

// преобразовываем в операнды данные из строки
            private void convertToOperands (String[]array){

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
                if (romanFirst && romanSecond) {
                    operandsIsRoman = true;
                }
                if (!romanFirst && !romanSecond) {
                    try {
                        firstOperand = Integer.parseInt(first);
                        secondOperand = Integer.parseInt(second);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                } else if (!romanFirst || !romanSecond) {
                    try {
                        throw new Exception("используются одновременно разные системы счисления");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            private void calculate ( int firstOperand, int secondOperand, char operation) throws Exception {

                int result = 0;
                if (operandsIsRoman) {
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
                    if (result > 0) {
                        System.out.println(roman[result - 1]);
                    } else {
                        throw new Exception("в римской системе нет отрицательных чисел");
                    }
                } else {
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
                    System.out.println(result);
                }
            }
        }

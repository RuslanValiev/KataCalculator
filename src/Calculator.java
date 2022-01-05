import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Calculator {

    int first;
    int second;
    char operation;

    public void start(){
        checkExpression();
        System.out.println(calculate(first, second, operation));
    }

    public int calculate(int first, int second, char operation) {

        int result = 0;
        switch (operation) {
            case '+':
                result = first + second;
                break;
            case '-':
                result = first - second;
                break;
            case '*':
                result = first * second;
                break;
            case '/':
                result = first / second;
                break;
        }
        return result;
    }


    public void checkExpression() {
// считали введенную строку м присволили ее значение expr
        Scanner scanner = new Scanner(System.in);
        String expr = scanner.nextLine();
//        строку превратили в массив char-ов
        char[] arr = expr.toCharArray();
//        узнали длину массива
        int lengthArr = arr.length;
//        вывели в консоль сам массив
        System.out.println(arr);
//        вывели в консоль длину массива
        System.out.println(lengthArr);
//        создали массив на основе введеного выражения разделив его по знаку операции
        String[] s = expr.split("[\\+\\-\\*\\/]");
//        вывеоли в консоль массив строк с нашими операндами
        System.out.println(Arrays.toString(s));
//        узнали индекс в выражении знака операции
        int indexOfOperation = expr.indexOf("+");
//        вывели в консоль номер или индекс знака операции
        System.out.println(indexOfOperation);
//        присвоили и вывели в консоль знак операции
        operation = expr.charAt(indexOfOperation);
        System.out.println(operation);
//       назначили и вывели в консоль операнды
        first = Integer.parseInt(s[0]);
        second = Integer.parseInt(s[1]);
        System.out.println(first);
        System.out.println(second);

    }


}

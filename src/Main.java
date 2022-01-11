import java.util.Scanner;

public class Main {



    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        try {
            calculator.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

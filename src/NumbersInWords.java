import java.util.ArrayList;
import java.util.Scanner;

public class NumbersInWords {
    public static void main(String[] args) {
        try {
            System.out.println("Insert the number (from 1 to 99 999 999):");
            Scanner input = new Scanner(System.in);
            int inputNumber = input.nextInt();
            Logic logic = new Logic();
            System.out.println(logic.mainFunction(inputNumber));
        } catch (Exception e) {
            System.out.println("You have given the wrong input");
        }
    }
}

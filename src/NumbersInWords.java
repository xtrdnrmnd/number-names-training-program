import java.util.ArrayList;
import java.util.Scanner;

public class NumbersInWords {
    public static void main(String[] args) {
        System.out.println("Insert the number:");
        Scanner input = new Scanner(System.in);
        int inputNumber = input.nextInt();
        Logic logic = new Logic();
        System.out.println(logic.mainFunction(inputNumber));
    }
}

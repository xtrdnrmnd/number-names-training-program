import java.util.ArrayList;

public class Logic {

    ArrayList<String> resultingString = new ArrayList<>();
    ArrayList<Integer> numbersByDigit = new ArrayList<>();

    public ArrayList<String> mainFunction(int number) {
        parcer(number);
        for (int i = 0; i < numbersByDigit.size(); i++) {
            if (numbersByDigit.size() > 2) digitNumber(numbersByDigit);
            else resultingString.add(ones(numbersByDigit));
            numbersByDigit.remove(0);
        }
        return resultingString;
    }

    public void parcer(int number) {
        ArrayList<Integer> rotateString = new ArrayList<>();
        while (number / 10 > 0) {
            rotateString.add(number%10);
            number = number/10;
        }
        rotateString.add(number);
        for (int i = rotateString.size()-1; i >= 0; i--) numbersByDigit.add(rotateString.get(i));
    }

    // from one till nine
    public String ones(ArrayList<Integer> value) {
        int num = value.get(0);
        String res = "";
        if (num > 4) {
            if (num > 7) {
                if (num == 9) res = "nine";
                else res = "eight";
            }
            else if (num < 7) {
                if (num == 6) res = "six";
                else res = "five";
            }
            else res = "seven";
        }
        else {
            if (num < 3) {
                if (num == 2) res = "two";
                if (num == 1) res = "one";
            }
            else {
                if (num == 3) res = "three";
                else res = "four";
            }
        }
        return res;
    }

    // fifteen, sixteen, twenty, fourty etc.
    public String tens(ArrayList<Integer> tens) {
        return "tens";
    }

    // hundred, thousand, million etc.
    public String digitNumber(ArrayList<Integer> number) {
        if (number.size() == 3) return " hundred";
        if (number.size() == 4) return " thousand";
        else return "";
    }
}

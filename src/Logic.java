import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Logic {
    static Map<Integer,String> tensMap = new HashMap<>(6);
    static Map<Integer,String> doublePlusDigitMap = new HashMap<>();

    static {
        tensMap.put(0, "ten");
        tensMap.put(1, "eleven");
        tensMap.put(2, "twelve");
        tensMap.put(3, "thirteen");
        tensMap.put(4, "fourteen");
        tensMap.put(5, "fifteen");

        doublePlusDigitMap.put(2, "twenty");
        doublePlusDigitMap.put(3, "thirty");
        doublePlusDigitMap.put(4, "forty");
        doublePlusDigitMap.put(5, "fifty");
        doublePlusDigitMap.put(6, "sixty");
        doublePlusDigitMap.put(7, "seventy");
        doublePlusDigitMap.put(8, "eighty");
        doublePlusDigitMap.put(9, "ninety");
    }

    StringBuffer resultingString = new StringBuffer();
    ArrayList<Integer> numbersByDigit = new ArrayList<>();

    public StringBuffer mainFunction(int number) {
        parcingByNumber(number);
        while (numbersByDigit.size() != 0) {
            if (numbersByDigit.size() > 2) {
                resultingString.append(digitNumber(numbersByDigit));
                if (numbersByDigit.size() == 5 || numbersByDigit.size() == 8) numbersByDigit.remove(0);
            }
            else if (numbersByDigit.size() == 2 ) {
                if (numbersByDigit.get(0) == 1) {
                    resultingString.append(tens(numbersByDigit));
                    numbersByDigit.remove(0);}
                else resultingString.append(tens(numbersByDigit) /*+ ones(numbersByDigit.get(1))*/);
            }
            numbersByDigit.remove(0);
        }
        return resultingString;
    }

    public void parcingByNumber(int number) {
        ArrayList<Integer> rotateString = new ArrayList<>();
        while (number / 10 > 0) {
            rotateString.add(number%10);
            number = number/10;
        }
        rotateString.add(number);
        for (int i = rotateString.size()-1; i >= 0; i--) numbersByDigit.add(rotateString.get(i));
    }

    // from one till nine
    public String ones(int num) {
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

    // fifteen, sixteen, twenty, forty etc.
    public String tens(ArrayList<Integer> tens) {
        String res = "";
        if (tens.get(0) == 1) {
            if (tens.get(1) < 6) res += tensMap.get(tens.get(1));
            else res += ones(tens.get(1)) + "teen";
        }
        else if (tens.get(0) > 1) {
            res += doublePlusDigitMap.get(tens.get(0)) + " " + ones(tens.get(1));
        }
        return res;
    }

    // hundred, thousand, million etc.
    public String digitNumber(ArrayList<Integer> number) {
        String res = "";
        if (number.size() == 3) res += ones(number.get(0)) + " hundred ";
        if (number.size() == 4) res += ones(number.get(0)) + " thousand ";
        if (number.size() == 5) res += tens(number) + " thousand ";
        if (number.size() == 6) res += ones(number.get(0)) + " hundred ";
        if (number.size() == 7) res += ones(number.get(0)) + " million ";
        if (number.size() == 8) res += tens(number) + " million ";
        return res;
    }
}

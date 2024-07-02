import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        try {
            calc(str);
        } catch (Exception e) {
            System.out.println("throws Exception");
        }
    }
    public static String calc(String input) throws Exception {
        WordOrNumber x = new WordOrNumber();
        int n = 0, a = 0, b = 0;
        char operant = ' ';
        boolean rimCh = true;
        int result = 0;
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '/'){
                operant = input.charAt(i);
                n++;
            }
        }
        if(n == 1){
            String[] strArr = input.split(Pattern.quote(" " + (operant) + " "));
            if(x.proverka(strArr[0]) && x.proverka(strArr[1])){
                a = x.convertStringToInt(strArr[0]);
                b = x.convertStringToInt(strArr[1]);
            } else if (!x.proverka(strArr[0]) && !x.proverka(strArr[1])) {
                a = Integer.parseInt(strArr[0]);
                b = Integer.parseInt(strArr[1]);
                rimCh = false;
            } else throw new Exception("An error occurred");
            if(a < 1 || b < 1 || a > 10 || b > 10) {
                throw new Exception("An error occurred");
            } else {
                switch(operant){
                    case '+':
                        result = a + b;
                        break;
                    case '-':
                        result = a - b;
                        break;
                    case '*':
                        result = a * b;
                        break;
                    case '/':
                        result = a / b;
                        break;
                }
                if(rimCh && result > 0) {
                    System.out.println(x.convertIntToString(result));
                } else if(!rimCh) {
                    System.out.println(result);
                } else throw new Exception("An error occurred");
            }
        } else {
            throw new Exception("An error occurred");
        }
        return null;
    }
}

class WordOrNumber {
    String[] numbers = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
            "XII", "XII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI",
            "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX",
            "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII",
            "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI",
            "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI",
            "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV",
            "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII",
            "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI",
            "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII",
            "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII",
            "XCVIII", "XCIX", "C"};

    boolean proverka(String c) {
        boolean result = false;
        for (int n = 0; n < numbers.length; n++) {
            if (c.equals(numbers[n])) {
                result = true;
            }
        }
        return result;
    }
    int convertStringToInt(String c){
        int result = 0;
        for (int n = 0; n < numbers.length; n++) {
            if (c.equals(numbers[n])) {
                result = n;
            }
        }
        return result;
    }
    String convertIntToString(int c){
        String result = "";
        for (int n = 0; n < numbers.length; n++) {
            if (c == n) {
                result = numbers[n];
            }
        }
        return result;
    }
}
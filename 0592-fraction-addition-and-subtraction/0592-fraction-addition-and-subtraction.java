//my God I am seeing lex pattern recognitin everywhere! nice new concept!
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Solution {

    public String fractionAddition(String expression) {
        int LCM = findLCMOfDenominators(expression);
        int finalNum = findNum(LCM, expression);
        int GCD = gcd(Math.abs(finalNum), LCM);
        int ansNum = finalNum / GCD;
        int ansDen = LCM / GCD;
        return String.valueOf(ansNum) + "/" + String.valueOf(ansDen);
    }

    public static int findLCMOfDenominators(String fractions) {
        int lcm = 1; // Start with LCM of 1, since LCM of any number with 1 is the number itself.

        // Regular expression to match fractions
        Pattern pattern = Pattern.compile("-?[0-9]+/([0-9]+)");
        Matcher matcher = pattern.matcher(fractions);

        // Iterate over all the fractions found in the string
        while (matcher.find()) {
            // Extract the denominator (group 1)
            int denominator = Integer.parseInt(matcher.group(1));
            // Calculate LCM with the current denominator
            lcm = lcm(lcm, denominator);
        }

        return lcm;
    }

    // Function to calculate GCD of two numbers
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // Function to calculate LCM of two numbers
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }


    public static int findNum(int LCM, String fractions) {
        int sum = 0; // Start with LCM of 1, since LCM of any number with 1 is the number itself.

        // Regular expression to match fractions
        //[0-9] is same as [0-9]
        Pattern pattern = Pattern.compile("(-?[0-9]+)/([0-9]+)");
        Matcher matcher = pattern.matcher(fractions);

        // Iterate over all the fractions found in the string
        while (matcher.find()) {
            // Extract the denominator (group 1)
            int numerator = Integer.parseInt(matcher.group(1));  // First capturing group: Numerator
            int denominator = Integer.parseInt(matcher.group(2));
            int multiplier = LCM / denominator;
            int newNumerator = numerator * multiplier;
            sum += newNumerator;
        }

        return sum;
    }

}

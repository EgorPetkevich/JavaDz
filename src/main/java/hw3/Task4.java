package hw3;

public class Task4 {
    public static String convertToRoman(int number) {
        StringBuilder roman = new StringBuilder();

        int[] arabicValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < arabicValues.length; i++) {
            while (number >= arabicValues[i]) {
                roman.append(romanNumerals[i]);
                number -= arabicValues[i];
            }
        }

        return roman.toString();
    }

    public static void main(String[] args) {

        System.out.println( convertToRoman(17));
    }
}

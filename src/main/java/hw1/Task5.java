package hw1;

public class Task5 {
    public static boolean isPalindromeDescendant(int number) {
        if (isPalindrome(number)) {
            return true;
        }

        while (true) {
            number = generateDescendant(number);
            if (isPalindrome(number)) {
                return true;
            }
            if (number < 10) {
                break;
            }
        }

        return false;
    }

    private static boolean isPalindrome(int number) {
        String numStr = String.valueOf(number);
        int left = 0;
        int right = numStr.length() - 1;

        while (left < right) {
            if (numStr.charAt(left) != numStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    private static int generateDescendant(int number) {
        String numStr = String.valueOf(number);
        StringBuilder descendant = new StringBuilder();

        for (int i = 0; i < numStr.length() - 1; i += 2) {
            int sum = Character.getNumericValue(numStr.charAt(i)) + Character.getNumericValue(numStr.charAt(i + 1));
            descendant.append(sum);
        }

        return Integer.parseInt(descendant.toString());
    }

    public static void main(String[] args) {
        System.out.println(isPalindromeDescendant(11211230)); // Ожидаемый результат: true
        System.out.println(isPalindromeDescendant(13001120)); // Ожидаемый результат: true
        System.out.println(isPalindromeDescendant(23336014)); // Ожидаемый результат: true
        System.out.println(isPalindromeDescendant(11)); // Ожидаемый результат: true
    }

}

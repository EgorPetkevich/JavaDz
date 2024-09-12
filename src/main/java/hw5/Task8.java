package hw5;

public class Task8 {
    public static void main(String[] args) {
        String inputString = "110101";

        if (isOddLength(inputString)) {
            System.out.println("Строка нечетной длины.");
        }

        if (startsWithZeroOddLengthOrStartsWithOneEvenLength(inputString)) {
            System.out.println("Строка начинается с 0 и имеет нечетную длину, или начинается с 1 и имеет четную длину.");
        }

        if (countOfZerosMultipleOfThree(inputString)) {
            System.out.println("Количество 0 кратно 3.");
        }

        if (notElevenOr111(inputString)) {
            System.out.println("Строка не равна 11 или 111.");
        }

        if (everyOddCharacterIsOne(inputString)) {
            System.out.println("Каждый нечетный символ равен 1.");
        }

        if (atLeastTwoZerosAtMostOneOne(inputString)) {
            System.out.println("Содержит не менее двух 0 и не более одной 1.");
        }

        if (noConsecutiveOnes(inputString)) {
            System.out.println("Нет последовательных 1.");
        }
    }

    static boolean isOddLength(String input) {
        return input.matches("^[01](?:[01]{2})*[01]?$");
    }

    static boolean startsWithZeroOddLengthOrStartsWithOneEvenLength(String input) {
        return input.matches("^(0[01]{2})*(1[01]{2})*$");
    }

    static boolean countOfZerosMultipleOfThree(String input) {
        return input.matches("^(1*01*0){3,}1*$");
    }

    static boolean notElevenOr111(String input) {
        return input.matches("^(?!1{2,3}$)[01]+$");
    }

    static boolean everyOddCharacterIsOne(String input) {
        return input.matches("^0*(1[01])*1*$");
    }

    static boolean atLeastTwoZerosAtMostOneOne(String input) {
        return input.matches("^[^1]*1?[^1]*0[^1]*0[^1]*$");
    }

    static boolean noConsecutiveOnes(String input) {
        return input.matches("^(?:0|10)*(?:0|$)$");
    }
}

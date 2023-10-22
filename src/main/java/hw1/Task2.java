package hw1;

import java.util.Scanner;

public class Task2 {
    public static int countDigits(int number) {
        // Обработка случая с нулем
        if (number == 0) {
            return 1;
        }

        int count = 0;
        // Используем Math.abs() для обработки отрицательных чисел
        int n = Math.abs(number);
        System.out.println(n);
        while (n > 0) {
            n = n / 10;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int inoutNumber = in.nextInt();
        System.out.println(countDigits(inoutNumber));
    }
}

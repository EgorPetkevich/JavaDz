package hw0;

import java.util.Scanner;

public class Task7 {



    public static void main(String[] args) {
        // Пример вызова функции rotateRight с параметрами 16 и 1

        int[] resultRight = rotateRight(8, 1);


        // Пример вызова функции rotateLeft с параметрами 16 и 1
        int[] resultLeft = rotateLeft(16, 1);

    }

    // Функция для сдвига числа вправо
    public static int[] rotateRight(int n, int shift) {
        String binaryStr = Integer.toBinaryString(n);
        int len = binaryStr.length();
        int shiftAmount = shift % len;
        String rotatedBinaryStr = binaryStr.substring(len - shiftAmount) + binaryStr.substring(0, len - shiftAmount);
        int sum = Integer.parseInt(rotatedBinaryStr, 2);

        // Вывод результатов
        System.out.println("rotateRight: " + sum + " " + binaryStr + " " + rotatedBinaryStr);

        // Возвращаем результат в виде массива
        return new int[]{sum, n, Integer.parseInt(rotatedBinaryStr, 2)};
    }

    // Функция для сдвига числа влево
    public static int[] rotateLeft(int n, int shift) {
        String binaryStr = Integer.toBinaryString(n);
        int len = binaryStr.length();
        int shiftAmount = shift % len;
        String rotatedBinaryStr = binaryStr.substring(shiftAmount) + binaryStr.substring(0, shiftAmount);
        int sum = Integer.parseInt(rotatedBinaryStr, 2);

        // Вывод результатов
        System.out.println("rotateLeft: " + sum + " " + binaryStr + " " + rotatedBinaryStr);

        // Возвращаем результат в виде массива
        return new int[]{sum, n, Integer.parseInt(rotatedBinaryStr, 2)};
    }

}


package hw0;

public class Task3 {
    public static boolean isNestable(int[] arr1, int[] arr2) {
        // Проверка условий для вложенности массивов
        if (arr1.length == arr2.length && arr1.length == 0) {
            return true;
        };
        return (getMin(arr1) > getMin(arr2)) && (getMax(arr1) < getMax(arr2));
    }

    // Вспомогательная функция для нахождения минимума в массиве
    private static int getMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    // Вспомогательная функция для нахождения максимума в массиве
    private static int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        // Примеры использования функции
        System.out.println(isNestable(new int[]{1, 2, 3, 4}, new int[]{0, 6}));  // Вывод: true
        System.out.println(isNestable(new int[]{3, 1}, new int[]{4, 0}));        // Вывод: true
        System.out.println(isNestable(new int[]{9, 9, 8}, new int[]{8, 9}));      // Вывод: false
        System.out.println(isNestable(new int[]{1, 2, 3, 4}, new int[]{2, 3}));  // Вывод: false
    }
}

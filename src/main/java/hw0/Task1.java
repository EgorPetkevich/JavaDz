package hw0;

import java.util.Scanner;

public class Task1 {
    public static int convertToSeconds(String time) {
        // Разделение строки на минуты и секунды
        String[] timeComponents = time.split(":");

        // Проверка на корректное количество компонентов
        if (timeComponents.length != 2)  {
            return -1;
        }

        try {
            // Преобразование минут и секунд в целочисленные значения
            int minutes = Integer.parseInt(timeComponents[0]);
            int seconds = Integer.parseInt(timeComponents[1]);

            // Проверка на корректные значения минут и секунд
            if (seconds >= 60) {
                return -1;
            }

            // Вычисление общего времени в секундах
            return minutes * 60 + seconds;
        } catch (NumberFormatException e) {
            // Обработка ошибки преобразования строки в число
            return -1;
        }
    }

    public static void main(String[] args) {
        // Пример использования функции
//        String videoLength = "999:59";
        Scanner in = new Scanner(System.in);
        String videoLength = in.nextLine();
        int totalSeconds = convertToSeconds(videoLength);

        System.out.println(totalSeconds);
    }
}

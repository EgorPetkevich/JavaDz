package hw5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Task1 {
    public static void main(String[] args) {
        String[] sessions = {
            "2022-03-12, 20:20 - 2022-03-12, 23:50",
            "2022-04-01, 21:30 - 2022-04-02, 01:20"
        };

        long totalTimeInMillis = 0;

        for (String session : sessions) {
            totalTimeInMillis += calculateSessionTime(session);
        }

        long averageTimeInMillis = totalTimeInMillis / sessions.length;

        // Вывод времени в формате "чч чм"
        long hours = averageTimeInMillis / (60 * 60 * 1000);
        long minutes = (averageTimeInMillis % (60 * 60 * 1000)) / (60 * 1000);

        System.out.println("Среднее время за сеанс: " + hours + "ч " + minutes + "м");
    }

    public static long calculateSessionTime(String session) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd, HH:mm");

        try {
            String[] sessionTimes = session.split(" - ");
            Date startTime = dateFormat.parse(sessionTimes[0]);
            Date endTime = dateFormat.parse(sessionTimes[1]);

            return endTime.getTime() - startTime.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }
}

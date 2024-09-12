package hw5;

public class Task5 {
    public static void main(String[] args) {
        String licensePlate = "А123ВЕ777";
        boolean isValid = validateLicensePlate(licensePlate);

        if (isValid) {
            System.out.println("Номерной знак валиден.");
        } else {
            System.out.println("Номерной знак не валиден.");
        }
    }

    public static boolean validateLicensePlate(String licensePlate) {
        String regex = "[А-Я]{1}\\d{3}[А-Я]{2}\\d{2,3}";
        return licensePlate.matches(regex);
    }
}

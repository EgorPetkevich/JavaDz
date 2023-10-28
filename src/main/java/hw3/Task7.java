package hw3;
import java.util.Comparator;
import java.util.TreeMap;
public class Task7 {
    public static class NullHandlingComparator implements Comparator<String> {
        @Override
        public int compare(String str1, String str2) {
            if (str1 == null && str2 == null) {
                return 0;
            } else if (str1 == null) {
                return -1;
            } else if (str2 == null) {
                return 1;
            } else {
                return str1.compareTo(str2);
            }
        }

        public void main(String[] args) {
            // Создаем TreeMap с компаратором, который обрабатывает null
            TreeMap<String, String> tree = new TreeMap<>(new NullHandlingComparator());

            // Добавляем null в качестве ключа
            tree.put(null, "test");

            // Проверяем, содержит ли TreeMap null
            boolean containsNull = tree.containsKey(null);

            System.out.println("Contains null: " + containsNull);
        }
    }
}


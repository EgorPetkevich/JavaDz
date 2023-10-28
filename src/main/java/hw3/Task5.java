package hw3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class Task5 {
    public static class Contact {
        private String firstName;
        private String lastName;

        public Contact(String fullName) {
            String[] names = fullName.split(" ");
            if (names.length > 1) {
                this.firstName = names[0];
                this.lastName = names[1];
            } else {
                this.firstName = names[0];
                this.lastName = names[0];
            }
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        @Override
        public String toString() {
            return firstName + " " + lastName;
        }
    }

    public static List<Contact> parseContacts(String[] names, String sortOrder) {
        List<Contact> contacts = new ArrayList<>();

        if (names == null || names.length == 0) {
            return contacts;
        }

        for (String name : names) {
            contacts.add(new Contact(name));
        }

        if (sortOrder.equals("ASC")) {
            Collections.sort(contacts, Comparator.comparing(Contact::getLastName).thenComparing(Contact::getFirstName));
        } else if (sortOrder.equals("DESC")) {
            Collections.sort(contacts, Comparator.comparing(Contact::getLastName, Comparator.reverseOrder()).thenComparing(Contact::getFirstName, Comparator.reverseOrder()));
        }

        return contacts;
    }

    public static void main(String[] args) {
        // Примеры использования
        String[] names1 = {"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"};
        String sortOrder1 = "ASC";
        List<Contact> sortedContacts1 = parseContacts(names1, sortOrder1);
        System.out.println(sortedContacts1);

        String[] names2 = {"Paul Erdos", "Leonhard Euler", "Carl Gauss"};
        String sortOrder2 = "DESC";
        List<Contact> sortedContacts2 = parseContacts(names2, sortOrder2);
        System.out.println(sortedContacts2);

        String[] names3 = {};
        String sortOrder3 = "DESC";
        List<Contact> sortedContacts3 = parseContacts(names3, sortOrder3);
        System.out.println(sortedContacts3);

        String[] names4 = null;
        String sortOrder4 = "DESC";
        List<Contact> sortedContacts4 = parseContacts(names4, sortOrder4);
        System.out.println(sortedContacts4);
    }
}

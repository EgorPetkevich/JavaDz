package hw3;
import hw3.Task5.Contact;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class Task5Test {
    @Test
    public void testParseContactsAscendingOrder() {
        String[] names = {"John Smith", "Alice Johnson", "Bob Brown"};
        List<Contact> contacts = Task5.parseContacts(names, "ASC");
        assertEquals("Bob Brown", contacts.get(0).toString());
        assertEquals("Alice Johnson", contacts.get(1).toString());
        assertEquals("John Smith", contacts.get(2).toString());
    }

    @Test
    public void testParseContactsDescendingOrder() {
        String[] names = {"John Smith", "Alice Johnson", "Bob Brown"};
        List<Contact> contacts = Task5.parseContacts(names, "DESC");
        assertEquals("John Smith", contacts.get(0).toString());
        assertEquals("Alice Johnson", contacts.get(1).toString());
        assertEquals("Bob Brown", contacts.get(2).toString());
    }
    @Test
    public void testParseContactsEmptyArray() {
        String[] names = {};
        List<Contact> contacts = Task5.parseContacts(names, "ASC");
        assertEquals(0, contacts.size());
    }

    @Test
    public void testParseContactsNullArray() {
        List<Contact> contacts = Task5.parseContacts(null, "ASC");
        assertEquals(0, contacts.size());
    }
}

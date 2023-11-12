package hw5;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TaskTest5 {
    @Test
    void testValidLicensePlate() {
        assertTrue(Task5.validateLicensePlate("А123ВЕ777"));
        assertTrue(Task5.validateLicensePlate("О777ОО177"));
    }

    @Test
    void testInvalidLicensePlate() {
        assertFalse(Task5.validateLicensePlate("123АВЕ777"));
        assertTrue(Task5.validateLicensePlate("А123ВГ77"));
        assertFalse(Task5.validateLicensePlate("А123ВЕ7777"));
        assertFalse(Task5.validateLicensePlate("АБВ123456"));
    }

    @Test
    void testEmptyLicensePlate() {
        assertFalse(Task5.validateLicensePlate(""));
    }

}

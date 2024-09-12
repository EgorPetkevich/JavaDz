package hw6;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;
public class TaskTest1 {
}
class DiskMapTest {

    private DiskMap diskMap;

    @BeforeEach
    void setUp() {
        diskMap = new DiskMap("testData.txt");
    }

    @AfterEach
    void tearDown() {

        try {
            java.nio.file.Files.delete(java.nio.file.Paths.get("testData.txt"));
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testSize() {
        assertEquals(0, diskMap.size());
        diskMap.put("key1", "value1");
        assertEquals(1, diskMap.size());
        diskMap.put("key2", "value2");
        assertEquals(2, diskMap.size());
    }

    @Test
    void testIsEmpty() {
        assertTrue(diskMap.isEmpty());
        diskMap.put("key1", "value1");
        assertFalse(diskMap.isEmpty());
    }

    @Test
    void testContainsKey() {
        assertFalse(diskMap.containsKey("key1"));
        diskMap.put("key1", "value1");
        assertTrue(diskMap.containsKey("key1"));
    }

    @Test
    void testContainsValue() {
        assertFalse(diskMap.containsValue("value1"));
        diskMap.put("key1", "value1");
        assertTrue(diskMap.containsValue("value1"));
    }

    @Test
    void testGet() {
        assertNull(diskMap.get("key1"));
        diskMap.put("key1", "value1");
        assertEquals("value1", diskMap.get("key1"));
    }

    @Test
    void testPut() {
        assertNull(diskMap.put("key1", "value1"));
        assertEquals("value1", diskMap.put("key1", "newValue"));
        assertEquals(1, diskMap.size());
    }

    @Test
    void testRemove() {
        assertNull(diskMap.remove("key1"));
        diskMap.put("key1", "value1");
        assertEquals("value1", diskMap.remove("key1"));
        assertEquals(0, diskMap.size());
    }

    @Test
    void testPutAll() {
        Map<String, String> testData = new HashMap<>();
        testData.put("key1", "value1");
        testData.put("key2", "value2");
        diskMap.putAll(testData);
        assertEquals(2, diskMap.size());
    }

    @Test
    void testClear() {
        diskMap.put("key1", "value1");
        diskMap.put("key2", "value2");
        diskMap.clear();
        assertEquals(0, diskMap.size());
        assertTrue(diskMap.isEmpty());
    }

    @Test
    void testKeySet() {
        diskMap.put("key1", "value1");
        diskMap.put("key2", "value2");
        Set<String> keySet = diskMap.keySet();
        assertEquals(2, keySet.size());
        assertTrue(keySet.contains("key1"));
        assertTrue(keySet.contains("key2"));
    }

    @Test
    void testValues() {
        diskMap.put("key1", "value1");
        diskMap.put("key2", "value2");
        Collection<String> values = diskMap.values();
        assertEquals(2, values.size());
        assertTrue(values.contains("value1"));
        assertTrue(values.contains("value2"));
    }

    @Test
    void testEntrySet() {
        diskMap.put("key1", "value1");
        diskMap.put("key2", "value2");
        Set<Map.Entry<String, String>> entrySet = diskMap.entrySet();
        assertEquals(2, entrySet.size());
        assertTrue(entrySet.contains(Map.entry("key1", "value1")));
        assertTrue(entrySet.contains(Map.entry("key2", "value2")));
    }
}

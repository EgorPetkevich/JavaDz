package hw6;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

class DiskMap implements Map<String, String> {
    private final String filePath;
    private final Map<String, String> inMemoryMap;

    public DiskMap(String filePath) {
        this.filePath = filePath;
        this.inMemoryMap = new HashMap<>();
        loadFromFile();
    }

    private void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    inMemoryMap.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, String> entry : inMemoryMap.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    @Override
    public int size() {
        return inMemoryMap.size();
    }

    @Override
    public boolean isEmpty() {
        return inMemoryMap.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return inMemoryMap.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return inMemoryMap.containsValue(value);
    }

    @Override
    public String get(Object key) {
        return inMemoryMap.get(key);
    }

    @Override
    public String put(String key, String value) {
        String previousValue = inMemoryMap.put(key, value);
        saveToFile();
        return previousValue;
    }

    @Override
    public String remove(Object key) {
        String removedValue = inMemoryMap.remove(key);
        saveToFile();
        return removedValue;
    }

    @Override
    public void putAll(Map<? extends String, ? extends String> m) {
        inMemoryMap.putAll(m);
        saveToFile();
    }

    @Override
    public void clear() {
        inMemoryMap.clear();
        saveToFile();
    }

    @Override
    public java.util.Set<String> keySet() {
        return inMemoryMap.keySet();
    }

    @Override
    public java.util.Collection<String> values() {
        return inMemoryMap.values();
    }

    @Override
    public java.util.Set<Entry<String, String>> entrySet() {
        return inMemoryMap.entrySet();
    }

    public static void main(String[] args) {
        DiskMap diskMap = new DiskMap("data.txt");

        // Test the functionality
        diskMap.put("key1", "value1");
        diskMap.put("key2", "value2");
        diskMap.put("key3", "value3");

        System.out.println("Size: " + diskMap.size());
        System.out.println("Contains key 'key2': " + diskMap.containsKey("key2"));
        System.out.println("Contains value 'value3': " + diskMap.containsValue("value3"));

        System.out.println("Get value for 'key1': " + diskMap.get("key1"));

        System.out.println("Removing key 'key2'");
        diskMap.remove("key2");

        System.out.println("Updated size: " + diskMap.size());
    }
}

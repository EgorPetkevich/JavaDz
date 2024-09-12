package hw6;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.Predicate;
public class Task3 {
    public interface AbstractFilter extends DirectoryStream.Filter<Path> {

        boolean accept(Path entry, BasicFileAttributes attrs) throws IOException;

        default AbstractFilter and(AbstractFilter other) {
            return (entry, attrs) -> this.accept(entry, attrs) && other.accept(entry, attrs);
        }

        default AbstractFilter or(AbstractFilter other) {
            return (entry, attrs) -> this.accept(entry, attrs) || other.accept(entry, attrs);
        }

        static AbstractFilter isRegularFile = (entry, attrs) -> attrs.isRegularFile();
        static AbstractFilter isReadable = (entry, attrs) -> Files.isReadable(entry);

        static AbstractFilter sizeGreaterThan(long size) {
            return (entry, attrs) -> attrs.size() > size;
        }

        static AbstractFilter magicNumber(byte... magicBytes) {
            return (entry, attrs) -> {
                try {
                    byte[] fileBytes = Files.readAllBytes(entry);
                    if (fileBytes.length < magicBytes.length) {
                        return false;
                    }
                    for (int i = 0; i < magicBytes.length; i++) {
                        if (fileBytes[i] != magicBytes[i]) {
                            return false;
                        }
                    }
                    return true;
                } catch (IOException e) {
                    return false;
                }
            };
        }

        static AbstractFilter globMatches(String glob) {
            return (entry, attrs) -> entry.getFileName().toString().matches(glob);
        }

        static AbstractFilter regexContains(String regex) {
            return (entry, attrs) -> entry.getFileName().toString().matches(regex);
        }

        @Override
        default boolean accept(Path entry) throws IOException {
            BasicFileAttributes attrs = Files.readAttributes(entry, BasicFileAttributes.class);
            return accept(entry, attrs);
        }
    }

    public class FileFilterExample {

        public static void main(String[] args) {
            Path dir = Paths.get("///");

            DirectoryStream.Filter<Path> filter = AbstractFilter.isRegularFile
                .and(AbstractFilter.isReadable)
                .and(AbstractFilter.sizeGreaterThan(100_000))
                .and(AbstractFilter.magicNumber((byte) 0x89, (byte) 'P', (byte) 'N', (byte) 'G'))
                .and(AbstractFilter.globMatches(".*\\.png"))
                .and(AbstractFilter.regexContains("[-]"));

            try (DirectoryStream<Path> entries = Files.newDirectoryStream(dir, filter)) {
                entries.forEach(System.out::println);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

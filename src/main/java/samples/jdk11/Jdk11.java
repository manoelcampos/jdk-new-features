package samples.jdk11;


import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Jdk11 {
    public static void main(String[] args) {
        fileHandling();
    }

    /**
     * Shows how to use a single method to write content to a file
     * and another single one to read.
     * That makes it really easy to handle files in Java.
     * It's even easer than {@link Files#lines(Path)}
     * introduced in Java 8 (which has the porpuse to process
     * each content file at a time).
     */
    private static void fileHandling() {
        try {
            Path fileName = Files.createTempFile("", "my-file.txt");
            Path filePath = Files.writeString(fileName, "File content");
            String fileContent = Files.readString(filePath);
            System.out.println(fileContent);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}

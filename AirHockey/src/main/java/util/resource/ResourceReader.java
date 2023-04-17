package util.resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ResourceReader {

    public String readText(String filename) {
        try (
                var isr = new InputStreamReader(getFileStream(filename));
                var reader = new BufferedReader(isr)
        ) {
            StringBuilder string = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                string.append(line);
                string.append("\n");
            }
            return string.toString();
        } catch (IOException e) {
            System.out.println("error in reading file");
            return "";
        }
    }

    /** getFileFromResourceAsStream */
    private InputStream getFileStream(String filename) {
        return getClass().getClassLoader().getResourceAsStream(filename);
    }
}

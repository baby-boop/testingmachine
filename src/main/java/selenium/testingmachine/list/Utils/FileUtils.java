package selenium.testingmachine.list.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    // Method to read IDs from the file and return them as a list of strings
    public static List<String> readIdsFromFile(String fileName) throws IOException {
        List<String> ids = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim(); // Remove leading/trailing spaces
                if (!line.isEmpty()) {
                    ids.add(line); // Add only non-empty lines
                }
            }
        }
        return ids;
    }
}

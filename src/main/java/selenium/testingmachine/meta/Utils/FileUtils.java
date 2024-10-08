package selenium.testingmachine.meta.Utils;

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

    public static List<String[]> readIdMenuPairsFromFile(String filePath) {
        List<String[]> idMenuPairs = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split by whitespace (space or tab)
                String[] parts = line.split("\\s+");
                if (parts.length == 2) {
                    String id = parts[0];
                    String menuId = parts[1];
                    idMenuPairs.add(new String[]{id, menuId});
                } else {
                    System.err.println("Invalid line format: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return idMenuPairs;
    }
}

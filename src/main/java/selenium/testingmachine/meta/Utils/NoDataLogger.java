package selenium.testingmachine.meta.Utils;

import selenium.testingmachine.meta.DTO.ErrorTimeoutDTO;
import selenium.testingmachine.meta.DTO.NotFoundRowDTO;

import java.util.ArrayList;
import java.util.List;

public class NoDataLogger {

    private static final List<NotFoundRowDTO> NotFoundRowFields = new ArrayList<>();

    public static void logError(String fileName, String id) {
        System.err.println("metaId: " + id + ", fileName: " + fileName);
        NotFoundRowDTO notFoundRowField = new NotFoundRowDTO(fileName, id);
        NotFoundRowFields.add(notFoundRowField);
    }

    public static List<NotFoundRowDTO> getNotFoundRowField() {
        return NotFoundRowFields;
    }
}

package selenium.testingmachine.config;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ConfigurationBuilder;

public class clearMessage {

    public void clearMessages() {
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .forPackage("selenium.testingmachine")
                .addScanners(Scanners.FieldsAnnotated));

        Set<Field> warningFields = reflections.getFieldsAnnotatedWith(warningMessageField.class);
        Set<Field> errorFields = reflections.getFieldsAnnotatedWith(errorMessageField.class);
        Set<Field> infoFields = reflections.getFieldsAnnotatedWith(infoMessageField.class);

        List<Field> allFields = new ArrayList<>();
        allFields.addAll(warningFields);
        allFields.addAll(errorFields);
        allFields.addAll(infoFields);

        for (Field field : allFields) {
            if (Modifier.isStatic(field.getModifiers())) {
                try {
                    field.setAccessible(true);
                    // System.out.println("Processing field: " + field.getName() + " (Type: " + field.getType() + ")");
                    
                    if (List.class.isAssignableFrom(field.getType())) {
                        @SuppressWarnings("unchecked")
                        List<String> messageList = (List<String>) field.get(null);
                        if (messageList != null) {
                            // System.out.println("Clearing messages for field: " + field.getName());
                            messageList.clear();
                        } else {
                            // System.out.println("Initializing field: " + field.getName());
                            field.set(null, new ArrayList<String>());
                        }
                    } else {
                        // System.out.println("Field is not of type List<String>: " + field.getName());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } else {
                // System.out.println("Field is not static: " + field.getName());
            }
        }
    }
}

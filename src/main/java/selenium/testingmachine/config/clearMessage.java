package selenium.testingmachine.config;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
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

        warningFields.addAll(errorFields);

        for (Field field : warningFields) {
            if (Modifier.isStatic(field.getModifiers())) {
                try {
                    field.setAccessible(true);
                    field.set(null, ""); 
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

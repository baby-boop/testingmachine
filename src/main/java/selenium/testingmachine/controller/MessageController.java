package selenium.testingmachine.controller;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ConfigurationBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import selenium.testingmachine.config.errorMessageField;
import selenium.testingmachine.config.warningMessageField;
import selenium.testingmachine.config.infoMessageField;

@RestController
@RequestMapping("/api")
public class MessageController {

    @GetMapping("/messages")
    
    public List<String> getAlerts() {
        return getMessages();
    }

    private List<String> getMessages() {
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .forPackage("selenium.testingmachine")
                .addScanners(Scanners.FieldsAnnotated)
        );

        Set<Field> warningFields = reflections.getFieldsAnnotatedWith(warningMessageField.class);
        Set<Field> errorFields = reflections.getFieldsAnnotatedWith(errorMessageField.class);
        Set<Field> infoFields = reflections.getFieldsAnnotatedWith(infoMessageField.class);

        List<Field> allFields = new ArrayList<>();
        allFields.addAll(warningFields);
        allFields.addAll(errorFields);
        allFields.addAll(infoFields);

        List<String> messages = new ArrayList<>();

        for (Field field : allFields) {
            if (Modifier.isStatic(field.getModifiers())) {
                try {
                    field.setAccessible(true);
                    @SuppressWarnings("unchecked")
                    List<String> messageList = (List<String>) field.get(null);
                    if (messageList != null && !messageList.isEmpty()) {
                        messages.addAll(messageList);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return messages;
    }
}

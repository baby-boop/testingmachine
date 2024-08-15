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

        List<Field> allFields = new ArrayList<>();
        allFields.addAll(warningFields);
        allFields.addAll(errorFields);


        List<String> messages = new ArrayList<>();

        messages.add("&#8226;Error class: standardBank <br>" + 
                     "&#8226;Class path: selenium.testingmachine.projects.finance.financeStandard.masterData <br>" + 
                     "&#8226;Алдаа: Та системээс гарсан байна. Нэвтэрч орно уу. <br>" + 
                     "&#8226;ProcessName: Тестийн - Тест");

        for (Field field : allFields) {
            if (Modifier.isStatic(field.getModifiers())) {
                try {
                    field.setAccessible(true);
                    String message = (String) field.get(null);
                    if (message != null && !message.isEmpty()) {
                        messages.add(field.getName() + ":" + message);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return messages;
    }
}

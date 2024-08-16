package selenium.testingmachine.controller;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ConfigurationBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import selenium.testingmachine.config.infoMessageField;
import selenium.testingmachine.config.errorMessageField;
import selenium.testingmachine.config.warningMessageField;

@RestController
public class DashboardController {

    private static final String HTML_OPEN_TAG = "<!DOCTYPE html><html lang='en'><head><meta charset='utf-8'>" +
            "<meta name='viewport' content='width=device-width, initial-scale=1'>" +
            "<title>Alerts</title>" +
            "<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css'/>" +
            "<style>" +
            "@import url('https://fonts.googleapis.com/css?family=Roboto:400,700&display=swap');" +
            "body { background-color: #f0f0f0; font-family: 'Roboto', sans-serif; padding: 1rem; margin: 0; }" +
            ".page__title { text-align: center; text-transform: uppercase; }" +
            ".alert__container { background-color: rgba(255,255,255, 0.75); margin: 0 auto; max-width: 900px; padding: 1rem; border-radius: .25rem; border: .125rem solid black; }" +
            ".spacer { margin-bottom: 1rem; }" +
            ".alert { border-radius: .125rem; padding: .5rem; color: black; display: flex; align-items: center; justify-content: space-between; }" +
            ".alert__icon { margin-right: 1rem; }" +
            ".alert__text { font-size: 1rem; flex-grow: 1; }" +
            ".alert__close { background-color: transparent; border: none; cursor: pointer; }" +
            ".alert__close span { font-size: 1rem; }" +
            ".closed { display: none; }" +
            ".alert__warning { background-color: #F8F3D6; }" + 
            ".alert__error { background-color: #ECC8C5; }" +  
            ".alert__info { background-color: #5097ff; }" +
            "@media (max-width: 900px) { .alert__text { font-size: 0.875rem; } }" +
            "</style></head><body><div class='title__container'><h1 class='page__title'>Алдаа гарсан процессуудын жагсаалт</h1></div><div class='alert__container'>";
    private static final String HTML_CLOSE_TAG = "</div><script src='https://code.jquery.com/jquery-3.4.1.js'></script>" +
            "<script>$('.alert__close').click(function() { $(this).parent().addClass('closed'); });</script></body></html>";

    @GetMapping("/dashboard") 
    public String displayAlerts() {

        List<String> messages = getMessages();
        String concatenatedMessages = formatMessagesAsAlerts(messages);
        return wrapWithHtmlBody(concatenatedMessages);
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

    private String formatMessagesAsAlerts(List<String> messages) {
        return messages.stream()
                .map(message -> {
                    String[] parts = message.split(":", 2);
                    String fieldName = parts[0];
                    String fieldMessage = parts[1];
                    
                    String alertClass;
                    if (fieldName.equals("ErrorMessage")) {
                        alertClass = "alert__error";
                    } else if (fieldName.equals("WarningMessage")) {
                        alertClass = "alert__warning";
                    } else {
                        alertClass = "alert__info"; //Бусад тохиолдлыг шалгах
                    }

        
                    return "<div class='alert " + alertClass + " spacer' role='alert'>" +
                            "<i class='fas fa-minus-circle alert__icon'></i>" +
                            "<p class='alert__text'>" + fieldMessage + "</p>" +
                            "<button type='button' class='alert__close' data-dismiss='alert' aria-label='Close'>" +
                            "<span aria-hidden='true'><i class='fas fa-times-circle alert__close'></i></span></button></div>";
                })
                .collect(Collectors.joining());
    }

    private String wrapWithHtmlBody(String content) {
        return HTML_OPEN_TAG + content + HTML_CLOSE_TAG;
    }
}

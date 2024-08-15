package selenium.testingmachine.config;

import java.util.HashSet;
import java.util.Set;

public class ClassCounter {

    private static Set<Class<?>> errClasses = new HashSet<>();
    private static Set<Class<?>> workingClasses = new HashSet<>();
    
    public static void registerClass(Class<?> clazz) {
        errClasses.add(clazz);
    }

    public static int getAllClassCount() {
        return errClasses.size();
    }

    public static Set<Class<?>> getAllClasses() {
        return errClasses;
    }

    //
    public static void registerWorkingClass(Class<?> clazz) {
        workingClasses.add(clazz);
    }

    public static int getWorkingAllClassCount() {
        return workingClasses.size();
    }

    public static Set<Class<?>> getWorkingAllClasses() {
        return workingClasses;
    }


    public static void clearRegisteredClasses() {
        errClasses.clear();
        workingClasses.clear();
    }
}

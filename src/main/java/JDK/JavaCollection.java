package JDK;

import java.lang.reflect.Method;

public class JavaCollection {

    public static void main(String[] args) {
        JavaCollection javaCollection = new JavaCollection();
        javaCollection.annotation();

        try {
            // Get the class
            Class<JavaCollection> myClass = JavaCollection.class;

            // Iterate through the methods of the class
            for (Method method : myClass.getDeclaredMethods()) {
                // Check if MyAnnotation is present on the method
                if (method.isAnnotationPresent(MyAnnotation.class)) {
                    // Get the annotation
                    MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);

                    // Print the annotation details
                    System.out.println("Method: " + method.getName());
                    System.out.println("Value: " + annotation.name());
                    System.out.println("Number: " + annotation.age());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @MyAnnotation(name = "Custom Annotation", age = 10)
    private void annotation() {
        System.out.println("This is an annotation method");
    }
}

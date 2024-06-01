package JDK.variable;

import interview.sort.Employee;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException, InvocationTargetException {

        Class<?> emp = Employee.class;
        Method[] methods = emp.getMethods();
        Object object = emp.newInstance();
        for (Method method : methods) {
            if (method.getName().equals("setId")) {
                method.invoke(object, 1);
            }
            if (method.getName().equals("getId")) {
                System.out.println(method.invoke(object));
            }
        }
        for (Field field : emp.getDeclaredFields()) {
            System.out.println(field.getName());
            System.out.println(field.getType());
        }

    }
}

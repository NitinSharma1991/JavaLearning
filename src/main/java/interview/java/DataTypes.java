package interview.java;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DataTypes {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
//        Range 0 to 65535
        char c = 65535;
        System.out.println(c);
//        1 byte is 8 bits and range is -128 to 127
        byte b = (byte) -129;
        System.out.println(b);

//        All byte, int and short are signed 2nd complement

        float var1 = .3f;
        float var2 = .1f;
        float var3 = var1 - var2;
        System.out.println(var3);

        Class<?> dt = DataTypes.class;

        Method fly = dt.getDeclaredMethod("fly", DataTypes.class);
        fly.invoke(dt.newInstance(),true);



    }

    private void fly(){
        System.out.println("I don't fly");
    }
}

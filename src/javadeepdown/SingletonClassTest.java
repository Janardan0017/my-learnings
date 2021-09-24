package javadeepdown;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonClassTest {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        SingletonClass object1 = SingletonClass.getObject();
        SingletonClass object2 = SingletonClass.getObject();
        System.out.println(object1.hashCode());
        System.out.println(object2.hashCode());

        Constructor<?> constructor = SingletonClass.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        SingletonClass object3 = (SingletonClass) constructor.newInstance();
        System.out.println(object3.hashCode());
    }
}

class SingletonClass {

    private static String token = "isjfas;jfls";

    private static SingletonClass object = null;

    private SingletonClass() {
        if (object != null)
            throw new RuntimeException("Not allowed");
    }

    public static SingletonClass getObject() {
        if (object == null) {
            return new SingletonClass();
        }
        return object;
    }

    protected Object readResolve() {
        return object;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException  {
        throw new CloneNotSupportedException();
    }
}
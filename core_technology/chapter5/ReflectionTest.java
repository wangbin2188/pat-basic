package core_technology.chapter5;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * Created by wangbin10 on 2019/1/3.
 * 通过反射机制打印一个类的基本结构，包含域变量，构造方法和普通方法
 */
public class ReflectionTest {
    public static void main(String[] args) {
        String name;
        if (args.length > 0) {
            name = args[0];
        }
        Scanner scanner = new Scanner(System.in);
        name = scanner.next();
        try {
            Class<?> cl = Class.forName(name);
            Class<?> superclass = cl.getSuperclass();
            /**
             * 将修饰符ID转化为修饰符描述
             */
            String modifiers = Modifier.toString(cl.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.print("class " + name);
            if (superclass != null && superclass != Object.class) {
                System.out.print(" extends " + superclass.getName());
            }
            System.out.print("\n{\n");
            System.out.println();
            printFields(cl);
            System.out.println();
            printConstructs(cl);
            System.out.println();
            printMethods(cl);
            System.out.println("}");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.exit(0);

    }

    private static void printFields(Class cl) {
        Field[] declaredFields = cl.getDeclaredFields();
        for (Field field : declaredFields) {
            Class<?> type = field.getType();
            String name = field.getName();
            String modifiers = Modifier.toString(field.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.println(type.getName() + " " + name + ";");
        }
    }

    private static void printConstructs(Class cl) {
        Constructor[] constructors = cl.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            String name = constructor.getName();
            System.out.print(" ");
            String modifiers = Modifier.toString(constructor.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.print(name + "(");
            Class[] parameterTypes = constructor.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                System.out.print(parameterTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    private static void printMethods(Class cl) {
        Method[] methods = cl.getDeclaredMethods();
        for (Method method : methods) {
            String modifiers = Modifier.toString(method.getModifiers());
            Class<?> returnType = method.getReturnType();
            String name = method.getName();
            if (modifiers.length() > 0) {
                System.out.print(modifiers+" ");
            }
            System.out.print(returnType.getName()+" "+name+"(");
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                if (i > 0) {
                    System.out.print(", ");
                }
                System.out.print(parameterTypes[i].getName());
            }
            System.out.println(");");
        }
    }
}

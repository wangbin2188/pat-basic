package thinking_in_java.chapter15;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LatentReflection {
    public static void main(String[] args) {
        CommunicateReflectively.perform(new SmartDog());
        CommunicateReflectively.perform(new Mime());
    }
}

class Mime {
    public void walkAgainstTheWind() {

    }
    public void sit() {
        System.out.println("pretending to sit");
    }

    public void pushInvisibleWalls() {

    }

    @Override
    public String toString() {
        return "Mime";
    }
}

class SmartDog {
    public void speak() {
        System.out.println("woof");

    }

    public void sit() {
        System.out.println("sitting");
    }

    public void reproduce() {

    }
}

class CommunicateReflectively {
    public static void perform(Object speaker) {
        Class<?> aClass = speaker.getClass();
        try {
            try {
                Method speak = aClass.getMethod("speak");
                speak.invoke(speaker);

            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                System.out.println(speaker+" cannot speak");
            }

            try {
                Method sit = aClass.getMethod("sit");
                sit.invoke(speaker);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                System.out.println(speaker+" cannot sit");
            }
        } catch (Exception e) {
            throw new RuntimeException(speaker.toString(), e);
        }
    }
}
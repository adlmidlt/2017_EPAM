package main;

import entity.Entity;

import java.lang.reflect.Method;
import java.util.Arrays;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Class classHard = Class.forName("entity.Entity");
        Entity entity = (Entity) classHard.newInstance();
        out.println(String.valueOf(entity));

        Method[] methods = entity.getClass().getDeclaredMethods();
        Arrays.stream(methods).map(method -> method.getName() +
                Arrays.toString(method.getDeclaredAnnotations())).forEach(out::println);
    }
}

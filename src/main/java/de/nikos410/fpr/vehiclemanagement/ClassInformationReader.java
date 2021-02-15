package de.nikos410.fpr.vehiclemanagement;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ClassInformationReader {
    private static final String LINE_BREAK = String.format("%n");
    private static final int INDENT_DEPTH = 4;
    private static final String INDENT = " ".repeat(INDENT_DEPTH);

    public static void main(String[] args) throws ClassNotFoundException {
        final Class<?> electricPassengerCarClass = Class.forName("de.nikos410.fpr.vehiclemanagement.model.ElectricPassengerCar");
        System.out.println(formatClassInformation(electricPassengerCarClass));
    }

    public static String formatClassInformation(Class<?> theClass) {
        return formatClassHeader(theClass) +
                LINE_BREAK +
                formatConstructors(theClass) +
                LINE_BREAK +
                formatFields(theClass) +
                LINE_BREAK +
                formatMethods(theClass) +
                LINE_BREAK +
                formatClassFooter();
    }

    private static String formatClassHeader(Class<?> theClass) {
        return "class " + formatClassName(theClass) + " {" + LINE_BREAK;
    }

    private static String formatClassName(Class<?> theClass) {
        final String className = theClass.getName();

        final Class<?> superClass = theClass.getSuperclass();
        if (superClass == null || superClass.equals(Object.class)) {
            return className;
        } else {
            return className + " extends " + superClass.getName();
        }
    }

    private static String formatConstructors(Class<?> theClass) {
        return Arrays.stream(theClass.getDeclaredConstructors())
                .map(ClassInformationReader::formatConstructor)
                .map(c -> INDENT + c + ";")
                .collect(Collectors.joining(LINE_BREAK))
                + LINE_BREAK;
    }

    private static String formatConstructor(Constructor<?> constructor) {
        final StringBuilder builder = new StringBuilder();

        final int modifiers = constructor.getModifiers();
        if (modifiers != 0) {
            builder.append(Modifier.toString(modifiers));
            builder.append(" ");
        }

        builder.append(constructor.getName());
        builder.append("(");
        builder.append(formatConstructorParameters(constructor));
        builder.append(")");

        return builder.toString();
    }

    private static String formatConstructorParameters(Constructor<?> constructor) {
        return Arrays.stream(constructor.getParameterTypes())
                .map(Class::getName)
                .collect(Collectors.joining(", "));
    }

    private static String formatMethods(Class<?> theClass) {
        return Arrays.stream(theClass.getDeclaredMethods())
                .filter(m -> !m.isSynthetic())
                .map(ClassInformationReader::formatMethod)
                .map(m -> INDENT + m + ";")
                .collect(Collectors.joining(LINE_BREAK))
                + LINE_BREAK;
    }

    private static String formatMethod(Method method) {
        final StringBuilder builder = new StringBuilder();

        final int modifiers = method.getModifiers();
        if (modifiers != 0) {
            builder.append(Modifier.toString(modifiers));
            builder.append(" ");
        }

        builder.append(method.getReturnType().getName());
        builder.append(" ");

        builder.append(method.getName());
        builder.append("(");
        builder.append(formatMethodParameters(method));
        builder.append(")");

        return builder.toString();
    }

    private static String formatMethodParameters(Method method) {
        return Arrays.stream(method.getParameterTypes())
                .map(Class::getName)
                .collect(Collectors.joining(", "));
    }

    private static String formatFields(Class<?> theClass) {
        return Arrays.stream(theClass.getDeclaredFields())
                .map(ClassInformationReader::formatField)
                .map(f -> INDENT + f + ";")
                .collect(Collectors.joining(LINE_BREAK))
                + LINE_BREAK;
    }

    private static String formatField(Field field) {
        final StringBuilder builder = new StringBuilder();

        final int modifiers = field.getModifiers();
        if (modifiers != 0) {
            builder.append(Modifier.toString(modifiers));
            builder.append(" ");
        }

        builder.append(field.getType().getName());
        builder.append(" ");
        builder.append(field.getName());

        return builder.toString();
    }

    private static String formatClassFooter() {
        return "}" + LINE_BREAK;
    }
}

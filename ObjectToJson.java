package AssignmentReflections;


import java.lang.reflect.Field;

import java.lang.reflect.Field;

class Employee {
    private String name;
    private int age;
    private boolean isManager;

    public Employee(String name, int age, boolean isManager) {
        this.name = name;
        this.age = age;
        this.isManager = isManager;
    }
}

public class ObjectToJson {
    public static String toJson(Object obj) throws IllegalAccessException {
        Class<?> cls = obj.getClass();
        StringBuilder json = new StringBuilder("{");

        Field[] fields = cls.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            String fieldName = fields[i].getName();
            Object fieldValue = fields[i].get(obj);
            if (fieldValue instanceof String) {
                json.append("\"").append(fieldName).append("\": \"").append(fieldValue).append("\"");
            } else {
                json.append("\"").append(fieldName).append("\": ").append(fieldValue);
            }

            if (i < fields.length - 1) {
                json.append(", ");
            }
        }

        json.append("}");
        return json.toString();
    }

    public static void main(String[] args) throws IllegalAccessException {
        Employee emp = new Employee("Sneha",21, true);
        String jsonString = toJson(emp);
        System.out.println(jsonString);
    }
}




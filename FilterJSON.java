package JSON;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.ArrayList;
import java.util.List;

class People {
    private String name;
    private int age;

    public People() {
    }

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}
public class FilterJSON {
    public static void main(String[] args) {
        String jsonArray = "[{\"name\":\"Alice\",\"age\":30},{\"name\":\"Bob\",\"age\":25},{\"name\":\"Charlie\",\"age\":28}]";

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<People> personList = objectMapper.readValue(jsonArray, new TypeReference<List<People>>() {});

            List<People> filteredList = new ArrayList<>();
            for (People person : personList) {
                if (person.getAge() > 25) {
                    filteredList.add(person);
                }
            }

            System.out.println("Filtered records (age > 25):");
            for (People person : filteredList) {
                System.out.println(person);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

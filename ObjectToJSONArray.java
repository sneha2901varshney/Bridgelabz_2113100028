package JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class ObjectToJSONArray {
    public static void main(String[] args) {
        try {
            List<People> personList = new ArrayList<>();
            personList.add(new People("Sneha", 21));
            personList.add(new People("Shreya", 17));
            personList.add(new People("Tejaswa", 15));

            ObjectMapper objectMapper = new ObjectMapper();
            String jsonArray = objectMapper.writeValueAsString(personList);

            System.out.println(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


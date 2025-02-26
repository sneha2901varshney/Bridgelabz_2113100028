package JSON;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

class User {
    public String name;
    public int age;
    public JSONArray subjects;
    public User(String name, int age, JSONArray subjects)
    {
        this.name = name;
        this.age = age;
        this.subjects = subjects;
    }
}
public class StudentMain {
    public static void main(String[] args) {
        try {
            JSONArray subjects = new JSONArray();
            subjects.put("Java");
            subjects.put("Spring");
            subjects.put("DSA");
            subjects.put("HTML");
            subjects.put("CSS");

            JSONObject user = new JSONObject();
            user.put("name" , "Sneha");
            user.put("age" , 21);
            user.put("subjects", subjects);

            System.out.println(user.toString());

        }
             catch (Exception e) {
            e.printStackTrace();
        }
    }
}


package level2and3;

@JsonSerializable(directory = "/tmp/json/")

public class Person {
    private String name;
    private int age;
    private String email;

    public Person(String name, int age, String email){
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String getName(){
        return this.name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }
}

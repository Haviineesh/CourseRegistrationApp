public class User {

    // inheritance super class

    private String name;
    private int age;
    private String address;
      
    // name only
    public User(){
        
    }
    public User(String name) {
        this.name = name;

    }

    // name and age
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public int getage() {
        return age;
    }

    public void setage(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "name= " + name + ", age= " + age + ", address= " + address;
    }

}
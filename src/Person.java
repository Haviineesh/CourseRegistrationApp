public class Person {

    private String name;
    private String gender;
    private String address;
  
    public Person(String name, String gender, String address) {
      this.name = name;
      this.gender = gender;
      this.address = address;
    }

    public String getName() {
      return name;
    }
  
    public String getGender() {
      return gender;
    }
  
    public String getAddress() {
      return address;
    }
  
    public void setName(String name) {
      this.name = name;
    }
  
    public void setGender(String gender) {
      this.gender = gender;
    }
  
    public void setAddress(String address) {
      this.address = address;
    }
  
    @Override
    public String toString() {
      return "name=" + name + ", gender=" + gender + ", address=" + address;
    }
  
  }
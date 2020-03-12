package lesson3;

public class Person {
    private String idName;
    private String idAll;
    private String name;
    private String phone;
    private String email;

    public Person(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.idName = String.valueOf(name.hashCode());
        this.idAll = String.valueOf(phone.hashCode() + email.hashCode() + name.hashCode());
    }
    public String getIdName() {
        return idName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getIdAll() {
        return idAll;
    }

    public String getName() {
        return name;
    }

}

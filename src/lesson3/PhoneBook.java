package lesson3;

import java.util.*;

public class PhoneBook{
    private LinkedHashMap<String, String> phone;
    private LinkedHashMap<String, String> email;
    private LinkedHashMap<String, String> name = new LinkedHashMap<>();
    private LinkedList<Person> person =  new LinkedList<>();


    public PhoneBook() {
        this.email = new LinkedHashMap<>();
        this.phone = new LinkedHashMap<>();
    }


    public void add(String addName, String addEmail, String addPhone) {
        person.add(new Person(addName,addEmail,addPhone));
        Person p = person.get(person.size()-1);
        email.put(p.getIdAll(),p.getEmail());
        phone.put(p.getIdAll(),p.getPhone());
        name.put(p.getName(),p.getIdName());
    }

    public ArrayList<String> getEmailByName(String findName) {
        ArrayList<String> emailByName = new ArrayList<>();
        String selIdName = name.get(findName);
        for (Person p : person) {
            if (p.getIdName().equals(selIdName)) {
                emailByName.add(email.get(p.getIdAll()));
            }
        }
        return emailByName;
    }

    public ArrayList<String> getPhoneByName(String findName) {
        ArrayList<String> phoneByName = new ArrayList<>();
        String selIdName = name.get(findName);
        for (Person p : person) {
            if (p.getIdName().equals(selIdName)) {
                phoneByName.add(phone.get(p.getIdAll()));
            }
        }
        return phoneByName;
    }
}

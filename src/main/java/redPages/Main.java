package redPages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Miles", "303-465-8910");
        phoneBook.add("Jamal", "304-465-8910");
        phoneBook.add("Amina", "305-465-8910");
        phoneBook.add("Nerea", "306-465-8910");
        phoneBook.add("Baraka", "307-465-8910");
        phoneBook.add("Tuli", "308-465-8910");

        List<String> myNumbers = new ArrayList<>();
        myNumbers.add("309-001-6789");
        myNumbers.add("309-002-6789");
        myNumbers.add("309-003-6789");
        phoneBook.addAll("Pierre", myNumbers);

        System.out.println(phoneBook.hasEntry("Jamal"));
        phoneBook.remove("Jamal");
        System.out.println(phoneBook.hasEntry("Jamal"));

        System.out.println(phoneBook.lookup("Pierre"));

        System.out.println(phoneBook.reverseLookUp("309-002-6788"));


        for(Map.Entry<String, List<String>> entry : phoneBook.getPhoneRecord().entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        List<String> contacts = phoneBook.getAllContactNames();
        System.out.println(contacts);


    }
}

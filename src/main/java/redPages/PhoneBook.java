package redPages;

import java.util.*;

public class PhoneBook {

    private Map<String, List<String>> phoneRecord;

    public Map<String, List<String>> getPhoneRecord() {
        return phoneRecord;
    }

    public PhoneBook(){
        this(new HashMap<>());
    }

    public PhoneBook(Map<String, List<String>> phoneRecord){
        this.phoneRecord = phoneRecord;
    }

    public void add(String name, String phoneNumber){
        List<String> numbers = new ArrayList<>();
        numbers.add(phoneNumber);
        phoneRecord.put(name, numbers);
    }

    public void addAll(String name, List<String> phoneNumbers){
        phoneRecord.put(name, phoneNumbers);

    }

    public void remove(String name){
        phoneRecord.remove(name);
    }

    public boolean hasEntry(String name){
        if (phoneRecord.containsKey(name)){
            return true;
        } else {
            return false;
        }

    }

    public List<String> lookup(String name){
        return phoneRecord.get(name);
    }

    public String reverseLookUp(String phoneNumber){
        String contactPresent = "";

        for(Map.Entry<String, List<String>> entry: phoneRecord.entrySet()){
            if(entry.getValue().contains(phoneNumber)) {
                contactPresent =entry.getKey();
            }else{
                contactPresent = "Contact not found";
            }

        }
        return contactPresent;
    }

    public List<String> getAllContactNames(){
        List<String> contacts = new ArrayList<>();
        Iterator<Map.Entry<String, List<String>>> iterate = phoneRecord.entrySet().iterator();
        while(iterate.hasNext()){
            Map.Entry<String, List<String>> entry = iterate.next();
            contacts.add(entry.getKey());
        }
        return contacts;
    }

    @Override
    public String toString() {
        return "PhoneBook " +
                "Contacts:\n" + phoneRecord +
                '\n';
    }

}

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
        //check for an existing entry
        //getOrDefault
        List<String> numbers = new ArrayList<>();
        numbers.add(phoneNumber);
        phoneRecord.put(name, numbers);
    }

    public void addAll(String name,List<String> phoneNumbers){
        if(phoneRecord.containsKey(name)){
            List<String> existingPhoneNumbers = phoneRecord.get(name);
            existingPhoneNumbers.addAll(phoneNumbers);
            phoneRecord.put(name, existingPhoneNumbers);
        } else {
            phoneRecord.put(name, phoneNumbers);
        }
    }

    public void remove(String name){
        if (phoneRecord.containsKey(name)){
            phoneRecord.remove(name);
        } else {
            String message = "Cannot delete contact that's not in PhoneBook";
            System.out.println(message);
        }

    }

    public boolean hasEntry(String name){
        if (phoneRecord.containsKey(name)){
            return true;
        } else {
            return false;
        }

    }

    public List<String> lookup(String name){
        List<String> phoneNumbers = new ArrayList<>();
        if(phoneRecord.containsKey(name)){
            phoneNumbers.addAll(phoneRecord.get(name));
        }
       return phoneNumbers;
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

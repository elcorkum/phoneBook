package redPages;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookShould {
    PhoneBook phoneBook = new PhoneBook();


    @Test
    @DisplayName("allowCreationOfPhoneBookWithDefaultConstructor")
    public void createPhoneBookWithoutParameter(){
        assertTrue(phoneBook.getPhoneRecord() instanceof HashMap);
    }
    @DisplayName("allowCreationOfPhoneBookWithParameterizedConstructor")
    @Test
    public void createPhoneBookWithParameter(){
        Map<String, List<String>> phoneRecords = new HashMap<>();
        PhoneBook phoneBook = new PhoneBook(phoneRecords);
        assertTrue(phoneBook.getPhoneRecord().isEmpty());
        assertTrue(phoneRecords.equals(phoneBook.getPhoneRecord()));

    }
    @Test
    @DisplayName("allowAdditionOfListOfPhoneNumbersToNewConTact")
    public void addListOfNumbers(){
        String[] phoneNumbers = {"301-302-3034", "302-302-3034", "303-302-3034", "304-302-3034"};
        assertFalse(phoneBook.getPhoneRecord().containsKey("Juno"));
        phoneBook.addAll("Juno", Arrays.asList(phoneNumbers));
        assertTrue(phoneBook.getPhoneRecord().containsKey("Juno"));
        assertEquals(4, phoneBook.getPhoneRecord().get("Juno").size());
    }
    @Test
    @DisplayName("allowAdditionOfListOfPhoneNumbersToExistingConTact")
    public void addListOfNumbersToExistingContact(){
        String[] phoneNumbers = {"301-302-3034", "302-302-3034", "303-302-3034", "304-302-3034"};
        phoneBook.add("Juno", "202-987-6543");
        assertTrue(phoneBook.getPhoneRecord().containsKey("Juno"));
        assertEquals(List.of("202-987-6543"), phoneBook.getPhoneRecord().get("Juno"));
        phoneBook.addAll("Juno", Arrays.asList(phoneNumbers));
        List<String> expected = List.of("202-987-6543", "301-302-3034", "302-302-3034", "303-302-3034", "304-302-3034");
        assertEquals(expected, phoneBook.getPhoneRecord().get("Juno"));
    }


    @Test
    @DisplayName("allowPhoneBookEntryToBeDeleted")
    public void deleteContactFromPhoneBook(){
        phoneBook.addAll("Rain", List.of("545-908-2431", "123-233-2345"));
        phoneBook.remove("Rain");
        assertFalse(phoneBook.getPhoneRecord().containsKey("Rain"));
    }

    @Test
    @DisplayName("returnNameOfContactGivenPhoneNumber")
    public void getContactNameGivenTheirPhoneNumber(){
        String[] phoneNumbers = {"585-908-2431", "585-908-2731"};
        phoneBook.addAll("Joel", Arrays.asList(phoneNumbers));
        assertEquals("Joel", phoneBook.reverseLookUp("585-908-2731"));
    }
}
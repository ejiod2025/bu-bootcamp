import java.util.*;

public class ContactManager {
    public static void main(String[] args) {
        HashMap<String, Contact> contacts = new HashMap<>();

        contacts.put("Ada Lovelace",
                new Contact("Ada Lovelace", "+1 617 555 0101"));
        contacts.put("Alan Turing",
                new Contact("Alan Turing", "+44 20 7946 0958"));
        contacts.put("Grace Hopper",
                new Contact("Grace Hopper", "+1 212 555 0142"));
        contacts.put("Katherine Johnson",
                new Contact("Katherine Johnson", "+1 757 555 0188"));
        contacts.put("Margaret Hamilton",
                new Contact("Margaret Hamilton", "+1 617 555 0199"));

        System.out.println("=== Contact Lookup ===");

        String knownName = "Ada Lovelace";
        System.out.println("Searching for: " + knownName);
        Contact foundContact = contacts.get(knownName);
        if (foundContact == null) {
            System.out.println("Contact not found.");
        } else {
            System.out.println("Found: " + foundContact);
        }

        System.out.println();

        String unknownName = "Nikola Tesla";
        System.out.println("Searching for: " + unknownName);
        Contact missingContact = contacts.get(unknownName);
        if (missingContact == null) {
            System.out.println("Contact not found.");
        } else {
            System.out.println("Found: " + missingContact);
        }

        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());
        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));

        System.out.println();
        System.out.println("=== All Contacts ===");
        for (Contact contact : sorted) {
            System.out.println(contact);
        }
    }
}

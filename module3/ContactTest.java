import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactTest {
    private Contact contact;

    @BeforeEach
    void setUp() {
        contact = new Contact("Ada Lovelace", "+1 617 555 0101");
    }

    @Test
    void getNameReturnsContactName() {
        assertEquals("Ada Lovelace", contact.getName());
    }

    @Test
    void getPhoneReturnsContactPhone() {
        assertEquals("+1 617 555 0101", contact.getPhone());
    }

    @Test
    void toStringReturnsNameAndPhone() {
        assertEquals("Ada Lovelace | +1 617 555 0101", contact.toString());
    }

    @Test
    void nameCanContainSpaces() {
        Contact spacedName = new Contact("Katherine G. Johnson", "555-0102");

        assertEquals("Katherine G. Johnson", spacedName.getName());
    }

    @Test
    void phoneCanContainFormattingCharacters() {
        Contact formattedPhone = new Contact("Grace Hopper", "+1 (212) 555-0142");

        assertEquals("+1 (212) 555-0142", formattedPhone.getPhone());
    }
}

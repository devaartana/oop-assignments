package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import main.SalesItem; 

public class SalesItemTest {
    
    @Test
    public void testAddComment() {
        SalesItem item = new SalesItem("Sample Item", 2500);
        assertTrue(item.addComment("Alice", "Good product", 5));
        assertEquals(1, item.getNumberOfComments());
    }

    @Test
    public void testAddDuplicateComment() {
        SalesItem item = new SalesItem("Sample Item", 2500);
        item.addComment("Alice", "Good product", 5);
        assertFalse(item.addComment("Alice", "Trying duplicate", 4));
    }
    
    @Test
    public void testRemoveComment() {
        SalesItem item = new SalesItem("Sample Item", 2500);
        item.addComment("Alice", "Good product", 5);
        item.removeComment(0);
        assertEquals(0, item.getNumberOfComments());
    }

}

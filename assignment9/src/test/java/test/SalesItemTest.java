package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.SalesItem;
import main.Comment;

public class SalesItemTest {

    private SalesItem item;

    @BeforeEach
    public void setUp() {
        item = new SalesItem("Updated Item", 3000);
        item.addComment("Bob", "Excellent quality!", 5);
        item.addComment("Alice", "Good product", 4);
    }

    @Test
    public void testAddComment() {
        assertTrue(item.addComment("Charlie", "Great value!", 5));
        assertEquals(3, item.getNumberOfComments());
    }

    @Test
    public void testAddCommentWithBoundaryRatingZero() {
        assertTrue(item.addComment("BoundaryUser1", "Rating at minimum", 0));
    }

    @Test
    public void testAddCommentWithBoundaryRatingFive() {
        assertTrue(item.addComment("BoundaryUser2", "Rating at maximum", 5));
    }

    @Test
    public void testAddDuplicateComment() {
        assertFalse(item.addComment("Bob", "Duplicate attempt", 4));
    }
    
    @Test
    public void testRemoveComment() {
        item.removeComment(0);
        assertEquals(1, item.getNumberOfComments());
    }

    @Test
    public void testFindMostHelpfulComment() {
        item.upvoteComment(0);
        item.upvoteComment(0);
        item.upvoteComment(1);

        Comment mostHelpful = item.findMostHelpfulComment();
        assertEquals("Bob", mostHelpful.getAuthor());
        assertEquals(2, mostHelpful.getVoteCount());
    }
    
    @Test
    public void testFindMostHelpfulCommentWithNoVotes() {
        SalesItem newItem = new SalesItem("No Votes Item", 1500);
        newItem.addComment("Tom", "No votes yet", 3);
        newItem.addComment("Jerry", "Also no votes", 4);

        Comment mostHelpful = newItem.findMostHelpfulComment();
        assertNotNull(mostHelpful);
        assertEquals("Tom", mostHelpful.getAuthor()); 
    }

    @Test
    public void testFindMostHelpfulCommentWithEmptyComments() {
        SalesItem emptyItem = new SalesItem("Empty Comments Item", 2000);

        Comment mostHelpful = emptyItem.findMostHelpfulComment();
        assertNull(mostHelpful);
    }

    @Test
    public void testUpvoteComment() {
        item.upvoteComment(0);
        assertEquals(1, item.findMostHelpfulComment().getVoteCount());
    }

    @Test
    public void testDownvoteComment() {
        item.downvoteComment(1);
        assertEquals(0, item.findMostHelpfulComment().getVoteCount());
    }

    @Test
    public void testInvalidRating() {
        assertFalse(item.addComment("Eve", "Bad rating", -1));
        assertFalse(item.addComment("Eve", "Bad rating", 6));
    }
}

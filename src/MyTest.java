import org.junit.Test;
import static org.junit.Assert.*;

public class MyTest {
    
    @Test
    public void testName() {
        System.out.println("Test of getUser function");
        Note instance = new Note("AbdulBasit", "Nothing Special, just routine test :P ", 1);
        String expResult = "AbdulBasit";
        String result = instance.getUser();
        assertEquals(expResult, result);
        System.out.println("Test Passed");
    }

    
    @Test
    public void testNotes() {
        System.out.println("Test of  getNotes function");
        Note instance = new Note("AbdulBasit", "Nothing Special, just routine test :P ", 1);
        String expResult = "Nothing Special, just routine test :P ";
        String result = instance.getNotes();
        assertEquals(expResult, result);
        System.out.println("Test Passed");
    }
    
}
